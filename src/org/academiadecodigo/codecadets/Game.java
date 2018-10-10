package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.Configs.GameConfigs;
import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.codecadets.handlers.DuckKeyboardHandler;
import org.academiadecodigo.codecadets.handlers.DuckMouseHandler;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;

public class Game {

    private Position cursorPos;
    private Renderer renderer;
    private Player player;
    private DuckMouseHandler mouseHandler;

    // Game Properties
    private boolean gameEnded;
    private GameStates gameState;
    private List<Target> targetLinkedList;
    private DuckKeyboardHandler keyboardHandler;

    private boolean restartGame;
    private boolean forceRestart;
    private boolean updateCursorPos;

    private boolean handlersCreated;

    public Game() {
        this.restartGame = true;
        this.handlersCreated = false;
    }

    public void init(String player) {
        if (renderer != null) {
            renderer.deleteAll();
        }

        this.player = new Player(player);
        this.renderer = new Renderer();
        this.renderer.initRender();
        this.targetLinkedList = new LinkedList<>();
        this.keyboardHandler = new DuckKeyboardHandler(this);
        this.mouseHandler = new DuckMouseHandler(this, this.renderer);
        mouseHandler.initMouse();

        if (!handlersCreated) {
            mouseHandler.initMouseClick();
            keyboardHandler.activateControls();
            handlersCreated = true;
        }

    }

    public void gameStart(){


        for (int i = 0; i < GameConfigs.TARGETS_NUMBER; i++) {
            targetLinkedList.add(FactoryTargets.createEnemy());
        }

        player.changeWeapon(FactoryWeapons.createWeapon());
        player.getScore().resetScore();
        renderer.drawClips(player.getWeapon().getType().getClips());
        renderer.reloadAmmo(player.getWeapon().getType().getClipBullets());
        renderer.drawWeapon(player.getWeapon());
        renderer.drawScore(player.getScore().getScore());
        this.gameState = GameStates.GAMEPLAYING;
        this.gameEnded = false;
        this.forceRestart = false;

        while(!gameEnded){
            try {
                Thread.sleep(GameConfigs.GAME_SLEEP_TIME);
            } catch (InterruptedException ex) {
                System.out.println("Game Loop Exception: " + ex.getMessage());
            }

            tick();
        }

        switch (gameState) {
            case GAMEENDEDNOAMMO:
            case GAMEENDED:
                Text endGameTxt = renderer.newText(renderer.getCanvas().getWidth() / 2 - 50, 200, 100, 20, "Game Over! Press X To Exit! Press R to restart!");
                if (gameState == GameStates.GAMEENDEDNOAMMO) {
                    Text endGameTxtNoAmmo = renderer.newText(500, 170, 60, 20, "No More Ammo");
                }

                gameEnded();
                break;
            default:
                System.out.println("WTF game state is that?: " + gameState.name());
        }
    }

    private void gameEnded() {
        while (gameEnded && restartGame) {
            try {
                Thread.sleep(GameConfigs.GAME_SLEEP_TIME);
            } catch (InterruptedException ex) {
                System.out.println("Game Loop Exception: " + ex.getMessage());
            }
        }
    }

    private void tick() {
        // Check if no more ammo
        if (player.getWeapon().getAmmo() == 0 &&
                player.getWeapon().getClips() == 0) {
            this.gameEnded = true;
            this.gameState = GameStates.GAMEENDEDNOAMMO;
        }

        //Change every target Position && Remove if out of window
        LinkedList<Target> toRemove = new LinkedList<>();
        for (Target myTarget : targetLinkedList) {
            if (myTarget.getPicture().getX() >= renderer.getCanvas().getWidth() -
                    myTarget.getPicture().getWidth() - myTarget.getSpeedX()) {

                toRemove.add(myTarget);
                myTarget.getPicture().delete();
            }


            try {
                myTarget.move();
            } catch (ConcurrentModificationException ex) {
                System.out.println("Faulty Frame!");
            }


        }
        targetLinkedList.removeAll(toRemove);

        if (updateCursorPos) {
            renderer.drawAim(cursorPos);
            updateCursorPos = false;
        }

        //Check if force Restarted
        if (forceRestart) {
            gameEnded = true;
            gameState = GameStates.GAMEENDED;
        }
    }

    public void eventShoot(){
        Weapon weapon = player.getWeapon();
        boolean killedOne = false;

        LinkedList<Target> toRemote = new LinkedList<>();
        for (Target target : targetLinkedList) {
            if (target == null || target.getPosition() == null) {
                continue;
            }

            if (weapon.getAim().getX() < target.getPosition().getX() - weapon.getType().getSpread()) {
                continue;
            }

            if (weapon.getAim().getX() > target.getPosition().getX() + target.getPicture().getWidth() + weapon.getType().getSpread()) {
                continue;
            }

            if (weapon.getAim().getY() < target.getPosition().getY() - weapon.getType().getSpread()) {
                continue;
            }

            if (weapon.getAim().getY() > target.getPosition().getY() + target.getPicture().getHeight() + weapon.getType().getSpread()) {
                continue;
            }


            if (target instanceof Enemy) {
                Enemy ourEnemy = (Enemy) target;
                int enemyScore = ourEnemy.getType().getScore();

                if (!killedOne) {

                    if (getPlayer().getWeapon().getAmmo() > 0) {
                        boolean enemyKilled = weapon.shoot(target);

                        if (enemyKilled) {
                            player.getScore().changeScore(enemyScore);
                            toRemote.add(target);
                            target.getPicture().delete();
                            killedOne = true;
                        }
                    }
                }
            }

            renderer.drawAmmo(player.getWeapon().getAmmo(), player.getWeapon().getType().getClipBullets());
            renderer.drawClips(player.getWeapon().getClips());
            renderer.drawScore(player.getScore().getScore());
        }
        targetLinkedList.removeAll(toRemote);
        if (!toRemote.isEmpty()) {
            return;
        }

        weapon.shoot(null);
        renderer.drawAmmo(player.getWeapon().getAmmo(), player.getWeapon().getType().getClipBullets());
        renderer.drawClips(player.getWeapon().getClips());
    }

    public void reloadWeapon() {
        this.player.getWeapon().reload();
        renderer.reloadAmmo(player.getWeapon().getType().getClipBullets());
        renderer.drawClips(player.getWeapon().getClips());
    }

    public void eventRestart() {
        this.gameEnded = false;
        this.restartGame = true;
    }

    public Player getPlayer() {
        return this.player;
    }

    public GameStates getGameState() {
        return this.gameState;
    }

    public void setRestartGame(boolean restartGame) {
        this.restartGame = restartGame;
    }

    public void setForceRestart(boolean forceRestart) {
        this.forceRestart = forceRestart;
    }

    public boolean getRestartGame() {
        return restartGame;
    }
}

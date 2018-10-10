package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.Configs.GameConfigs;
import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.enums.TargetType;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.codecadets.handlers.DuckKeyboardHandler;
import org.academiadecodigo.codecadets.handlers.DuckMouseHandler;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Game {

    private Renderer renderer;
    private Player player;
    private DuckMouseHandler mouseHandler;
    private DuckKeyboardHandler keyboardHandler;

    // Game Properties
    private boolean gameEnded;
    private GameStates gameState;
    private Set<Target> targetHashList;

    private boolean restartGame;
    private boolean forceRestart;
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
        this.targetHashList = new HashSet<>();
        this.keyboardHandler = new DuckKeyboardHandler(this);
        this.mouseHandler = new DuckMouseHandler(this, this.renderer);
        mouseHandler.initMouse();

        if (!handlersCreated) {
            mouseHandler.initMouseClick();
            keyboardHandler.activateControls();
            handlersCreated = true;
        }

    }

    public void gameStart() {


        player.changeWeapon(FactoryWeapons.createWeapon());
        player.getScore().resetScore();
        renderer.drawClips(player.getWeapon().getType().getClips());
        renderer.reloadAmmo(player.getWeapon().getType().getClipBullets());
        renderer.drawWeapon(player.getWeapon());
        renderer.drawScore(player.getScore().getScore());
        this.gameState = GameStates.GAMEPLAYING;
        this.gameEnded = false;
        this.forceRestart = false;

        int targetsNumber = (int) (Math.random() * GameConfigs.MAX_TARGETS_NUMBER);

        for (int i = 0; i < targetsNumber; i++) {
            targetHashList.add(FactoryTargets.createEnemy());
        }

        while (!gameEnded) {
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

        //Add random target
        if (Math.random() < 0.15) {
            targetHashList.add(FactoryTargets.createEnemy());
        }

        //Change every target Position && Remove if out of window
        Iterator<Target> iterator = targetHashList.iterator();
        while (iterator.hasNext()) {
            Target myTarget = iterator.next();

            if (myTarget.getPicture().getX() >= renderer.getCanvas().getWidth() -
                    myTarget.getPicture().getWidth() - myTarget.getSpeedX() ||
                    myTarget.getPicture().getX() <= myTarget.getSpeedX()) {
 
                if (Math.random() > 0.4) {

                    iterator.remove();
                    myTarget.getPicture().delete();

                } else {

                    switch (myTarget.getTargetType()) {

                        case LEFT:
                            myTarget.setTargetType(TargetType.RIGHT);
                            myTarget.setPicture("resources/enemies/duck_right.png");
                            myTarget.setSpeedX(-myTarget.getSpeedX());
                            break;

                        case RIGHT:
                            myTarget.setTargetType(TargetType.LEFT);
                            myTarget.setPicture("resources/enemies/duck_left.png");
                            myTarget.setSpeedX(-myTarget.getSpeedX());
                    }
                }
            }

            try {
                myTarget.move();
            } catch (ConcurrentModificationException ex) {
                System.out.println("Faulty Frame!\n");
            }


            //Check if force Restarted
            if (forceRestart) {
                gameEnded = true;
                gameState = GameStates.GAMEENDED;
            }
        }
    }

    public void eventShoot() {
        Weapon weapon = player.getWeapon();
        boolean killedOne = false;


        Iterator<Target> iterator = targetHashList.iterator();
        while (iterator.hasNext() && !killedOne) {
            Target target = iterator.next();

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

                if (getPlayer().getWeapon().getAmmo() > 0) {
                    boolean enemyKilled = weapon.shoot(target);

                    if (enemyKilled) {
                        player.getScore().changeScore(enemyScore);
                        target.getPicture().delete();
                        iterator.remove();
                        killedOne = true;
                    }
                }

                renderer.drawAmmo(player.getWeapon().getAmmo(), player.getWeapon().getType().getClipBullets());
                renderer.drawClips(player.getWeapon().getClips());
                renderer.drawScore(player.getScore().getScore());
            }
        }

        if (killedOne) {
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

    public void setForceRestart(boolean forceRestart) {
        this.forceRestart = forceRestart;
    }

    public boolean getRestartGame() {
        return restartGame;
    }

    public void setRestartGame(boolean restartGame) {
        this.restartGame = restartGame;
    }
}

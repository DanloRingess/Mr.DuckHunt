package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.Configs.GameConfigs;
import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.codecadets.handlers.DuckKeyboardHandler;
import org.academiadecodigo.codecadets.handlers.DuckMouseHandler;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.LinkedList;

public class Game {

    private Renderer renderer;
    private Player player;
    private DuckMouseHandler mouseHandler;

    // Game Properties
    private boolean gameEnded;
    private GameStates gameState;
    private LinkedList<Target> targetLinkedList;
    private DuckKeyboardHandler keyboardHandler;
    private boolean restartGame;

    public void init(String player) {
        if (restartGame) {
            renderer.deleteAll();
        }

        this.player = new Player(player);
        this.renderer = new Renderer();
        this.renderer.initRender();
        this.mouseHandler = new DuckMouseHandler(this, this.renderer);
        this.targetLinkedList = new LinkedList<>();
        this.keyboardHandler = new DuckKeyboardHandler(this);
        this.gameEnded = false;
        this.restartGame = false;
    }

    public void gameStart(){
        this.keyboardHandler.createPlayerControls();

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

        while(!gameEnded){
            tick();

            try {
                Thread.sleep(GameConfigs.GAME_SLEEP_TIME);
            } catch (InterruptedException ex) {
                System.out.println("Game Loop Exception: " + ex.getMessage());
            }
        }

        keyboardHandler.createMenuControls();
        switch (gameState) {
            case GAMEENDEDNOAMMO:
            case GAMEENDED:
                Text endGameTxt = renderer.newText(500, 200, "Game Ended!");
                endGameTxt.grow(40, 20);
                endGameTxt.draw();
                gameEnded();

                if (restartGame) {
                    this.gameState = GameStates.GAMEPLAYING;
                    init(this.player.getName());
                    gameStart();
                    return;
                } else {
                    System.exit(0);
                }
                break;
            default:
                System.out.println("WTF game state is that?: " + gameState.name());
        }
    }

    private void gameEnded() {
        while (gameEnded && !restartGame) {
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

        //Change every target Position
        for (Target myTarget : targetLinkedList) {
            //myTarget.move();
        }
    }

    public void eventShoot(){
        Weapon weapon = player.getWeapon();

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


            if(weapon.shoot(target)){
                if(target instanceof Enemy){
                    Enemy ourEnemy = (Enemy) target;
                    int enemyScore = ourEnemy.getType().getScore();
                    player.getScore().changeScore(enemyScore);
                }

            }


            renderer.drawAmmo(player.getWeapon().getAmmo(), player.getWeapon().getType().getClipBullets());
            renderer.drawClips(player.getWeapon().getClips());
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

    public Player getPlayer() {
        return this.player;
    }

    public GameStates getGameState() {
        return this.gameState;
    }

    public void setRestartGame(boolean restartGame) {
        this.restartGame = restartGame;
    }
}

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

import java.util.LinkedList;

public class Game {

    private Renderer renderer;
    private Player player;
    private DuckMouseHandler mouseHandler;

    // Game Properties
    private boolean gameEnded;
    private GameStates gameState;
    private LinkedList<Target> targetLinkedList;
    private final int TARGETS_NUMBER = 20;
    private DuckKeyboardHandler keyboardHandler;
    private boolean restartGame;


    public Game() {
        gameEnded = false;
        restartGame = false;
        keyboardHandler = new DuckKeyboardHandler();
    }

    public void init(String player) {
        this.player = new Player(player);
        this.renderer = new Renderer();
        this.renderer.initRender();
        this.mouseHandler = new DuckMouseHandler(this, this.renderer);
        this.targetLinkedList = new LinkedList<>();
        keyboardHandler.createPlayerControls(this.player);
    }

    public void gameStart(){

        for(int i = 0; i < TARGETS_NUMBER; i++) {
            targetLinkedList.add(FactoryTargets.createEnemy());
        }

        player.changeWeapon(FactoryWeapons.createWeapon());
        player.getScore().resetScore();
        renderer.drawClips(player.getWeapon().getType().getClips());
        renderer.reloadAmmo(player.getWeapon().getType().getClipBullets());
        renderer.drawWeapon(player.getWeapon());
        renderer.drawScore(player.getScore().getScore());
        gameState = GameStates.GAMEPLAYING;
        gameEnded = false;

        while(!gameEnded){
            tick();

            try {
                Thread.sleep(GameConfigs.GAME_SLEEP_TIME);
            } catch (InterruptedException ex) {
                System.out.println("Game Loop Exception: " + ex.getMessage());
            }
        }

        keyboardHandler.createMenuControls(this);
        switch (gameState) {
            case GAMEENDEDNOAMMO:
            case GAMEENDED:
                gameEnded();
                if (restartGame) {
                    gameState = GameStates.GAMEPLAYING;
                    init(this.player.getName());
                } else {
                    System.exit(0);
                }
                break;
            default:
                System.out.println("WTF game state is that?: " + gameState.name());
        }
    }

    private void gameEnded() {
        while (!gameEnded) {
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
            gameEnded = true;
            gameState = GameStates.GAMEENDEDNOAMMO;
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
            renderer.drawClips(player.getWeapon().getType().getClips());
            return;
        }
        weapon.shoot(null);
        renderer.drawAmmo(player.getWeapon().getAmmo(), player.getWeapon().getType().getClipBullets());
        renderer.drawClips(player.getWeapon().getType().getClips());
    }

    public Player getPlayer() {
        return player;
    }

    public GameStates getGameState() {
        return gameState;
    }

    public void setRestartGame(boolean restartGame) {
        this.restartGame = restartGame;
    }
}

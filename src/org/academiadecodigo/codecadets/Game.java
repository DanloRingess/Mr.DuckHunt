package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.codecadets.handlers.DuckMouseHandler;
import org.academiadecodigo.codecadets.renderer.Renderer;

public class Game {

    private Renderer renderer;
    private Player player;
    private DuckMouseHandler mouseHandler;

    // Game Properties
    private boolean gameEnded;
    private GameStates gameState;
    Target[] enemyList;


    public Game() {
        gameEnded = false;
        enemyList = new Target[100];
    }

    public void init(String player) {
        this.player = new Player(player);
        this.renderer = new Renderer();
        this.renderer.initRender();
        this.mouseHandler = new DuckMouseHandler(this, this.renderer);
    }

    public void gameStart(){
        player.changeWeapon(FactoryWeapons.createWeapon());
        player.getScore().resetScore();
        renderer.drawClips(player.getWeapon().getType().getClips());
        renderer.reloadAmmo(player.getWeapon().getType().getClipBullets());
        renderer.drawWeapon(player.getWeapon());
        renderer.drawScore(player.getScore().getScore());
        gameState = GameStates.GAMEPLAYING;
        gameEnded = false;

        while(!gameEnded){
            if(player.getWeapon().getAmmo() == 0 &&
               player.getWeapon().getClips() == 0){
                gameEnded = true;
            }
        }

        while (gameEnded){

            switch (gameState){
                case GAMEEXIT:
                    System.exit(0);
                    break;
                case GAMERESTART:
                    gameStart();
                    return;
            }
        }
    }

    public void eventShoot(){
        Weapon weapon = player.getWeapon();

        for (Target target : enemyList) {
            if (target == null) {
                continue;
            }

            if (weapon.getPosition().getX() < target.getPosition().getX() - weapon.getType().getSpread()) {
                continue;
            }

            if (weapon.getPosition().getX() > target.getPosition().getX() + target.getPicture().getWidth() + weapon.getType().getSpread()) {
                continue;
            }

            if (weapon.getPosition().getY() < target.getPosition().getY() - weapon.getType().getSpread()) {
                continue;
            }

            if (weapon.getPosition().getY() > target.getPosition().getY() + target.getPicture().getHeight() + weapon.getType().getSpread()) {
                continue;
            }
            weapon.shoot(target);
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
}

package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.gameobjects.Target;
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
    LinkedList<Target> enemyList;


    public Game() {
        gameEnded = false;
    }

    public void init(String player) {
        this.player = new Player(player);
        this.renderer = new Renderer();
        this.renderer.initRender();
        this.mouseHandler = new DuckMouseHandler(this.player, this.renderer);
    }

    public void gameStart(){
        player.changeWeapon(FactoryWeapons.createWeapon());
        player.getScore().resetScore();
        gameEnded = false;

        while(!gameEnded){
            renderer.drawAmmo(player.getWeapon().getAmmo());
            renderer.drawScore(player.getScore().getScore());
            renderer.drawWeapon(player.getWeapon());
            renderer.drawClips(player.getWeapon().getType().getClips());

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
        for (Target ourTarget: enemyList) {
        }
    }
}

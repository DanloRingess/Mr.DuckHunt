package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.handlers.DuckMouseHandler;
import org.academiadecodigo.codecadets.renderer.Renderer;

public class Game {

    private Renderer renderer;
    private Player player;
    private DuckMouseHandler mouseHandler;

    // Game Properties
    private boolean gameEnded;
    private GameStates gameState;


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
}

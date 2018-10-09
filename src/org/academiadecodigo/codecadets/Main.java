package org.academiadecodigo.codecadets;

public class Main {

    public static void main(String[] args) {
        Game myGame = new Game();

        /*Sound mySound = new Sound("resources/test.wav");
        mySound.loop();*/

        while (myGame.getRestartGame()) {
            myGame.init("Hastronauts");

            myGame.gameStart();
        }

        System.exit(0);
    }
}

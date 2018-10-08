package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.sound.Sound;

public class Main {

    public static void main(String[] args) {
        Game myGame = new Game();

        Sound mySound = new Sound("resources/test.wav");
        mySound.loop();

        myGame.init("Hastronauts");

        myGame.gameStart();
    }
}

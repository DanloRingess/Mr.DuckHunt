package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class KeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {

    public void keyPressed(KeyboardEvent pressR) {

        switch (pressR.getKey()) {
            case KeyboardEvent.KEY_R:
                reload(5);


        }

    }

    public void keyReleased(KeyboardEvent r) {

    }

    public void createGameControl() {

    }

    public void createPlayerControl() {

    }

}

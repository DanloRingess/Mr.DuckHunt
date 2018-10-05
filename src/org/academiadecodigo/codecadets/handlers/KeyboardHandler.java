package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public class KeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {

    public void keyPressed(KeyboardEvent press) {

        switch (press.getKey()) {
            case KeyboardEvent.KEY_R:
                reload(5);
                break;
            case KeyboardEvent.KEY_Q:
                //insert here quit method
                break;
            case KeyboardEvent.KEY_LEFT:

                break;
            case Key


        }

    }

    public void keyReleased(KeyboardEvent r) {

    }

    public void createGameControl() {

    }

    public void createPlayerControl() {

    }

}

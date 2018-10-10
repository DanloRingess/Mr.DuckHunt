package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class DuckKeyboardHandler implements KeyboardHandler {

    private Game game;
    private Keyboard ourKeyboard;

    public DuckKeyboardHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_R:
                switch (game.getGameState()) {
                    case GAMEENDED:
                    case GAMEENDEDNOAMMO:
                        game.eventRestart();
                        break;
                    case GAMEPLAYING:
                        game.reloadWeapon();
                        break;
                    default:
                }

                break;

            case KeyboardEvent.KEY_X:
                switch (game.getGameState()) {

                    case GAMEENDED:
                    case GAMEENDEDNOAMMO:
                        game.setRestartGame(false);
                        break;
                    default:
                }

                break;

            case KeyboardEvent.KEY_RIGHT:
                break;
            case KeyboardEvent.KEY_UP:
                break;
            case KeyboardEvent.KEY_DOWN:
                game.eventShoot();
                break;
            case KeyboardEvent.KEY_SPACE:
                game.setForceRestart(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent event) {
    }

    public void activateControls() {

        ourKeyboard = new Keyboard(this);

        KeyboardEvent[] keyboardEvents = {

                createEvent(KeyboardEvent.KEY_R, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_X, KeyboardEventType.KEY_PRESSED)
        };

        for (KeyboardEvent eachEvent : keyboardEvents) {

            ourKeyboard.addEventListener(eachEvent);
        }
    }

    private KeyboardEvent createEvent(int key, KeyboardEventType keyboardEventType) {

        KeyboardEvent myEvent = new KeyboardEvent();
        myEvent.setKey(key);
        myEvent.setKeyboardEventType(keyboardEventType);

        return myEvent;
    }

}

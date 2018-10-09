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

            case KeyboardEvent.KEY_R :
                switch (game.getGameState()) {
                    case GAMEENDED:
                    case GAMEENDEDNOAMMO:
                        game.setRestartGame(true);
                        break;
                    case GAMEPLAYING:
                        game.reloadWeapon();
                        break;
                    default:
                }

                break;
            case KeyboardEvent.KEY_LEFT:
                break;
            case KeyboardEvent.KEY_RIGHT:
                break;
            case KeyboardEvent.KEY_UP:
                break;
            case KeyboardEvent.KEY_DOWN:
                break;
            case KeyboardEvent.KEY_SPACE:
                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent event) {
    }

    public void createPlayerControls() {
        ourKeyboard = new Keyboard(this);

        KeyboardEvent[] keyboardEvents = {
                createEvent(KeyboardEvent.KEY_R, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED)
        };

        for (KeyboardEvent eachEvent : keyboardEvents) {
            ourKeyboard.addEventListener(eachEvent);
        }
    }

    public void createMenuControls() {
        ourKeyboard = new Keyboard(this);

        KeyboardEvent[] keyboardEvents = {
                createEvent(KeyboardEvent.KEY_R, KeyboardEventType.KEY_PRESSED),
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

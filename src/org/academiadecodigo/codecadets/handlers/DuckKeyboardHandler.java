package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class DuckKeyboardHandler implements KeyboardHandler {

    private Object handlerReceiver;
    private Keyboard ourKeyboard;

    private final int KEY_ESC = 27;

    @Override
    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_R :
                if (handlerReceiver instanceof Player) {
                    ((Player) handlerReceiver).getWeapon().reload();
                    return;
                }

                if (handlerReceiver instanceof Game) {
                    ((Game) handlerReceiver).setRestartGame(true);
                    return;
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
            case KEY_ESC:

                break;
        }


    }

    @Override
    public void keyReleased(KeyboardEvent event) {

         switch (event.getKey()) {

             case KeyboardEvent.KEY_R:

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
             case KEY_ESC:

                 break;

         }
    }

    public void createPlayerControls(Player ourPlayer) {
        handlerReceiver = ourPlayer;

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

    public void createMenuControls(Game ourGame) {
        handlerReceiver = ourGame;

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

package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

import java.security.Key;

public class KeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {

    private final int KEY_ESC = 27;

    @Override
    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_R :

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

    public void createGameControl() {

        Keyboard gameController = new Keyboard(this);

        KeyboardEvent pressR = new KeyboardEvent();
        pressR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressR.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent releaseR = new KeyboardEvent();
        releaseR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseR.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent releaseLeft = new KeyboardEvent();
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent releaseRight = new KeyboardEvent();
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressUp.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent releaseUp = new KeyboardEvent();
        releaseUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseUp.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressDown.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent releaseDown = new KeyboardEvent();
        releaseDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseDown.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent releaseSpace = new KeyboardEvent();
        releaseSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent pressEsc = new KeyboardEvent();
        pressEsc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressEsc.setKey(KEY_ESC);

        KeyboardEvent releaseEsc = new KeyboardEvent();
        releaseEsc.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseEsc.setKey(KEY_ESC);

        gameController.addEventListener(pressR);
        gameController.addEventListener(releaseR);
        gameController.addEventListener(pressLeft);
        gameController.addEventListener(releaseLeft);
        gameController.addEventListener(pressRight);
        gameController.addEventListener(releaseRight);
        gameController.addEventListener(pressUp);
        gameController.addEventListener(releaseUp);
        gameController.addEventListener(pressDown);
        gameController.addEventListener(releaseDown);
        gameController.addEventListener(pressSpace);
        gameController.addEventListener(releaseSpace);
        gameController.addEventListener(pressEsc);
        gameController.addEventListener(releaseEsc);
    }

    public void createPlayerControl() {

        Keyboard gameController = new Keyboard(this);

        KeyboardEvent pressR = new KeyboardEvent();
        pressR.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressR.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent releaseR = new KeyboardEvent();
        releaseR.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseR.setKey(KeyboardEvent.KEY_R);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent releaseLeft = new KeyboardEvent();
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseLeft.setKey(KeyboardEvent.KEY_LEFT);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent releaseRight = new KeyboardEvent();
        releaseLeft.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseRight.setKey(KeyboardEvent.KEY_RIGHT);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressUp.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent releaseUp = new KeyboardEvent();
        releaseUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseUp.setKey(KeyboardEvent.KEY_UP);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressDown.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent releaseDown = new KeyboardEvent();
        releaseDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseDown.setKey(KeyboardEvent.KEY_DOWN);

        KeyboardEvent pressSpace = new KeyboardEvent();
        pressSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent releaseSpace = new KeyboardEvent();
        releaseSpace.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pressSpace.setKey(KeyboardEvent.KEY_SPACE);

        KeyboardEvent pressEsc = new KeyboardEvent();
        pressEsc.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        pressEsc.setKey(KEY_ESC);

        KeyboardEvent releaseEsc = new KeyboardEvent();
        releaseEsc.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        releaseEsc.setKey(KEY_ESC);

        gameController.addEventListener(pressR);
        gameController.addEventListener(releaseR);
        gameController.addEventListener(pressLeft);
        gameController.addEventListener(releaseLeft);
        gameController.addEventListener(pressRight);
        gameController.addEventListener(releaseRight);
        gameController.addEventListener(pressUp);
        gameController.addEventListener(releaseUp);
        gameController.addEventListener(pressDown);
        gameController.addEventListener(releaseDown);
        gameController.addEventListener(pressSpace);
        gameController.addEventListener(releaseSpace);
        gameController.addEventListener(pressEsc);
        gameController.addEventListener(releaseEsc);

    }

}

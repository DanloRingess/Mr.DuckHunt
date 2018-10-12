package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.codecadets.sound.Sound;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.sound.sampled.Clip;
import java.security.Key;

public class DuckKeyboardHandler implements KeyboardHandler {

    private Game game;
    private Keyboard ourKeyboard;

    public DuckKeyboardHandler(Game game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyboardEvent event) {

        Weapon weapon = null;

        if (game.getPlayer() != null){
            weapon = game.getPlayer().getWeapon();
        }

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
                switch(game.getGameState()) {
                    case GAMEPLAYING:
                        System.out.println("x: " + weapon.getAim().getX());
                        System.out.println("y: " + weapon.getAim().getY());

                        game.updateCursor(new Position(weapon.getAim().getX() + 10 +11, weapon.getAim().getY() + 32));
                    }

                break;

            case KeyboardEvent.KEY_LEFT:
                switch(game.getGameState()) {
                    case GAMEPLAYING:
                        game.updateCursor(new Position(weapon.getAim().getX() -10 +11, weapon.getAim().getY() +32));
                }

               break;

            case KeyboardEvent.KEY_UP:
                switch(game.getGameState()) {
                    case GAMEPLAYING:
                        game.updateCursor(new Position(weapon.getAim().getX() +11, weapon.getAim().getY() - 10+32));
                }

                break;

            case KeyboardEvent.KEY_DOWN:
                switch(game.getGameState()) {
                    case GAMEPLAYING:
                        game.updateCursor(new Position(weapon.getAim().getX()+11, weapon.getAim().getY() +10+32));
                }

                break;

            case KeyboardEvent.KEY_P:
                switch(game.getGameState()) {
                    case GAMEPLAYING:
                        game.setForceRestart(true);
                }

                break;

            case KeyboardEvent.KEY_SPACE:
                switch (game.getGameState()){
                    case GAMEPLAYING:
                        game.eventShoot();
                        break;
                    case GAMESTARTING:
                        game.getStartPage().canStart();
                        break;
                }
                break;
            default:
                System.out.println("Unhandled Key!");

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
                createEvent(KeyboardEvent.KEY_X, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_RIGHT, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_LEFT, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_UP, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_DOWN, KeyboardEventType.KEY_PRESSED),
                createEvent(KeyboardEvent.KEY_P, KeyboardEventType.KEY_PRESSED)


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

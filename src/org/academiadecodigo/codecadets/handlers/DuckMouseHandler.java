package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class DuckMouseHandler implements MouseHandler {

    private Game game;
    private Renderer renderer;

    private Mouse mouse;

    public DuckMouseHandler(Game game, Renderer renderer) {

        this.game = game;
        this.renderer = renderer;
    }


    @Override
    public void mousePressed(MouseEvent event) {

        if (game.getGameState() == GameStates.GAMEPLAYING) {
            game.eventShoot();
        }

    }

    @Override
    public void mouseMoved(MouseEvent event) {
        game.updateCursor(new Position((int)event.getX(), (int)event.getY()));
    }


    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println(event);
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        System.out.println(event);
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        System.out.println(event);
    }

    @Override
    public void mouseExited(MouseEvent event) {
        System.out.println(event);
        //Canvas.pause();
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        game.updateCursor(new Position((int)event.getX(), (int)event.getY()));
    }


    public void initMouse() {
        mouse = new Mouse(this);

        MouseEventType[] MouseEvents = {
                MouseEventType.MOUSE_DRAGGED,
                MouseEventType.MOUSE_MOVED
        };

        for (MouseEventType eachEvent : MouseEvents) {
            mouse.addEventListener(eachEvent);
        }
    }

    public void initMouseClick() {

        MouseEventType[] MouseEvents = {
                MouseEventType.MOUSE_PRESSED
        };

        for (MouseEventType eachEvent : MouseEvents) {
            mouse.addEventListener(eachEvent);
        }
    }
}

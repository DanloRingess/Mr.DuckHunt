package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class DuckMouseHandler implements MouseHandler {

    private Game game;
    private Renderer renderer;

    public DuckMouseHandler(Game game, Renderer renderer) {

        this.game = game;
        this.renderer = renderer;
        initMouse();
    }

    @Override
    public void mouseClicked(MouseEvent event) {

        Position pos = new Position();

        pos.setX((int) event.getX());
        pos.setY((int) event.getY());
        game.getPlayer().getWeapon().setAim(pos);

        if (game.getGameState() == GameStates.GAMEPLAYING) {
            game.eventShoot();
        }

    }

    @Override
    public void mouseMoved(MouseEvent event) {

        Position pos = new Position();

        double crosshairHalfWidth = renderer.getCrosshair().getWidth() / 2;
        double crosshairHalfHeight = renderer.getCrosshair().getHeight() / 2;
        int correctY = 25;

        if (event.getX() <= crosshairHalfWidth) {

            pos.setX(0);

        } else if (event.getX() >= renderer.getCanvas().getWidth() - crosshairHalfWidth) {

            pos.setX((int) (renderer.getCanvas().getWidth() - (2*crosshairHalfWidth)));

        } else {

            pos.setX((int) (event.getX() - crosshairHalfWidth));
        }

        if (event.getY() <= crosshairHalfHeight + correctY) {

            pos.setY(0);

        } else if (event.getY() >= renderer.getCanvas().getHeight() - crosshairHalfHeight + correctY) {

            pos.setY((int) (renderer.getCanvas().getHeight() - (2*crosshairHalfHeight)));

        } else {

            pos.setY((int) (event.getY() - crosshairHalfHeight - correctY));
        }

        renderer.drawAim(pos);
    }


    @Override
    public void mousePressed(MouseEvent event) {
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
    }

    @Override
    public void mouseDragged(MouseEvent event) {

        Position pos = new Position();

        pos.setX((int) event.getX() - (renderer.getCrosshair().getWidth() / 2));
        pos.setY((int) event.getY() - (renderer.getCrosshair().getHeight() / 2) - 33);
        renderer.drawAim(pos);
    }


    public void initMouse() {

        Mouse mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_PRESSED);
        mouse.addEventListener(MouseEventType.MOUSE_RELEASED);
        mouse.addEventListener(MouseEventType.MOUSE_ENTERED);
        mouse.addEventListener(MouseEventType.MOUSE_EXITED);
        mouse.addEventListener(MouseEventType.MOUSE_DRAGGED);
    }
}

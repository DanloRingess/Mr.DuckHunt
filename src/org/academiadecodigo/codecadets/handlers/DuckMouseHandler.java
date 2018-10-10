package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.GameStates;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
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
    public void mousePressed(MouseEvent event) {

        if (game.getGameState() == GameStates.GAMEPLAYING) {
            game.eventShoot();
        }

    }

    @Override
    public void mouseMoved(MouseEvent event) {
        Position weaponAim = game.getPlayer().getWeapon().getAim();

        weaponAim.setX((int) event.getX());
        weaponAim.setY((int) event.getY() - 27);

        Ellipse temp = new Ellipse(weaponAim.getX(), weaponAim.getY(), 20, 20);
        temp.setColor(Color.CYAN);
        temp.fill();


        System.out.println(event);
        System.out.println(weaponAim);


        double crosshairHalfWidth = renderer.getCrosshair().getWidth() / 2;
        double crosshairHalfHeight = renderer.getCrosshair().getHeight() / 2;
        int correctY = 27;



        if (event.getX() <= crosshairHalfWidth) {

            weaponAim.setX(0);

        } else if (event.getX() >= renderer.getCanvas().getWidth() - crosshairHalfWidth) {

            weaponAim.setX((int) (renderer.getCanvas().getWidth() - (2*crosshairHalfWidth)));

        } else {

            weaponAim.setX((int) (event.getX() - crosshairHalfWidth));
        }

        if (event.getY() <= crosshairHalfHeight + correctY) {

            weaponAim.setY(0);

        } else if (event.getY() >= renderer.getCanvas().getHeight() - crosshairHalfHeight + correctY) {

            weaponAim.setY((int) (renderer.getCanvas().getHeight() - (2*crosshairHalfHeight)));

        } else {

            weaponAim.setY((int) (event.getY() - crosshairHalfHeight - correctY));
        }

        renderer.drawAim(weaponAim);
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
        Position weaponAim = game.getPlayer().getWeapon().getAim();

        weaponAim.setX((int) event.getX());
        weaponAim.setY((int) event.getY());

        renderer.drawAim(weaponAim);
    }


    private void initMouse() {

        Mouse mouse = new Mouse(this);

        mouse.addEventListener(MouseEventType.MOUSE_PRESSED);
        mouse.addEventListener(MouseEventType.MOUSE_MOVED);
        mouse.addEventListener(MouseEventType.MOUSE_EXITED);
        mouse.addEventListener(MouseEventType.MOUSE_DRAGGED);
    }
}

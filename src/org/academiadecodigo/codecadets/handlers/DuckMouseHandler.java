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
        //Canvas
        Rectangle canvas = (Rectangle) Canvas.getInstance().getShapes().get(0);

        //Crosshair
        Picture crosshair = renderer.getCrosshair();

        //Get crossairHalfSizes
        int crosshairHalfWidth = (crosshair.getWidth() / 2);
        int crosshairHalfHeight = (crosshair.getHeight() / 2);


        //Get Player Weapon Aim
        Position weaponAim = game.getPlayer().getWeapon().getAim();

        //Set Player Aim Position
        weaponAim.setX((int) event.getX() - 11);
        weaponAim.setY((int) event.getY() - 32);

        Position aimPos = new Position(weaponAim.getX() - crosshairHalfWidth, weaponAim.getY() - crosshairHalfHeight);


        //Check if Crosshair not out of bounds of our window
        if (event.getX() >= canvas.getWidth() - (crosshairHalfWidth - 10)) {
            aimPos.setX(canvas.getWidth() - (crosshair.getWidth()));
        }

        if (event.getY() >= canvas.getHeight() - (crosshairHalfHeight - 30)) {
            aimPos.setY(canvas.getHeight() - (crosshair.getHeight()));
        }

        renderer.drawAim(aimPos);
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

package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Player;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class DuckMouseHandler implements MouseHandler {

    private Player player;
    private Renderer renderer;


    public DuckMouseHandler(Player player, Renderer renderer) {
        this.player = player;
        this.renderer = renderer;
        initMouse();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Position pos = new Position();
        pos.setX((int) event.getX());
        pos.setY((int) event.getY());
        player.getWeapon().setAim(pos);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        Position pos = new Position();
        pos.setX((int) event.getX() - (renderer.getCrosshair().getWidth() / 2));
        pos.setY((int) event.getY() - (renderer.getCrosshair().getHeight() / 2) - 25);
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
    }

    @Override
    public void mouseDragged(MouseEvent event) {
        Position pos = new Position();
        pos.setX((int) event.getX() - (renderer.getCrosshair().getWidth() / 2));
        pos.setY((int) event.getY() - (renderer.getCrosshair().getHeight() / 2) - 25);
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

package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Player;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.renderer.Renderer;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

public class MouseHandler implements org.academiadecodigo.simplegraphics.mouse.MouseHandler {

    private Player player;
    private Renderer renderer;


    public MouseHandler(Player player, Renderer renderer) {
        this.player = player;
        this.renderer = renderer;
        initMouse();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        Position pos = new Position();
        pos.setX((int )event.getX());
        pos.setY((int) event.getY());
        player.getWeapon().setAim(pos);
    }

    @Override
    public void mouseMoved(MouseEvent event) {
        Position pos = new Position();
        pos.setX((int) event.getX());
        pos.setY((int) event.getY());
        renderer.drawAim(pos);
    }


    public void initMouse(){
         Mouse mouse = new Mouse(this);

         mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
         mouse.addEventListener(MouseEventType.MOUSE_MOVED);
    }

}

package org.academiadecodigo.codecadets.handlers;

import org.academiadecodigo.codecadets.Player;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;

public class MouseHandler implements org.academiadecodigo.simplegraphics.mouse.MouseHandler {

    private boolean isFiring;
    private Player player;

    public MouseHandler(Player player) {
        this.player = player;
        initMouse();
    }

    @Override
    public void mouseClicked(MouseEvent event) {
        player.getWeapon()
    }

    @Override
    public void mouseMoved(MouseEvent event) {

    }


    public void initMouse(){
         Mouse mouse = new Mouse(this);

         mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
         mouse.addEventListener(MouseEventType.MOUSE_MOVED);
    }

}

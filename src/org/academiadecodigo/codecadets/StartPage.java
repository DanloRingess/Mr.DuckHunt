package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.Configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartPage {

    private Rectangle bgRect;
    private Picture logo;
    private boolean canStart;

    public StartPage(){
        canStart = false;
        bgRect = new Rectangle(0, 0, RenderConfigs.CANVASWIDTH, RenderConfigs.CANVASHEIGHT);
        logo = new Picture( 50,100, RenderConfigs.GAMELOGO);
    }

    public void init() {
        bgRect.setColor(Color.BLACK);
        bgRect.fill();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logo.draw();
    }

    public void waitToStart(){
        while (!canStart){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void destroy() {
        bgRect.delete();
    }

    public void canStart() {
        this.canStart = true;
    }
}

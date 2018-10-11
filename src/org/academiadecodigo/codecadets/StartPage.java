package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.Configs.RenderConfigs;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class StartPage {

    private Picture bgPic;
    private Picture logo;
    private boolean canStart;
    private Picture pressToStart;

    public StartPage(){
        canStart = false;
        bgPic = new Picture(0, 0, RenderConfigs.STARTBG);
        logo = new Picture( 200,100, RenderConfigs.GAMELOGO);
        pressToStart = new Picture(180, 330, RenderConfigs.PRESSTOSTART);
    }

    public void init() {
        bgPic.draw();
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logo.draw();
        pressToStart.draw();

        waitToStart();
    }

    private void waitToStart(){
        while (!canStart){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        destroy();
    }

    private void destroy() {
        bgPic.delete();
        logo.delete();
        pressToStart.delete();
    }

    public void canStart() {
        this.canStart = true;
    }
}

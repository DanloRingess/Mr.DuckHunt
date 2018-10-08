package org.academiadecodigo.codecadets.renderer;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.handlers.DuckMouseHandler;

public class RendererTest {
    public static void main(String[] args) {
        Renderer myRenderer = new Renderer();
        Game myGame = new Game();
        myGame.init("Hastronauts");

        DuckMouseHandler mouseHandler = new DuckMouseHandler(myGame, myRenderer);

        myRenderer.initRender();

        myRenderer.drawClips(99);

        myRenderer.drawScore(99999);

        myRenderer.drawWeaponTest();

        for (int i = 0; i <= 19; i++){
            myRenderer.reloadAmmo(i);
            try
            {
                Thread.sleep(250);
            }
            catch (InterruptedException localInterruptedException)
            {
                System.out.println("Ups");
            }
        }


        Position myPos = new Position();
        myPos.setX(200);
        myPos.setY(200);

        for (int i = 0; i <= 19; i++){
            myPos.setX(myPos.getX() + (10));

            myPos.setY(myPos.getY() + (10));
            myRenderer.drawAim(myPos);
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException localInterruptedException)
            {
                System.out.println("Ups");
            }
        }


    }
}

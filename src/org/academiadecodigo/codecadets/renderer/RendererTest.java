package org.academiadecodigo.codecadets.renderer;

import javafx.geometry.Pos;
import org.academiadecodigo.codecadets.Position;

public class RendererTest {
    public static void main(String[] args) {
        Renderer myRenderer = new Renderer();
        myRenderer.initRender();

        myRenderer.drawClips(99);

        myRenderer.drawScore(99999);

        myRenderer.drawWeaponTest();

        for (int i = 0; i <= 19; i++){
            myRenderer.drawAmmo(i);
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

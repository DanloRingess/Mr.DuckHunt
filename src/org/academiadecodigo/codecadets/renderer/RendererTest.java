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

        myRenderer.drawAim(myPos);

    }
}

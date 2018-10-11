package org.academiadecodigo.codecadets.renderer;

import org.academiadecodigo.codecadets.Configs.RenderConfigs;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Renderer {

    private Rectangle canvas;
    private Text clipsCounter;
    private Text scoreCounter;
    private Picture sideWeapon;
    private Rectangle[] ammoCounter;
    private Picture crosshair;
    private Picture landscape;

    public Renderer() {

        canvas = new Rectangle(0, 0, RenderConfigs.CANVASWIDTH, RenderConfigs.CANVASHEIGHT);
        canvas.setColor(Color.GRAY);
        canvas.fill();
    }

    public void initRender(){
        //Create Landscape
        landscape = new Picture(1,1);
        landscape.load("resources/Landscape.png");
        landscape.draw();

        //Create Clips Counter
        clipsCounter = new Text(RenderConfigs.CANVASWIDTH - 50, RenderConfigs.CANVASHEIGHT - RenderConfigs.FONTSIZE - 20, "");
        clipsCounter.grow(RenderConfigs.FONTSIZE, RenderConfigs.FONTSIZE);
        clipsCounter.setColor(Color.WHITE);

        //Create score Counter
        scoreCounter = new Text(canvas.getX() + 50, canvas.getY() + 20, "");
        scoreCounter.grow(RenderConfigs.FONTSIZE + 30, RenderConfigs.FONTSIZE);
        scoreCounter.setColor(Color.WHITE);

        //Create Side Weapon Image
        sideWeapon = new Picture(1, 1);
        sideWeapon.translate(RenderConfigs.CANVASWIDTH - 200, canvas.getY() - 30);
        sideWeapon.grow(-100, -30);

        //Create Ammo Counter
        ammoCounter = new Rectangle[10];

        for (int i = 0; i < ammoCounter.length; i++) {

            ammoCounter[i] = new Rectangle(20 + (i * (RenderConfigs.BULLETWIDTH + 10)), (RenderConfigs.CANVASHEIGHT - RenderConfigs.BULLETHEIGHT) - 10, RenderConfigs.BULLETWIDTH, RenderConfigs.BULLETHEIGHT);
        }

        //Create Crosshair
        crosshair = new Picture(1, 1);
        crosshair.load(RenderConfigs.CROSSHAIRIMG);
        crosshair.draw();
    }

    public void drawScore(int score) {

        scoreCounter.setText("Score: " + score);
        scoreCounter.draw();
    }

    public void drawAmmo(int ammo, int maxAmmo) {

        int numAmmo = ammo >= 10 ? 10 : ammo;

        for (int i = numAmmo; i < maxAmmo; i++) {

            try {

                Thread.sleep(250);

            } catch (InterruptedException localInterruptedException) {

                System.out.println("Ups");
            }

            if (!ammoCounter[i].isFilled()) {

                continue;
            }

            ammoCounter[i].delete();
        }
    }

    public void reloadAmmo(int numAmmo) {

        for (int i = 0; i < numAmmo; i++) {

            ammoCounter[i].fill();

            try {

                Thread.sleep(250);
            } catch (InterruptedException localInterruptedException) {

                System.out.println("Ups");
            }
        }
    }

    public void drawClips(int clipsNum) {

        clipsCounter.setText(clipsNum + "");
        clipsCounter.draw();
    }

    public void drawWeapon(Weapon weapon) {

        switch (weapon.getType()) {

            case SHOTGUN:
                sideWeapon.load(RenderConfigs.SIDESHOTGUN);
                break;
            default:
                sideWeapon.load(RenderConfigs.MISSINGTEXTURE);
        }

        sideWeapon.draw();
    }

    public void drawWeaponTest() {

        sideWeapon.load(RenderConfigs.MISSINGTEXTURE);
        sideWeapon.draw();
    }

    public void drawAim(Position pos) {

        crosshair.translate(pos.getX() - crosshair.getX(), pos.getY() - crosshair.getY());
    }

    public void deleteAll() {

        clipsCounter.delete();
        scoreCounter.delete();
        sideWeapon.delete();

        for (int i = 0; i < ammoCounter.length; i++) {

            ammoCounter[i].delete();
        }
        crosshair.delete();
    }

    public Text newText(int x, int y, int xGrowth, int yGrowth, String ourText) {

        Text newTextRender = new Text(x, y, ourText);
        newTextRender.grow(xGrowth, yGrowth);
        newTextRender.draw();
        return newTextRender;
    }

    public Picture getCrosshair() {
        return crosshair;
    }

    public Rectangle getCanvas() {
        return canvas;
    }


}

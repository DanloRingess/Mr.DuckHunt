package org.academiadecodigo.codecadets.gameobjects.enemies;

import org.academiadecodigo.codecadets.Configs.RenderConfigs;
import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.enums.TargetType;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck extends Enemy {

    public Duck(){
        super(EnemyTypes.DUCK);
        this.setLeftPicture("resources/enemies/duck_left.png");
        this.setRightPicture("resources/enemies/duck_right.png");
        init();
    }

    private void init() {

        //setSpeedX((int) (5 + (Math.random() * 10)));
        setTargetType(TargetType.getRandomType());
        int speed = 7 + (int)(Math.random()*6);

        switch (getTargetType()) {
            case LEFT:
                setSpeedX(speed);
                setPosition(new Position(0, 70 + (int) (Math.random() * 450)));
                setPicture(this.getLeftPicture());
                break;

            case RIGHT:
                setSpeedX(-speed);
                setPosition(new Position((int) (Canvas.getInstance().getShapes().get(0).getWidth() - 185*(0.6)),
                            70 + (int) (Math.random() * 450)));
                setPicture(this.getRightPicture());
        }

        setSpeedY(0);

        getPicture().draw();

    }
}

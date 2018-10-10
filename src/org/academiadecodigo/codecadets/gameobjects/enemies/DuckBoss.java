package org.academiadecodigo.codecadets.gameobjects.enemies;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.enums.TargetType;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class DuckBoss extends Enemy {

    public DuckBoss(){
        super(EnemyTypes.DUCKBOSS);
        init();
    }

    private void init() {


        setTargetType(TargetType.getRandomType());
        int speed = 7 + (int)(Math.random()*6);

        switch (getTargetType()) {
            case LEFT:
                setSpeedX(speed);
                setPosition(new Position(0, 100 + (int) (Math.random() * 300)));
                setPicture("/Users/codecadet/Downloads/FinalBoss.png");
                break;

            case RIGHT:
                setSpeedX(-speed);
                setPosition(new Position((int) (Canvas.getInstance().getShapes().get(0).getWidth() - 185*(0.6)),
                        100 + (int) (Math.random() * 300)));
                setPicture("/Users/codecadet/Downloads/FinalBoss.png");
        }

        setSpeedY(0);

        getPicture().draw();

    }

}

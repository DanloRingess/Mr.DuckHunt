package org.academiadecodigo.codecadets.gameobjects.enemies;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Duck extends Enemy {

    public Duck(){
        super(EnemyTypes.DUCK);
        init();
    }

    public void init() {

        //setSpeedX((int) (5 + (Math.random() * 10)));
        setSpeedX(10);
        setSpeedY(0);

        setPosition(new Position(0, 100 + (int) (Math.random() * 300)));

        setPicture(new Picture(this.getPosition().getX(), this.getPosition().getY(),
                "resources/enemies/duck.png"));
        getPicture().grow(-40, -20);
        getPicture().draw();

    }
}

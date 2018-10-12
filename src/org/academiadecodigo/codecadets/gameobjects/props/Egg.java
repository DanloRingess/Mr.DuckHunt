package org.academiadecodigo.codecadets.gameobjects.props;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.PropTypes;
import org.academiadecodigo.codecadets.enums.TargetSide;
import org.academiadecodigo.simplegraphics.graphics.Canvas;

public class Egg extends Prop{

    PropTypes propType;

    public Egg() {
        this.propType = PropTypes.EGG;
        this.setLeftPicture("resources/props/egg.png");
        this.setRightPicture("resources/props/egg.png");
        init();
    }

    private void init() {

        setTargetSide(TargetSide.getRandomType());
        int speed = 7 + (int) (Math.random() * 6);

        switch (getTargetSide()) {
            case LEFT:
                setSpeedX(speed);
                setPosition(new Position(0, 50 + (int) (Math.random() * 370)));
                setPicture(this.getLeftPicture());
                break;

            case RIGHT:
                setSpeedX(-speed);
                setPosition(new Position((int) (Canvas.getInstance().getShapes().get(0).getWidth() - 33),
                        50 + (int) (Math.random() * 370)));
                setPicture(this.getRightPicture());
        }

        setSpeedY(0);

        getPicture().draw();

    }
}

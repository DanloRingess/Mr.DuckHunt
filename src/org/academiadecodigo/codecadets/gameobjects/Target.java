package org.academiadecodigo.codecadets.gameobjects;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.TargetSide;

public abstract class Target extends GameObject {

    private boolean destroyed;
    private int speedX;
    private int speedY;
    private TargetSide targetSide;
    private String leftPicture;
    private String rightPicture;


    public Target() {

        destroyed = false;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public void setTargetSide(TargetSide targetSide) {
        this.targetSide = targetSide;
    }

    public TargetSide getTargetSide() {
        return targetSide;
    }

    public String getLeftPicture() {
        return leftPicture;
    }

    public void setLeftPicture(String leftPicture) {
        this.leftPicture = leftPicture;
    }

    public String getRightPicture() {
        return rightPicture;
    }

    public void setRightPicture(String rightPicture) {
        this.rightPicture = rightPicture;
    }

    public abstract boolean hit(int damage);

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public void move() {

        Position newPos = new Position(this.getPosition().getX() + speedX, this.getPosition().getY() + speedY);
        this.setPosition(newPos);
        this.getPicture().translate(speedX, speedY);
    }
}

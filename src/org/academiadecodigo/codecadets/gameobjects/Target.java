package org.academiadecodigo.codecadets.gameobjects;

import org.academiadecodigo.codecadets.Position;

public abstract class Target extends GameObject {

    private boolean destroyed;
    private int speedX;
    private int speedY;

    public Target() {

        destroyed = false;
        speedX = 2 + (int) Math.random()*4;
        speedY = 0;
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

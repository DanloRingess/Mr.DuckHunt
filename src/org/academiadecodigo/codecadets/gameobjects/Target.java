package org.academiadecodigo.codecadets.gameobjects;

import org.academiadecodigo.codecadets.Position;

public abstract class Target extends GameObject {

    private boolean destroyed;
    private int speedX;
    private int speedY = 0;

    public Target() {

        destroyed = false;
        speedX = 2 + (int) Math.random()*4;
    }

    public abstract boolean hit(int damage);

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public void move() {

        Position newPos = new Position(this.getPosition().getX() + speedX, this.getPosition().getY());
        this.setPosition(newPos);

        this.getPicture().translate(speedX, 0);
    }
}

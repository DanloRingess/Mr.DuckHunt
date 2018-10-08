package org.academiadecodigo.codecadets.gameobjects;

public abstract class Target extends GameObject {

    private boolean destroyed;

    public Target() {
        destroyed = false;
    }

    public abstract boolean hit(int damage);

    public boolean isDestroyed() {
        return destroyed;
    }

    public void destroy() {
        this.destroyed = true;
    }

    public abstract void move(int x, int y);
}

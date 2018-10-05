package org.academiadecodigo.codecadets.gameobjects;

import org.academiadecodigo.codecadets.Position;

public abstract class  GameObject {

    private Position position;

    private String imgSrc;

    public Position getPosition() {
        return null;
    }

    public String getImgSrc() {
        return null;
    }

    public abstract void move(int x, int y);
}

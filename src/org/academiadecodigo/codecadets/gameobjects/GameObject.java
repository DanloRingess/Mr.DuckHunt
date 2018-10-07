package org.academiadecodigo.codecadets.gameobjects;

import org.academiadecodigo.codecadets.Position;

public abstract class  GameObject {

    private Position position;

    private String imgSrc;

    public Position getPosition() {
        return this.position;
    }

    public String getImgSrc() {
        return imgSrc;
    }
}

package org.academiadecodigo.codecadets.gameobjects;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public abstract class GameObject {

    private Position position;

    private Picture picture;

    public Position getPosition() {
        return this.position;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

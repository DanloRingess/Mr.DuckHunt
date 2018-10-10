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

    public void setPicture(String imageURI) {
        this.picture = new Picture(position.getX(), position.getY(), imageURI);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

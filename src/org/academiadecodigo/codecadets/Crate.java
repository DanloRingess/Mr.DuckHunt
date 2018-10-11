package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.gameobjects.props.Prop;

public class Crate extends Prop {
    @Override
    public boolean hit(int damage) {
        return false;
    }
}

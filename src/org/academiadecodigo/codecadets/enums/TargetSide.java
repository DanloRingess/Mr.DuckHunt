package org.academiadecodigo.codecadets.enums;

public enum TargetSide { //TODO: target orientation

    LEFT,
    RIGHT;

    public static TargetSide getRandomType() {

        int random = (int) (2 * Math.random());

        if (random == 0) {

            return LEFT;
        }

        return RIGHT;
    }
}

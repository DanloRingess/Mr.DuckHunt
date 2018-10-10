package org.academiadecodigo.codecadets.enums;

public enum TargetType {
    LEFT,
    RIGHT;

    public static TargetType getRandomType() {
        int random = (int) (2 * Math.random());

        if (random == 0) {
            return LEFT;
        }

        return RIGHT;
    }
}

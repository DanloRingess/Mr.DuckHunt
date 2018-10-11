package org.academiadecodigo.codecadets.enums;

public enum EnemyTypes {
    DUCK(14, 10),
    DUCKBOSS(40,100);

    private int health;
    private int score;

    EnemyTypes(int hp, int score) {

        this.health = hp;
        this.score = score;
    }

    public int getHealth() {
        return health;
    }

    public int getScore() {
        return score;
    }
}

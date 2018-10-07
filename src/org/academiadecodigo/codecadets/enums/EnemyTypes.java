package org.academiadecodigo.codecadets.enums;

public enum EnemyTypes {
    DUCK(30);

    private int health;

    EnemyTypes(int hp) {
        this.health = hp;
    }
}

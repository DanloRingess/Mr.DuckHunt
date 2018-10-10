package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Player {

    private Score score;
    private Weapon weapon;
    private String name;

    public Player(String name) {

        this.name = name;
        this.score = new Score();
        this.weapon = FactoryWeapons.createWeapon();
    }

    public Score getScore() {
        return score;
    }

    public void changeWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public String getName() {
        return name;
    }
}

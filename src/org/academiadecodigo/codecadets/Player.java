package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.exceptions.UnknownWeaponException;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;

public class Player {

    private Score score;
    private Weapon weapon;
    private String name;

    public Player(String name) {

        this.name = name;
        this.score = new Score();
    }

    public void init(){

        try{
            this.weapon = WeaponsFactory.createWeapon();

        }catch (UnknownWeaponException e){

            System.out.println("Error Creating Weapon on Player");
        }
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

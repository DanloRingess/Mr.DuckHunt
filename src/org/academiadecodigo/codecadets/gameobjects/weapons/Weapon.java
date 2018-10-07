package org.academiadecodigo.codecadets.gameobjects.weapons;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.enums.WeaponTypes;
import org.academiadecodigo.codecadets.gameobjects.GameObject;
import org.academiadecodigo.codecadets.gameobjects.Target;

abstract public class Weapon extends GameObject {

    //Proprieties:----------------
    private Position aim;
    private int ammo;
    private WeaponTypes type;
    private int damage;

    //methods:---------------------

    public void shoot(Target target) {



    }

    public void reload(int bullets) {
        ammo = bullets;


    }

    public Position getAim() {
        return aim;
    }

    public int getAmmo() {
        return ammo;
    }

    public WeaponTypes getType() {
        return type;
    }

    public void setAim(Position aimming) {


    }

}

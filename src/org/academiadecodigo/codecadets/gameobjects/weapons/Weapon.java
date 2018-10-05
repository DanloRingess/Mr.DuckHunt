package org.academiadecodigo.codecadets.gameobjects.weapons;

import org.academiadecodigo.codecadets.Position;
import org.academiadecodigo.codecadets.gameobjects.GameObject;
import org.academiadecodigo.codecadets.gameobjects.Target;

abstract public class Weapon extends GameObject {

    //Proprieties:----------------
    private Position aim;
    private int ammo;
    private WeaponType type;
    private int damage;

    //methods:---------------------

    public void shoot(Target target) {


    }

    public void reload(int bullets) {


    }

    public Position getAim() {
        return aim;
    }

    public int getAmmo() {
        return ammo;
    }

    public WeaponType getType() {
        return type;
    }

    public void setAim(Position aimming) {


    }

}

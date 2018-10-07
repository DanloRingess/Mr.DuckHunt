package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;

public class FactoryWeapons {

    public static Weapon createWeapon() {
       Weapon weapon = new Weapon();
        return weapon;
    }
}

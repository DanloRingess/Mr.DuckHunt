package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;

public class FactoryWeapons {

    public static Weapon createWeapon() {
       int random = (int)(Math.random() * WeaponTypes.values().lenght);
       WeaponTypes weaponType = WeaponTypes.values()[random];

       Weapon weapon;

       switch (weaponType){
           case weaponType1:
               weapon = new Weapon1();
               break;

           case weaponType2:
               weapon = new Weapon2();
               break;

           default:
               weapon = new Weapon1();
       }
        return weapon;
    }
}

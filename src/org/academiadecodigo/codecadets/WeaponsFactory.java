package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.WeaponTypes;
import org.academiadecodigo.codecadets.exceptions.UnknownWeaponException;
import org.academiadecodigo.codecadets.gameobjects.weapons.Shotgun;
import org.academiadecodigo.codecadets.gameobjects.weapons.Weapon;

public class WeaponsFactory {

    public static Weapon createWeapon() throws UnknownWeaponException {

        int random = (int) (Math.random() * WeaponTypes.values().length);

        WeaponTypes weaponType = WeaponTypes.values()[random];

        Weapon weapon = null;

        switch (weaponType) {

            case SHOTGUN:
                weapon = new Shotgun();
                break;
//TODO: Add more
            default:
               throw new UnknownWeaponException("I don't know what weapon is this!");
        }
        return weapon;
    }
}

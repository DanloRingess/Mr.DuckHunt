package org.academiadecodigo.codecadets.gameobjects.powerups;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.enums.PowerUpTypes;

public class Ammo extends PowerUp {

    private int ammoValue = 2;

    public Ammo() {
        super(PowerUpTypes.AMMO);
    }

    public int getAmmoValue() {
        return ammoValue;
    }
}

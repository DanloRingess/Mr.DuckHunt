package org.academiadecodigo.codecadets.enums;

public enum PowerUpTypes {
    AMMO;

    public static PowerUpTypes randomPowerUpType() {

        PowerUpTypes[] powerups = PowerUpTypes.values();
        return powerups[(int) (Math.random() * powerups.length)];
    }
}


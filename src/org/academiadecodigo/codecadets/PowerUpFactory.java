package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.PowerUpTypes;
import org.academiadecodigo.codecadets.exceptions.UnknownPowerUpException;
import org.academiadecodigo.codecadets.gameobjects.powerups.Ammo;
import org.academiadecodigo.codecadets.gameobjects.powerups.PowerUp;

public class PowerUpFactory {

    public static PowerUp createPowerUp() throws UnknownPowerUpException {

        PowerUpTypes powerUpType = PowerUpTypes.values()[(int) Math.random() * PowerUpTypes.values().length];

        PowerUp powerUp;

        switch (powerUpType) {

            case AMMO:
                powerUp = new Ammo();
                break;
            default:
                throw new UnknownPowerUpException("No power up found");
        }

        return powerUp;
    }
}

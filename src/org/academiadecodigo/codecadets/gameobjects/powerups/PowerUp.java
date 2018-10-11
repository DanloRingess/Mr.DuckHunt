package org.academiadecodigo.codecadets.gameobjects.powerups;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.enums.PowerUpTypes;

public class PowerUp {

    private PowerUpTypes powerUpType;

    public PowerUp(PowerUpTypes powerUpType){
        this.powerUpType = powerUpType;
    }

    public void activate() {

    }

    public PowerUpTypes getPowerUpType() {
        return powerUpType;
    }
}

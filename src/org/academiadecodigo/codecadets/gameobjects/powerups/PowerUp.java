package org.academiadecodigo.codecadets.gameobjects.powerups;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.enums.PowerUpTypes;

public abstract class PowerUp {

    private PowerUpTypes powerUpType;

    public PowerUp(PowerUpTypes powerUpType){
        this.powerUpType = powerUpType;
    }

    public abstract void activate(Game game);

    public PowerUpTypes getPowerUpType() {
        return powerUpType;
    }
}

package org.academiadecodigo.codecadets.gameobjects.props;

import org.academiadecodigo.codecadets.Game;
import org.academiadecodigo.codecadets.PowerUpFactory;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.powerups.PowerUp;

public abstract class Prop extends Target {

    private PowerUp powerup;

    public Prop() {
        powerup = PowerUpFactory.createPowerUp();
    }

    @Override
    public boolean hit() {
        destroy();
        powerup.activate();
        return true;
    }

    public PowerUp getPowerup() {
        return powerup;
    }
}

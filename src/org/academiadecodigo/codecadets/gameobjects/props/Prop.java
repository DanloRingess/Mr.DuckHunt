package org.academiadecodigo.codecadets.gameobjects.props;

import org.academiadecodigo.codecadets.PowerUpFactory;
import org.academiadecodigo.codecadets.exceptions.UnknownPowerUpException;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.powerups.PowerUp;
import org.academiadecodigo.codecadets.sound.Sound;

public class Prop extends Target {

    private PowerUp powerup;

    public Prop() {
        try {
            powerup = PowerUpFactory.createPowerUp();
        } catch (UnknownPowerUpException e) {
            System.out.println("Error adding powerup to prop!");
        }
    }

    @Override
    public boolean hit(int damage) {
        destroy();
        return true;
    }

    public PowerUp getPowerup() {
        return powerup;
    }
}

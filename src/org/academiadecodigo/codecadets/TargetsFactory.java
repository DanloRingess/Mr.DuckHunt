package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.exceptions.UnknownEnemyException;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.enemies.Duck;
import org.academiadecodigo.codecadets.gameobjects.enemies.DuckBoss;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;

public class TargetsFactory {

    public static Enemy createEnemy() throws UnknownEnemyException {

        EnemyTypes enemyType = EnemyTypes.values()[Math.random() >= 0.7 ? 1 : 0];

        Enemy enemy;

        switch (enemyType) {

            case DUCK:
                enemy = new Duck();
                break;
            case DUCKBOSS:
                enemy = new DuckBoss();
                break;
//TODO: Add more
            default:
               throw new UnknownEnemyException("I don't know what enemy is this!");
        }
        return enemy;
    }

/*
    public static Props createProps() {

        int random = (int) (Math.random() * PropType.values().lenght);
        PropType propType = PropType.values()[random];

        return prop;
    }
*/
}

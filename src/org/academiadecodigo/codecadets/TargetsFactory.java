package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.enums.PropTypes;
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
            default:
               throw new UnknownEnemyException("I don't know what enemy is this!");
        }
        return enemy;
    }


    public static Prop createProps(){

        int random = (int) (Math.random() * PropTypes.values().length);

        PropTypes propType = PropTypes.values()[random];

        Prop prop;

        switch(propType){

            case CRATE:
                prop = new Crate();
                break;
            case EGG:
                prop = new Egg();
                break;
        }
        return prop;
    }
}

package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.enums.PropTypes;
import org.academiadecodigo.codecadets.exceptions.UnknownTargetException;
import org.academiadecodigo.codecadets.gameobjects.enemies.Duck;
import org.academiadecodigo.codecadets.gameobjects.enemies.DuckBoss;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;
import org.academiadecodigo.codecadets.gameobjects.props.Prop;
import org.academiadecodigo.codecadets.gameobjects.props.Crate;
import org.academiadecodigo.codecadets.gameobjects.props.Egg;

public class TargetsFactory {

    public static Enemy createEnemy() throws UnknownTargetException {

        EnemyTypes enemyType = EnemyTypes.values()[Math.random() >= 0.83 ? 1 : 0];

        Enemy enemy;

        switch (enemyType) {

            case DUCK:
                enemy = new Duck();
                break;
            case DUCKBOSS:
                enemy = new DuckBoss();
                break;
            default:
               throw new UnknownTargetException("I don't know what enemy is this!");
        }
        return enemy;
    }


    public static Prop createProps() throws UnknownTargetException {

        int random = (int) (Math.random() * PropTypes.values().length);

        PropTypes propType = PropTypes.values()[random];

        Prop prop = null;

        switch(propType){

            case CRATE:
                prop = new Crate();
                break;
            case EGG:
                prop = new Egg();
                break;
            default:
                throw new UnknownTargetException("I don't know what prop is this!");
        }
        return prop;
    }
}

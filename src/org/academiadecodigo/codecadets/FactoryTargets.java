package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;

public class FactoryTargets {

    public static Enemy createEnemy() {
        int random = (int) (Math.random() * EnemyTypes.values().length);
        EnemyTypes enemyType = EnemyTypes.values()[random];

        Enemy enemy;

        switch(enemyType){
            case DUCK:
                enemy = new Enemy1();
                break;

            default:
                enemy = new Enemy1();
        }

        return enemy;
    }


    /*public static Prop createProps(){
        int random = (int) (Math.random() * PropTypes.values().length);
        PropTypes propType = PropTypes.values()[random];

        Prop prop;

        switch(PropType){
            case Prop1:
                prop = new Prop1();
                break;

            case Prop2:
                prop = new Prop2();
                break;

            default:
                prop = new Prop1();
        }
        return prop;
    }*/
}

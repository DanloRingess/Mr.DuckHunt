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

            case Enemy2:
                enemy = new Enemy2();
                break;

            default:
                enemy = new Enemy1();
        }

        return enemy;
    }

/*
    public static Props createProps(){
        int random = (int) (Math.random() * PropType.values().lenght);
        PropType propType = PropType.values()[random];
        return prop;
    }
*/
}

package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.gameobjects.Target;
import org.academiadecodigo.codecadets.gameobjects.enemies.Duck;
import org.academiadecodigo.codecadets.gameobjects.enemies.Enemy;

public class FactoryTargets {

    public static Enemy createEnemy() {
        int random = (int) (Math.random() * EnemyTypes.values().length);
        EnemyTypes enemyType = EnemyTypes.values()[random];

        Enemy enemy = null;

        switch(enemyType){
            case DUCK:
                enemy = new Duck();
                break;

            default:
                enemy = new Duck();
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

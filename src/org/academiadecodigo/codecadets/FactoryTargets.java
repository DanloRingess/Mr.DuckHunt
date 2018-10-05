package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.gameobjects.Target;

public class FactoryTargets {

    public static Enemy createEnemy() {
        int random = (int) (Math.random() * EnemyType.values().length);
        EnemyType enemyType = EnemyType.values()[random];
        return enemy;
    }

    public static Props createProps(){
        int random = (int) (Math.random() * PropType.values().lenght);
        PropType propType = PropType.values()[random];
        return prop;
    }
}

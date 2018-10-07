package org.academiadecodigo.codecadets;

import org.academiadecodigo.codecadets.gameobjects.Target;

public class FactoryTargets {

    public static Enemy createEnemy() {
        int random = (int) (Math.random() * EnemyType.values().length);
        EnemyType enemyType = EnemyType.values()[random];

        Enemy enemy;

        switch(enemyType){
            case Enemy1:
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


    public static Prop createProps(){
        int random = (int) (Math.random() * PropType.values().lenght);
        PropType propType = PropType.values()[random];

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
    }
}

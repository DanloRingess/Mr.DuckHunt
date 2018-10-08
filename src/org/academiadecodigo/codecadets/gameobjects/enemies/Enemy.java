package org.academiadecodigo.codecadets.gameobjects.enemies;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.gameobjects.Target;

public class Enemy extends Target {

     //proprieties:---------
    private int health;
    private EnemyTypes type;




    //methods:---------------

    public Enemy(EnemyTypes type){
        this.type = type;
        this.health = type.getHealth();
    }

    public int getHealth(){
        return health;
    }

    public boolean hit(int damage){

        health = health - damage > 0 ? health - damage : 0;

        if(health == 0){
            destroy();

            return true;
        }

        return false;
    }
}

package org.academiadecodigo.codecadets.gameobjects.enemies;

import org.academiadecodigo.codecadets.enums.EnemyTypes;
import org.academiadecodigo.codecadets.gameobjects.Target;

public class Enemy extends Target {

     //proprieties:---------
    private int health;
    private EnemyTypes type;




    //methods:---------------

    public int getHealth(){
        return health;
    }

    public void hit(int damage){

        health = health - damage > 0 ? health - damage : 0;

        if(health == 0){
            destroy();
        }
    }

    @Override
    public void move(int x, int y) {

    }
}

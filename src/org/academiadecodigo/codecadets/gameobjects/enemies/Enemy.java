package org.academiadecodigo.codecadets.gameobjects.enemies;

import org.academiadecodigo.codecadets.gameobjects.Target;

public class Enemy extends Target {

     //proprieties:---------
    private int health;
    private EnemyType type;



    //methods:---------------

    public int getHealth(){
        return health;
    }

    public void hit(){

        health = health - damage > 0 ? health - damage : 0;

        if(health == 0){
            destroid = true;
        }
    }





}

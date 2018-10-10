package org.academiadecodigo.codecadets;

public class Score {

    private int score;

    public int getScore(){
        return score;
    }

    public void changeScore(int score){
        this.score += score;
    }

    public void resetScore(){
        this.score = 0;
    }

}

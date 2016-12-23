package com.company;


import java.util.ArrayList;


/**
 * Created by Влад on 23.12.16.
 */
public class TimeFood extends Food {
    private final int min=30;
    private final int max=70;
    private int score;
    TimeFood()
    {

        score=(int)(Math.random()*(max-min+1))+min;
    }


    void generateTimeFood(ArrayList<SnakeCell> snakeList, ArrayList<WallCell> wallCells, Head snakeHead,Food food) {
        while (true) {
            this.x=GenX();
            this.y=GenY();
            //проверка на совпадение координат сгенерированной еды с координатами ячеек змеи
            if(CheckS(snakeList))
            {
                continue;
            }
            if(CheckW(wallCells))
            {
                continue;
            }
            if(this.equals(snakeHead)){
                continue;
            }
            if(this.equals1(food)){
                continue;
            }
            else break;

        }
    }


    boolean equals1(Food cell) {
        return this.x==cell.getX() && this.y==cell.getY();
    }
    int getScore(){return score;}
    void setScore(int score)
    {
      this.score=score;
    }
    void reloadScore()
    {
        score=(int)(Math.random()*(max-min+1))+min;
    }


}

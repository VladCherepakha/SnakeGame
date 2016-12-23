package com.company;
import java.util.*;


/**
 * Created by Влад on 18.12.16.
 */
public class Food extends Cell {
    void generateFood(ArrayList<SnakeCell> snakeList, ArrayList<WallCell> wallCells,Head snakeHead) {
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
            else break;

        }
    }
    boolean equals(SnakeCell cell) {
        return x == cell.getX() && y == cell.getY();
    }
    boolean equals(WallCell cell) {
        return x == cell.getX() && y == cell.getY();
    }
    boolean equals(Head head) {
        return x == head.getX() && y == head.getY();
    }
    int GenX(){
        int x;
        x = (int) (Math.random() * GameWindow.WINDOW_WIDTH) /Cellsize * Cellsize;
       return x;
    }
    int GenY(){
        int y;
        y = (int) (Math.random() * GameWindow.WINDOW_WIDTH) /Cellsize * Cellsize;
        return y;
    }
    boolean CheckS(ArrayList<SnakeCell> snakeCells)
    {
        for(SnakeCell cell: snakeCells)
        {
            if (this.equals(cell))
            {
                return true;
            }
        }
        return false;
    }
    boolean CheckW(ArrayList<WallCell> wallCells)
    {
        for(WallCell cell: wallCells)
        {
            if (this.equals(cell))
            {
                return true;
            }
        }
        return false;
    }


}

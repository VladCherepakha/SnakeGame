package com.company;
import java.util.*;


/**
 * Created by Влад on 18.12.16.
 */
public class Food extends Cell {
    void generateFood(ArrayList<SnakeCell> snakeList, ArrayList<WallCell> wallCells,Head snakeHead) {
        boolean loop = true;
        while (loop) {
            x = (int) (Math.random() * GameWindow.WINDOW_WIDTH) /Cellsize * Cellsize;
            y = (int) (Math.random() * GameWindow.WINDOW_HEIGHT) /Cellsize * Cellsize;
            loop = false;
            //проверка на совпадение координат сгенерированной еды с координатами ячеек змеи

            for (SnakeCell cell : snakeList) {
                if (this.equals(cell)) {
                    loop = true;
                }
            }
            for (WallCell wallCell : wallCells) {
                if (this.equals(wallCell)) {
                    loop = true;
                }
            }
            if(this.x==snakeHead.getX() && this.y==snakeHead.getY()){
                loop=true;
            }

        }
    }
    boolean equals(SnakeCell cell) {
        return x == cell.getX() && y == cell.getY();
    }
    boolean equals(WallCell cell) {
        return x == cell.getX() && y == cell.getY();
    }

}

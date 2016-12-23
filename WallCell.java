package com.company;

import java.util.ArrayList;

/**
 * Created by Влад on 19.12.16.
 */
public class WallCell extends Cell {
         void generateWall (ArrayList<SnakeCell>snakeList,Head snakeHead) {
            boolean loop = true;
            while (loop) {
                x = (int) (Math.random() * GameWindow.WINDOW_WIDTH) / Cellsize*Cellsize;
                y = (int) (Math.random() * GameWindow.WINDOW_HEIGHT) /Cellsize*Cellsize;
                loop = false;
                //проверка на совпадение координат стенок с координатами ячеек змейки
                for (SnakeCell cell : snakeList) {
                    if (this.equals(cell)) {
                        loop = true;
                    }
                }
                if(this.x==snakeHead.getX() || this.y==snakeHead.getY())
                {
                    loop=true;
                }
            }

        }
    public boolean equals(Object obj) {
        SnakeCell cell = (SnakeCell) obj;
        return this.x == cell.getX() && this.y == cell.getY();
    }
}

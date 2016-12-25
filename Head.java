package com.company;



/**
 * Created by Влад on 21.12.16.
 */
public class Head extends Cell {
    private String filepath;

    Head(int x, int y, String filepath) {
        this.x = x;
        this.y = y;
        this.filepath = filepath;
    }

     void setFilepath(String filepath) {
        this.filepath = filepath;
    }

     String getFilepath() {
        return filepath;
    }

    boolean equals1(WallCell wallcell) {
        return this.x == wallcell.getX() && this.y == wallcell.getY();
    }

    boolean equals1(Food foodcell) {
        return this.x == foodcell.getX() && this.y == foodcell.getY();
    }

    boolean equals1(Object obj) {
        SnakeCell cell = (SnakeCell) obj;
        return this.x == cell.getX() && this.y == cell.getY();
    }

    boolean equals1(TimeFood timeFood) {
        return this.x == timeFood.getX() && this.y == timeFood.getY();

    }
}

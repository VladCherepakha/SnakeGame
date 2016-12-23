package com.company;

/**
 * Created by Влад on 18.12.16.
 */
public class SnakeCell extends Cell {
    public SnakeCell(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public SnakeCell() {

    }
    void setSize(int size){
        this.Cellsize=size;
    }
}


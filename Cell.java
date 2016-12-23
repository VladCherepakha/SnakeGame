package com.company;

/**
 * Created by Влад on 19.12.16.
 */
public class Cell {
    protected int Cellsize=10;
    protected int x;
    protected int y;

    int getX()
     {
         return this.x;
     }
    int getY()
     {
         return this.y;
     }
    int getSize()
    {
        return Cellsize;
    }
    void setX(int x){
        this.x=x;
    }
    void setY(int y){
        this.y=y;
    }

}

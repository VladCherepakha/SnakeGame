package com.company;

import java.util.ArrayList;

/**
 * Created by Влад on 19.12.16.
 */
public class Labyrinth {
    private  final int NUMBER_OF_WALLCELLS = 100;
    private ArrayList<WallCell> wallCells = new ArrayList<WallCell>();
    private SnakeBody snake=new SnakeBody();
    private WallCell wall;

    public Labyrinth()
    {

        for(int i=0; i<NUMBER_OF_WALLCELLS;i++)
        {
            wall=new WallCell();
            wall.generateWall(snake.getCellList(),snake.getSnakeHead());
            wallCells.add(i,wall);
        }
    }
    int getNUMBER_OF_WALLCELLS(){
        return NUMBER_OF_WALLCELLS;
    }
    void reloadLabyrinth(){
        wallCells.clear();
        for(int i=0; i<NUMBER_OF_WALLCELLS;i++)
        {
            wall=new WallCell();
            wall.generateWall(snake.getCellList(),snake.getSnakeHead());
            wallCells.add(i,wall);
        }
    }

    ArrayList<WallCell> getWallCells() {
        return wallCells;
    }
}

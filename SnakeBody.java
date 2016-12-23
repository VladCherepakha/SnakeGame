package com.company;
import java.util.*;

/**
 * Created by Влад on 18.12.16.
 */
public class SnakeBody {
    private static final int NUMBER_OF_CELLS = 4;
    private int CELL_SIZE;
    private ArrayList<SnakeCell> snakeCells;
    private boolean allowToChangeDirection;
    private int snakeDirection;
    private Head snakeHead;
    public SnakeBody() {
        snakeCells = new ArrayList<SnakeCell>();
        allowToChangeDirection = true;
        snakeDirection = 39;
        SnakeCell cell=new SnakeCell();
        CELL_SIZE=cell.Cellsize;
        snakeHead=new Head((NUMBER_OF_CELLS+1)*CELL_SIZE,CELL_SIZE,"Pictures\\snakeHeadright.bmp");
        for(int i = 0; i < NUMBER_OF_CELLS; i++) {
            snakeCells.add(new SnakeCell(CELL_SIZE + i*CELL_SIZE, CELL_SIZE));

        }
    }
     Head getSnakeHead()
    {
        return snakeHead;
    }
     ArrayList<SnakeCell> getCellList() {
        return snakeCells;
    }

    //при рестарте игры задать настройки по умолчанию
     void reloadSnake() {
        snakeHead=new Head((NUMBER_OF_CELLS+1)*CELL_SIZE,CELL_SIZE,"Pictures\\snakeHeadright.bmp");
        snakeCells.clear();
        for(int i = 0; i < NUMBER_OF_CELLS; i++) {
            snakeCells.add(new SnakeCell(10 + i*CELL_SIZE, CELL_SIZE));
        }
        snakeDirection=39;
    }

    //(39 - код стрелки "Вправо") (37 - код стрелки "Влево") (40 - код стрелки "Вверх") (38 - код стрелки "Вниз")
     void setSnakeDirection(int direction) {
        if ((37 <= direction && direction <=40) && (Math.abs(snakeDirection - direction) != 2) && allowToChangeDirection)  {
            snakeDirection = direction;
            allowToChangeDirection = false;
        }
    }

     void move() {
        SnakeCell cell;
        cell = snakeCells.get(0);
        //если ячейка-хвост больше стандартного размера(в ней еда)
        //тогда ее не удаляем (сделаем змею больше)
        if(cell.getSize() == CELL_SIZE) {
            snakeCells.remove(0);
        } else {
            cell.setSize(CELL_SIZE);
            cell.setX(cell.getX() + 1);
            cell.setY(cell.getY() + 1);
        }
        switch(snakeDirection){
            case 40:	 snakeHead.setFilepath("Pictures\\snakeheaddown.bmp");
                snakeCells.add(new SnakeCell(snakeHead.getX(), snakeHead.getY()));
                snakeHead.setY(snakeHead.getY()+CELL_SIZE);
                if (snakeHead.getY() > GameWindow.WINDOW_HEIGHT - CELL_SIZE) { snakeHead.setY(0); }
                break;
            case 38:	snakeHead.setFilepath("Pictures\\snakeheadup.bmp");
                snakeCells.add(new SnakeCell(snakeHead.getX(), snakeHead.getY()));
                snakeHead.setY(snakeHead.getY()-CELL_SIZE);
                if (snakeHead.getY() < 0) { snakeHead.setY(GameWindow.WINDOW_HEIGHT - CELL_SIZE); }
                break;
            case 37:	snakeHead.setFilepath("Pictures\\snakeheadleft.bmp");
                snakeCells.add(new SnakeCell(snakeHead.getX(), snakeHead.getY()));
                snakeHead.setX(snakeHead.getX()-CELL_SIZE);
                if (snakeHead.getX()<0){snakeHead.setX(GameWindow.WINDOW_WIDTH - CELL_SIZE);}
                break;
            case 39:	snakeHead.setFilepath("Pictures\\snakeheadright.bmp");

                snakeCells.add(new SnakeCell(snakeHead.getX(), snakeHead.getY()));
                snakeHead.setX(snakeHead.getX()+CELL_SIZE);
               if(snakeHead.getX()>GameWindow.WINDOW_WIDTH - CELL_SIZE){snakeHead.setX(0);}
                break;
            default:	System.out.println("ошибка кода клавиши");
                break;
        }
        allowToChangeDirection = true;
    }
}



package com.company;
import javax.imageio.ImageIO;
import javax.swing.*; //подключение библиотеки Swing для создание стандартых графических объектов
import java.awt.*;// подключение библиотеки awt для создание простых графических объектов
import java.io.File;
import java.io.IOException;
import java.util.*;// подключение библиотеки util для работы с стандарнтым классом списка ArrayList

/**
 * Created by Влад on 18.12.16.
 */
public class GameField extends JPanel {//класс GameField наследует класс Ява-Панель библиотеки swing
    private ArrayList<SnakeCell> snakeList;//ссылка на список ячеек тела змеи
    private Food food; //объявление переменной для работы с объектами класса Food
    private SnakeBody snakeBody; // переменная для работы с объетом класса SnakeBody
    private ArrayList<WallCell> wallCells;
    private Image image;
    GameField(ArrayList<SnakeCell> snake, Food snakeFood, SnakeBody snakeFrame, ArrayList<WallCell> wallCells) {
        snakeBody = snakeFrame;
        snakeList = snake;
        food = snakeFood;
        this.wallCells=wallCells;
        this.setFocusable(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.white);
        this.setPreferredSize(new Dimension(GameWindow.WINDOW_WIDTH,GameWindow.WINDOW_HEIGHT));
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        for(SnakeCell cell: snakeList) {
            g.setColor(Color.RED);
            g.fillRect(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
            g.setColor(Color.BLACK);
            g.drawRect(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
        }
        try {
            image=ImageIO.read(new File(snakeBody.getSnakeHead().getFilepath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image,snakeBody.getSnakeHead().getX(),snakeBody.getSnakeHead().getY(),null);
        g.setColor(Color.BLUE);
        g.fillRect(food.getX(), food.getY(), food.getSize(), food.getSize());
        for(WallCell cell: wallCells)
        {
            g.setColor(Color.YELLOW);
            g.fillRect(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
            g.setColor(Color.BLACK);
            g.drawRect(cell.getX(), cell.getY(), cell.getSize(), cell.getSize());
        }
    }
}



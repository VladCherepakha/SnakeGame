package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Created by Влад on 18.12.16.
 */
public class GameWindow {
    static final int WINDOW_WIDTH = 350;
    static final int WINDOW_HEIGHT = 350;
    private JFrame mainFrame = new JFrame();
    private JLabel endGameLabel = new JLabel();
    private SnakeBody snake = new SnakeBody();
    private GameField snakeField;
    private ScorePanel scorePanel = new ScorePanel();
    private Food food = new Food();
    private Labyrinth labyrinth=new Labyrinth();
    private TimeFood timeFood;
    private boolean allowToRestartTheGame = false;
    private boolean allowToMoveSnake = true;
    private int timeBetweenMoves;
    private int scoreToChangeSpeedLevel;
    void setUpGame() {
        timeBetweenMoves = 180;
        timeFood=new TimeFood();
        scoreToChangeSpeedLevel = 100;
        food.generateFood(snake.getCellList(),labyrinth.getWallCells(),snake.getSnakeHead());
        timeFood.generateTimeFood(snake.getCellList(),labyrinth.getWallCells(),snake.getSnakeHead(),food);
        setUpGUI();
        while(true) {
            if (!allowToMoveSnake) {
                continue;
            }
            snakeField.repaint();
            scorePanel.showScore(timeFood.getScore());
            try {
                Thread.sleep(timeBetweenMoves);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            snake.move();
            checkIfSnakeGotFood(snake.getSnakeHead());
            checkIfSnakeGotTimeFood(snake.getSnakeHead());
            timeFood.setScore(timeFood.getScore()-1);
            if(timeFood.getScore()==0)
            {
                timeFood.generateTimeFood(snake.getCellList(),labyrinth.getWallCells(),snake.getSnakeHead(),food);
                timeFood.reloadScore();
            }
            if((scorePanel.getScore()) >= scoreToChangeSpeedLevel && scorePanel.getScore()<scoreToChangeSpeedLevel*2) {
                timeBetweenMoves -= 25;
                scorePanel.incLevel(1);
                scoreToChangeSpeedLevel += 100;
            }
            if(snakeCollapsed(snake.getSnakeHead())|| snakeCrashedinWall(snake.getSnakeHead(),labyrinth)) {
                endGameLabel.setText("You have lost. Want to restart the game? Y(да)/N(нет)");
                allowToRestartTheGame = true;
                allowToMoveSnake = false;
            }
        }
    }

    private void checkIfSnakeGotFood(Head snakeHead) {
        SnakeCell cell=snake.getCellList().get(0);
        if (snakeHead.equals1(food)) {
            food.generateFood(snake.getCellList(),labyrinth.getWallCells(),snake.getSnakeHead());
            cell.setSize(cell.getSize() + 2);
            cell.setX(cell.getX() - 1);
            cell.setY(cell.getY() - 1);
            scorePanel.incScore(10);
        }

    }
    private void checkIfSnakeGotTimeFood(Head snakeHead) {
        SnakeCell cell=snake.getCellList().get(0);
        if (snakeHead.equals1(timeFood)) {
            timeFood.generateTimeFood(snake.getCellList(),labyrinth.getWallCells(),snake.getSnakeHead(),food);
            cell.setSize(cell.getSize() + 2);
            cell.setX(cell.getX() - 1);
            cell.setY(cell.getY() - 1);
            scorePanel.incScore(timeFood.getScore());
        }

    }


    private boolean snakeCollapsed(Head snakeHead) {
        ArrayList<SnakeCell> cellList = snake.getCellList();
        Iterator itr = cellList.listIterator();
        while(itr.hasNext()){
            if(snakeHead.equals1(itr.next()) && itr.hasNext()) {
                return true;
            }
        }
        return false;
    }
    private boolean snakeCrashedinWall(Head snakeHead,Labyrinth labyrinth) {

        for(int i=0;i<labyrinth.getNUMBER_OF_WALLCELLS();i++)
        {
            if(snakeHead.equals1(labyrinth.getWallCells().get(i)))
            {
                return true;
            }
        }
        return false;
    }

    private void setUpGUI() {
        snakeField = new GameField(snake.getCellList(), food, snake,labyrinth.getWallCells(),timeFood);
        snakeField.addKeyListener(new SnakeKeyListener());
        snakeField.add(endGameLabel);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.getContentPane().add(BorderLayout.CENTER, snakeField);
        mainFrame.getContentPane().add(BorderLayout.EAST, scorePanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
        mainFrame.setTitle("2D-Аркада Змейка");
    }

    private void restartGame() {
        snake.reloadSnake();
        scorePanel.reloadPanel();
        scorePanel.repaint();
        endGameLabel.setText("");
        labyrinth.reloadLabyrinth();
        allowToMoveSnake = true;
        timeBetweenMoves=180;
        scoreToChangeSpeedLevel=100;

    }

    class SnakeKeyListener implements KeyListener {
        public void keyPressed(KeyEvent e) {
            snake.setSnakeDirection(e.getKeyCode());
            if (e.getKeyCode() == 89 && allowToRestartTheGame) {
                allowToRestartTheGame = false;
                restartGame();
            }
            if(e.getKeyCode()==78 && allowToRestartTheGame)
            {
                System.exit(1);
            }
            if(e.getKeyCode()==27 && !allowToRestartTheGame){
                System.exit(1);
            }
            if(e.getKeyCode()==80 && !allowToRestartTheGame){
                allowToMoveSnake=false;
            }
            if(e.getKeyCode()==79 && !allowToMoveSnake)
            {
                allowToMoveSnake=true;
            }


        }
        public void keyReleased(KeyEvent e) { }
        public void keyTyped(KeyEvent e) { }
    }
}


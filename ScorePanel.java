package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Влад on 18.12.16.
 */
//считает и показывает ваши очки
    public class ScorePanel extends JPanel {
    private static final int SCORE_WIDTH = 150;
    private int score = 0;
    private int level = 1;
    private JLabel scoreLabel = new JLabel("Your score:");
    private JLabel actualScore = new JLabel("0");
    private JLabel speedLvl = new JLabel("Speed lvl:");
    private JLabel actualSpeedLvl = new JLabel("1");
    private JLabel exitLabel=new JLabel("Press Esc to exit");
    private JLabel onPauseLabel=new JLabel("Press P to take pause");
    private JLabel offPauseLabel=new JLabel("Press O to continue");
     ScorePanel() {
        this.add(scoreLabel);
        this.add(actualScore);
        this.add(speedLvl);
        this.add(actualSpeedLvl);
         this.add(exitLabel);
         this.add(onPauseLabel);
         this.add(offPauseLabel);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(new Dimension(SCORE_WIDTH,GameWindow.WINDOW_HEIGHT));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

     void incScore(int inc) {
        score += inc;
        actualScore.setText(Integer.toString(score));
    }

     void incLevel(int inc) {
        level += inc;
        actualSpeedLvl.setText(Integer.toString(level));
    }

     int getScore() {
        return score;
    }

     void reloadPanel() {
        score = 0;
        level = 1;
        actualScore.setText(Integer.toString(score));
        actualSpeedLvl.setText(Integer.toString(level));
    }
}
package com.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //snake structure
    int length; //length of snake
    int[] snakeX = new int[600]; //x coordinate
    int[] snakeY = new int[500]; //y coordinate

    String fx;

    //default game status
    boolean isStart = false;

    //constructor
    public GamePanel() {
        init();
    }

    //init the method
    public void init() {
        length = 3;
        //coordinate of head
        snakeX[0] = 100; snakeY[0] = 100;
        //coordinate of body
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50; snakeY[2] = 100;
        fx = "R";
    }

    //draw the panel
    @Override
    protected void paintComponent(Graphics g) {
        //dispose the panel
        super.paintComponent(g);
        //draw the static panel
        this.setBackground(Color.darkGray);
        DataCenter.header.paintIcon(this, g, 25, 11);
        //default panel
        g.fillRect(25, 75, 850, 600);

        //draw the snake
        if (fx.equals("R")) {
            DataCenter.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            DataCenter.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            DataCenter.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("D")) {
            DataCenter.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i = 1; i < length; i++) {
            DataCenter.body.paintIcon(this, g, snakeX[i], snakeY[i]);

        }

        if (!isStart) {
            g.setColor(Color.white);
            g.setFont(new Font("Jazz LET", Font.BOLD, 20));
            g.drawString("Press the space to start the game", 270, 300);
        }
    }
}

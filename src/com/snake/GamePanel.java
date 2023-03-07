package com.snake;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener, ActionListener {
    //snake structure
    int length; //length of snake
    int[] snakeX = new int[600]; //x coordinate
    int[] snakeY = new int[500]; //y coordinate

    String fx;

    int foodX;
    int foodY;
    Random random = new Random();

    //score
    int score;

    //rank
    int rank;

    //default game status
    boolean isStart = false;

    //failed status
    boolean isFail = false;

    //execute the snake each 100 ms
    Timer timer = new Timer(100, this);


    //constructor
    public GamePanel() {
        init();
        //get the keyboard event listener
        this.setFocusable(true);
        //get the focus event listener
        this.addKeyListener(this);
        timer.start();
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

        //init the food
        foodX = 25 + 25 * random.nextInt(34);
        foodY = 75 + 25 * random.nextInt(24);

        score = 0;
        rank = 1;
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

        //draw the score
        g.setColor(Color.black);
        g.setFont(new Font("Jazz LET", Font.BOLD, 20));
        g.drawString("Rank: " + rank, 650, 30);
        g.drawString("Length: " + length, 740, 30);
        g.drawString("Score: " + score, 740, 50);

        //draw the food
        DataCenter.food.paintIcon(this, g, foodX, foodY);

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

        //game status
        if (!isStart) {
            g.setColor(Color.white);
            g.setFont(new Font("Jazz LET", Font.BOLD, 20));
            g.drawString("Press the space to start the game", 260, 300);
        }

        if (isFail) {
            g.setColor(Color.RED);
            g.setFont(new Font("Jazz LET", Font.BOLD, 20));
            g.drawString("Failed. Press the space to restart the game", 260, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isStart && !isFail) {
            //eat
            if (snakeX[0] == foodX && snakeY[0] == foodY) {
                //grow body
                length++;
                //add score
                score += 10;
                //add rank
                rank = score / 50 + 1;
                if (rank > 1) {
                    timer.setDelay(100 - rank * 5);
                }
                //add food
                foodX = 25 + 25 * random.nextInt(34);
                foodY = 75 + 25 * random.nextInt(24);
            }

            //move
            for (int i = length - 1; i > 0; i--) {
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }

            switch (fx) {
                case "R" -> {
                    snakeX[0] = snakeX[0] + 25;
                    if (snakeX[0] > 850) {
                        snakeX[0] = 25;
                    }
                }
                case "L" -> {
                    snakeX[0] = snakeX[0] - 25;
                    if (snakeX[0] < 25) {
                        snakeX[0] = 850;
                    }
                }
                case "D" -> {
                    snakeY[0] = snakeY[0] + 25;
                    if (snakeY[0] > 650) {
                        snakeY[0] = 75;
                    }
                }
                case "U" -> {
                    snakeY[0] = snakeY[0] - 25;
                    if (snakeY[0] < 75) {
                        snakeY[0] = 650;
                    }
                }
            }

            //determine if the game is failed
            for (int i = 1; i < length; i++) {
                if (snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]) {
                    isFail = true;
                }
            }

            if (snakeX[0] == snakeX[1] && snakeY[0] == snakeY[1]) {
                isFail = true;
            }
            
            // repaint the panel
            repaint();
        }
        //start the timer
        timer.start();
    }

    //keyboard event listener
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //Press space to start the game
        if (keyCode == KeyEvent.VK_SPACE) {
            if (isFail) {
                isFail = false;
                init();
            } else {
                isStart = !isStart;
            }
            repaint();
        }

        //move the snake
        if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        } else if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}

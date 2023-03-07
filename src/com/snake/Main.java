package com.snake;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(10, 10,900, 720);
        //windows size cannot be changed
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}

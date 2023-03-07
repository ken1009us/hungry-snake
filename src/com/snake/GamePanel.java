package com.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //Draw the panel
    @Override
    protected void paintComponent(Graphics g) {
        //dispose the panel
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
    }
}

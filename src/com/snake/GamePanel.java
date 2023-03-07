package com.snake;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    //Draw the panel
    @Override
    protected void paintComponent(Graphics g) {
        //dispose the panel
        super.paintComponent(g);
        //draw the static panel
        this.setBackground(Color.darkGray);
        DataCenter.header.paintIcon(this, g, 25, 11);
        //default panel
        g.fillRect(25, 75, 850, 600);
    }
}

package com.snake;

import javax.swing.*;
import java.net.URL;

public class DataCenter {
    public static URL headerURL = DataCenter.class.getResource("static/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);
    public static URL upURL = DataCenter.class.getResource("static/up.png");
    public static URL downURL = DataCenter.class.getResource("static/down.png");
    public static URL leftURL = DataCenter.class.getResource("static/left.png");
    public static URL rightURL = DataCenter.class.getResource("static/right.png");
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);

    public static URL bodyURL = DataCenter.class.getResource("static/body.png");
    public static ImageIcon body = new ImageIcon(bodyURL);

    public static URL foodURL = DataCenter.class.getResource("static/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);

}

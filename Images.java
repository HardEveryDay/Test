package com.msb.game;

import javax.swing.*;
import java.net.URL;

public class Images {
    /*
    现在是面向对象的思维，必须封装为一个对象
     */
    //将图片的路径封装为一个对象
    public static URL bodyURL = Images.class.getResource("/images/body.png");
    //将图片封装为程序中一个对象
    public static ImageIcon bodyImg = new ImageIcon(bodyURL);
    //将图片的路径封装为一个对象
    public static URL downURL = Images.class.getResource("/images/down.png");
    //将图片封装为程序中一个对象
    public static ImageIcon downImg = new ImageIcon(downURL);
    //将图片的路径封装为一个对象
    public static URL foodURL = Images.class.getResource("/images/food.png");
    //将图片封装为程序中一个对象
    public static ImageIcon foodImg = new ImageIcon(foodURL);
    //将图片的路径封装为一个对象
    public static URL headerURL = Images.class.getResource("/images/header.png");
    //将图片封装为程序中一个对象
    public static ImageIcon headerImg = new ImageIcon(headerURL);
    //将图片的路径封装为一个对象
    public static URL leftURL = Images.class.getResource("/images/left.png");
    //将图片封装为程序中一个对象
    public static ImageIcon leftImg = new ImageIcon(leftURL);
    //将图片的路径封装为一个对象
    public static URL rightURL = Images.class.getResource("/images/right.png");
    //将图片封装为程序中一个对象
    public static ImageIcon rightImg = new ImageIcon(rightURL);
    //将图片的路径封装为一个对象
    public static URL upURL = Images.class.getResource("/images/up.png");
    //将图片封装为程序中一个对象
    public static ImageIcon upImg = new ImageIcon(upURL);
}


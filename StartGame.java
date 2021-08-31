package com.msb.game;

import javax.swing.*;
import java.awt.*;

public class StartGame {
    public static void main(String[] args) {
        //创建一个窗体
        JFrame jf = new JFrame();
        //给窗体设置一个标题
        jf.setTitle("小游戏 大逻辑 by 木子李");
        //设置窗体弹出的坐标，设置窗体的宽高。
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        jf.setBounds((width-800)/2,(height-800)/2,800,800);
        //设置窗口大小不可调节
        jf.setResizable(false);
        //关闭窗口的同时，程序随之关闭
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //创建面板，
        GamePane1 gp = new GamePane1();
        //将面板放入窗体
        jf.add(gp);
        //默认情况下窗体是隐藏的，必须将窗体进行显现。显现的方法最好放到最后，
        jf.setVisible(true);

    }
}

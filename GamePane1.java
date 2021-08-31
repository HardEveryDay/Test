package com.msb.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

//继承JPanel
public class GamePane1 extends JPanel {
    //蛇的长度
    int length;
    //定义两个数组，一个存X轴坐标，一个存y轴坐标。
    int[] snakeX = new int[200];
    int[] snakeY = new int[200];
    //游戏只有两个状态，开始，暂停；
    boolean isStart = false;//默认游戏是暂停的；
    //加入一个定时器；
    Timer timer;
    //定义蛇的行走方向；
    String direction;
    //定义食物的x，y轴坐标；
    int foodX;
    int foodY;
    //定义一个积分成绩；
    int score;
    //加入一个变量，判断小蛇是否死亡；
    boolean isDie = false;//默认情况下没有死亡
    //初始化方法；
    public void  init (){
        //初始化蛇的长度；
        length = 3;
        //初始化蛇头坐标；
        snakeX[0]=175;
        snakeY[0]=275;
        //初始化第一节身子坐标；
        snakeX[1]=150;
        snakeY[1]=275;
        //初始化第二节身子坐标；
        snakeX[2]=125;
        snakeY[2]=275;
        //初始化蛇头的方向；
        direction = "R";//U D L R
        //初始化食物的坐标
        foodX = 300;
        foodY = 200;
    }
    public GamePane1(){
        init();
        //将焦点定位到当前操作的面板上;
        this.setFocusable(true);
        //加入监听；
        this.addKeyListener(new KeyAdapter() {
            @Override
            //监听键盘的按下操作；
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);
                //监听空格
                if (keyCode==KeyEvent.VK_SPACE){
                    if (isDie) {
                        //全部恢复到初始状态
                        init();
                        isDie=false;
                    }else {//小蛇没有死亡情况下
                        isStart=!isStart;
                        repaint();//重绘动作
                    }
                }
                //监听上箭头
                if (keyCode==KeyEvent.VK_UP){
                    direction = "U";
                }
                //监听下箭头
                if (keyCode==KeyEvent.VK_DOWN){
                    direction = "D";
                }
                //监听左箭头
                if (keyCode==KeyEvent.VK_LEFT){
                    direction = "L";
                }
                //监听右箭头
                if (keyCode==KeyEvent.VK_RIGHT){
                    direction = "R";
                }
            }
        });
        //对定时器进行初始化动作
        timer= new Timer(100, new ActionListener() {
            /*
            ActionListener 是事件监听，相当于每100毫秒监听一下你是否发生动作
            具体的动作放入actionPerformed
            */
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isStart==true&&isDie==false){//游戏是开始状态的时候，蛇才动；
                    //后一节身子走到前一节的位置上；
                    for (int i =length-1;i>0;i--){
                        snakeX[i]=snakeX[i-1];
                        snakeY[i]=snakeY[i-1];
                    }
                    //动蛇头
                    if ("R".equals(direction)) {
                        snakeX[0]+=25;
                    }
                    if ("L".equals(direction)) {
                        snakeX[0]-=25;
                    }
                    if ("U".equals(direction)) {
                        snakeY[0]-=25;
                    }
                    if ("D".equals(direction)) {
                        snakeY[0]+=25;
                    }
                    //防止蛇超出边界
                    if (snakeX[0]>750){
                        snakeX[0]=25;
                    }
                    if (snakeX[0]<25){
                        snakeX[0]=750;
                    }
                    if (snakeY[0]<100){
                        snakeY[0]=725;
                    }
                    if (snakeY[0]>725){
                        snakeY[0]=100;
                    }
                    //检测吃到食物碰撞动作
                    if (snakeX[0]==foodX&&snakeY[0]==foodY) {
                        //蛇的长度加1
                        length++;
                        //食物的坐标改变,坐标必须是25的倍数；
                        foodX = ((int) (Math.random()*30)+1)*25;//[25到750]
                        foodY = (new Random().nextInt(26)+4)*25;//[100到725]
                        //吃上食物积分成绩加10
                        score+=10;
                    }
                    //死亡判定
                    for (int i =1;i<length;i++){
                        if (snakeX[0]==snakeX[i]&&snakeY[0]==snakeY[i]) {
                            //将死亡状态改为ture
                            isDie=true;
                        }

                    }
                    repaint();//重绘界面
                }
            }
        });
        //定时器必须要启动
        timer.start();
    }
    //paintComponent 这个方法比较特殊，这个方法就属于图形版main方法，自动调用
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //填充背景颜色，
        this.setBackground(new Color(32, 194, 137, 245));
        //画头部的图片
        Images.headerImg.paintIcon(this,g,10,10);
        //调节画笔颜色
        g.setColor(new Color(156, 138, 96, 255));
        //画一个矩形
        g.fillRect(10,70,770,685);
        //画小蛇
        //画蛇头
        if ("R".equals(direction)) {
            Images.rightImg.paintIcon(this, g, snakeX[0], snakeY[0]);
        }
        if ("L".equals(direction)){
        Images.leftImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if ("U".equals(direction)){
            Images.upImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        if ("D".equals(direction)){
            Images.downImg.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        /*画第一节蛇身子
        Images.bodyImg.paintIcon(this,g,snakeX[1],snakeY[1]);
        画第二节蛇身子
        Images.bodyImg.paintIcon(this,g,snakeX[2],snakeY[2]);*/
        //循环画蛇的身子；
        for (int i = 1;i<length;i++){
            Images.bodyImg.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
        //如果游戏是暂停的，界面中就应该有提示语；
        if (isStart==false){
            //画一个文字，画笔颜色
            g.setColor(new Color(189, 70, 42, 255));
            //三个参数，字体，加粗，字号
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            //画文字,三个参数，文字内容，横坐标，纵坐标
            g.drawString("点击空格开始游戏",250,330);
        }
        //画食物；
        Images.foodImg.paintIcon(this,g,foodX,foodY);
        //画积分文字
        g.setColor(new Color(29, 27, 27, 255));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString("积分："+score,620,40);

        //画死亡提示
        if (isDie){
            g.setColor(new Color(206, 34, 34, 255));
            g.setFont(new Font("微软雅黑",Font.BOLD,20));
            g.drawString("小蛇死亡，按空格重新开始游戏",200,330);
        }
    }
}

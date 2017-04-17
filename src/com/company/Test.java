package com.company;

import Model.*;
import Model.Shape;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame implements Runnable{
    static int top,left,bottom,right,height,width;
    public void  test()
    {

    }

    static Test test = new Test();
    Shape shape = new ShapeFactory().getshape();
    Ground ground = new Ground();
    static void getvar(){
        Insets insets = test.getInsets();
        System.out.println(insets);
        top = insets.top;
        left = insets.left;
        right = insets.right;
        bottom = insets.bottom;
        height = test.getHeight();
        width = test.getWidth();
    }
    public static void main(String[] args) {
        int width = 606;
        int height = 1000+32;

        test.setSize(width,height);                                         //设置宽高
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                //默认退出
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();  //获取计算机屏幕大小
        test.setLocation((dimension.width-width)/2,(dimension.height-height)/2);    //居中
        test.setResizable(false);               //禁止大小调整
        test.setTitle("hello world");
        test.setVisible(true);
        getvar();
        Thread thread = new Thread(test);
        thread.start();
    }
    public void paint(Graphics g) {
        super.paint(g);
        int sidelengh = 50;
        int x1 = sidelengh+left, y1 = sidelengh + top;
        for (int i = 0; i < 20; i++) {
            g.drawLine(x1, y1, width - x1, y1);
            y1 += sidelengh;
        }
        y1 = sidelengh+top;
//        g.drawLine(x1, top, x1, height);
//        g.drawLine(width - x1, 0, width - x1, height);
        for (int i = 0; i < 10; i++)
        {
            g.drawLine(x1,y1,x1,height);
            x1+=sidelengh;
        }
        g.setColor(Color.YELLOW);
        g.fill3DRect(x1,top,sidelengh,height,true);
        g.fill3DRect(0,top,sidelengh+right+1,height,true);

        shape.draw(test.getGraphics());
        ground.draw(test.getGraphics());
    }


    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
    }

    @Override
    protected void frameInit() {
        super.frameInit();
    }

    @Override
    public void run() {
        shape.draw(test.getGraphics());
        while (shape.candown())
        {
            repaint();
            shape.down();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

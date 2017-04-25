package com.company.view;

import com.company.model.*;
import com.company.model.Shape;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    static int top,left,bottom,right,height,width;

    Shape shape ;
    Ground ground;


    public Test(){
        int width = 606;
        int height = 1000+32;

        this.setSize(width,height);                                         //设置宽高
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                //默认退出
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();  //获取计算机屏幕大小
        this.setLocation((dimension.width-width)/2,(dimension.height-height)/2);    //居中
        this.setResizable(false);               //禁止大小调整
        this.setTitle("俄罗斯方块");
        this.setVisible(true);
        getvar();
    }

    void getvar(){
        Insets insets = this.getInsets();
        System.out.println(insets.toString());
        top = insets.top;
        left = insets.left;
        right = insets.right;
        bottom = insets.bottom;
        height = this.getHeight();
        width = this.getWidth();
    }

    public void display(Ground ground , Shape shape)
    {
            this.shape  = shape;
            this.ground = ground;
            this.repaint();

    }


    public void paint(Graphics g) {
        super.paint(g);
        int sidelengh = 50;                                         //边长
        int x1 = sidelengh+left, y1 =  top;
        for (int i = 0; i < 20; i++) {
            g.drawLine(x1, y1, width - x1, y1);
            y1 += sidelengh;
        }

        y1 =top;

        for (int i = 0; i < 10; i++)
        {
            g.drawLine(x1,y1,x1,height);
            x1+=sidelengh;
        }
        g.setColor(new Color(38,50,56));
        g.fill3DRect(x1,top,sidelengh,height,true);
        g.fill3DRect(0,top,sidelengh+right+1,height,true);
        if (shape!=null&&ground!=null) {
            shape.draw(g);
            ground.draw(g);
        }
    }

    @Override
    public void paintComponents(Graphics g) {
        int sidelengh = 50;
        int x1 = sidelengh+left, y1 = sidelengh + top;
        for (int i = 0; i < 20; i++) {
            g.drawLine(x1, y1, width - x1, y1);
            y1 += sidelengh;
        }

        y1 = sidelengh+top;

        for (int i = 0; i < 10; i++)
        {
            g.drawLine(x1,y1,x1,height);
            x1+=sidelengh;
        }
        g.setColor(Color.YELLOW);
        g.fill3DRect(x1,top,sidelengh,height,true);
        g.fill3DRect(0,top,sidelengh+right+1,height,true);
        if (shape!=null&&ground!=null) {
            shape.draw(g);
            ground.draw(g);
        }
    }
}

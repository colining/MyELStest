package com.company.view;

import com.company.model.*;
import com.company.model.Shape;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asus on 2017/4/22.
 */
public class Testpanel extends JPanel{
   // static int top,left,bottom,right,height,width;
    static int height,width,top;
    Shape shape;
    Ground ground;


    public Testpanel() {
        int width = 600;
        int height = 1000;
        this.setSize(width,height);                                         //设置宽高
//        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();  //获取计算机屏幕大小
//        this.setLocation((dimension.width-width)/2,(dimension.height-height)/2);    //居中
        this.setVisible(true);
        getvar();
    }

    void getvar(){
        Insets insets = this.getInsets();
        height = this.getHeight();
        width = this.getWidth();
        top = 32;
        System.out.println(insets.toString());
    }
    public void display(Ground ground , Shape shape)
    {
        this.shape  = shape;
        this.ground = ground;
        this.repaint();

    }
    public void update(Graphics g){
            paint(g);
    }
    public void paint(Graphics g) {
        super.paint(g);
        int sidelengh = 50;                                         //边长
        int x1 = sidelengh, y1 =0;
        for (int i = 0; i < 20; i++) {
             //g.drawLine(x1, y1, width - x1, y1);
            y1 += sidelengh;
        }
        y1 =0;
        for (int i = 0; i < 10; i++)
        {
            //g.drawLine(x1,y1,x1,height);
            x1+=sidelengh;
        }

        g.setColor(new Color(38,50,56));
        g.fill3DRect(x1,0,sidelengh,height,true);
        g.fill3DRect(0,0,sidelengh,height,true);
        if (shape!=null&&ground!=null) {
            shape.draw(g);
            ground.draw(g);
        }

    }


}

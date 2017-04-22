package Model;

import Controller.ShapeListener;

import java.awt.*;

import static util.util.*;

/**
 * Created by asus on 2017/4/17.
 */
public class Shape {
        int top = 0;
        int left = CELLWEITH/2-2;
        int [][]body;
        int shapekind;                                          //形状类型
        int state =0;
        ShapeListener shapeListener;
    public int getShapekind() {
        return shapekind;
    }

    public void setShapekind(int shapekind) {
        this.shapekind = shapekind;
    }

    public int getState() {
        return state;
    }

    public Shape() {

    }
    public void  newThreed()
    {
            new Thread(new shapeDriver()).start();

    }
    public void setState(int state) {
        this.state = state;
    }

                        //当前的形状是哪个状态；
    public void setBody(int[][] body) {
        this.body = body;

    }
    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void down()
    {
        top++;

    }
    public boolean candown()
    {
        if (top>=18)
            return false;
        return true;
    }
    public void moveleft()
    {
        left--;
    }
    public void moveright()
    {
        left++;
    }
    public void rotate()
    {
        state = (state+1)%body.length;
    }
    public Color getcolor()
    {
        Color color = null;
        switch (shapekind)
        {
            case 0: color = new Color(171,71,188);
            break;
            case 1: color = new Color(33,150,243);
            break;
            case 2: color = new Color(76,175,80);
            break;
            case 3: color = new Color(121,85,72);
            break;
            case 4: color = new Color(96,125,139);
            break;
            case 5: color = new Color(255,87,34);
            break;
            case 6: color = new Color(244,143,177);
            break;
        }
        return color;
    }
    /*
    绘图形状自身；
     */
    public  void  draw (Graphics g)
    {

        g.setColor(getcolor());
        for (int x = 0 ; x<4; x++)
            for (int y= 0 ; y<4 ;y++)
            {
                if (getFlagByPos(x,y))
                g.fill3DRect((left+x)*50+53,(top+y)*50+33,50,50,true);
            }
    }
    /*
    判定当前是否存在矩形
     */
    private boolean getFlagByPos(int x, int y) {
        return body[state][y*4+x] == 1;
    }
    /*
    对整个边长4的矩形，探测是否有小矩形，如果当前是旋转，便探测旋转后的
     */
    public boolean isMember(int x , int y ,boolean rotate)
    {
        int temp = state;
        if (rotate)
            temp = (state+1)%body.length;
        return body[temp][y*4+x] ==1;
    }
    public void addListenser(ShapeListener shapeListener1)
    {
        if (shapeListener1!=null)
            this.shapeListener = shapeListener1;
        newThreed();
    }
    private class shapeDriver implements  Runnable
    {
        @Override
        public void run() {

            while (shapeListener.shapeIsMoveDownable(Shape.this)) {
                    down();
                    shapeListener.shapeMoveDown(Shape.this);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        }
    }

}

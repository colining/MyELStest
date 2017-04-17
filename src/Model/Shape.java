package Model;

import java.awt.*;

import static util.util.*;

/**
 * Created by asus on 2017/4/17.
 */
public class Shape {
        int top = 0;                    //distance of top
        int left = 0;                   //distance of left
    int [][]body;

    public void setState(int state) {
        this.state = state;
    }

    int state =0;                     //当前的形状是哪个状态；
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

    public  void  draw (Graphics g)
    {

        g.setColor(Color.blue);
        int j =16;
        for (int i = 0; i < j; i++) {
            if (body[0][i]==1)
            {
                g.fillRect((i % 4 + left + 1) * 50+53, (i / 4 + top) * 50+32+50, 50, 50);
            }
        }
    }
}

package Model;

import java.awt.*;

/**
 * Created by asus on 2017/4/17.
 */
public class Ground {
    private int [][] ground = new int[10][19];

    public void draw(Graphics g)
    {
        for (int i = 0 ; i <10;i++)
            for (int j = 0 ; j< 19 ; j++)
            {
                if (ground[i][j]==1)
                {
                    g.fill3DRect(i*50+53,j*50+32+50,50,50,true);
                }
            }
    }
    public void add(Shape shape)
    {
        int x = shape.getLeft();
        int y = shape.getTop();
        int i = 16;
        for (int i1 = 0; i1 < i; i1++) {
            if(shape.body[0][i]==1)
            {
                int x1 = i%4;
                int y2 = i/4;
                ground[x+x1][y+y2] = 1;
            }
        }
    }
}

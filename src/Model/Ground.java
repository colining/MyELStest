package Model;

import com.company.MyEnum.ShapeAction;

import java.awt.*;

import static util.util.CELLHEIGTH;
import static util.util.CELLWEITH;
import static util.util.shape;

/**
 * Created by asus on CELLHEIGTH17/4/17.
 */
public class Ground {
    private int [][] ground = new int[CELLWEITH][CELLHEIGTH];

    /*
    画障碍物
     */

    public void draw(Graphics g)
    {
        for (int i = 0 ; i <CELLWEITH;i++)
            for (int j = 0 ; j< CELLHEIGTH ; j++)
            {
                if (ground[i][j]==1)
                {

                    g.setColor(new Color(0,150,136));
                    g.fill3DRect(i*50+53,j*50+32+50,50,50,true);

                }
            }
    }
    /*
    下落方块加入障碍物中
     */
    public void add(Shape shape)
    {
        for (int x = 0 ; x< 4 ; x++)
            for (int y = 0 ; y <4 ; y++)
                if (shape.isMember(x,y,false))
                {
                    ground[x+shape.getLeft()][y+shape.getTop()] = 1;
                }
        deleteFulline();
    }
    private void deleteFulline()
    {
        for (int y = CELLHEIGTH-1; y>=0; y--)
        {
            boolean isFullFlag = true;
            for (int x = 0; x<CELLWEITH;x++)
            {
                if (ground[x][y]!=1)
                    isFullFlag=false;
            }
            if (isFullFlag)
                deleteLines(y);
        }
    }
    private void deleteLines(int LineNum)
    {
        for (int y = LineNum; y>0; y--)
            for (int x = 0 ; x<CELLWEITH ; x++)
            {
                ground[x][y] = ground[x][y-1];
            }
            for (int x = 0;x<CELLWEITH ;x++)
            {
                ground[x][0] = 0;
            }
    }
    public boolean isMoveabel(Shape shape, ShapeAction action)
    {
        int left = shape.getLeft();

        int top = shape.getTop();

        switch (action)
        {
            case LEFT:
                left--;
                break;
            case DOWN:
                top++;
                break;
            case RIGHT:
                left++;
                break;
            default:
                break;
        }
        /*
        判别该操作是否可行
         */
//        for (int x= 0; x<4; x++)
//        {
//            for (int y = 0 ; y <4 ; y++)
//            {
//                    if (shape.isMember(x,y,action == ShapeAction.ROTATE))
//                    {
//                        /*
//                        高度，宽度，障碍物验证
//                         */
//                        if ((top+y >= CELLHEIGTH)||(left +x <0)||((left+x)>CELLWEITH-1)
//                            ||ground[left+x][top+y]==1)
//                            return false;
//                    }
//            }
//        }

        if (action!=ShapeAction.ROTATE) {
            for (int x = 0; x < 4; x++)
                for (int y = 0; y < 4; y++) {
                    if (shape.isMember(x,y,action == ShapeAction.ROTATE))
                    {
                        /*
                        高度，宽度，障碍物验证
                         */
                        if ((top+y >= CELLHEIGTH)||(left +x <0)||((left+x)>CELLWEITH-1)
                                ||ground[left+x][top+y]==1)
                            return false;
                    }
                }
                return true;
        }
        else if (action==ShapeAction.ROTATE)
        {
            int leftbeck = left;
            while (leftbeck>-2&&leftbeck<4)
            {
                for (int x = 0; x < 4; x++)
                    for (int y = 0; y < 4; y++) {
                        if (shape.isMember(x,y,action == ShapeAction.ROTATE))
                        {
                        /*
                        高度，宽度，障碍物验证
                         */
                            if ((top+y >= CELLHEIGTH)||(leftbeck +x <0)||((leftbeck+x)>CELLWEITH-1)
                                    ||ground[leftbeck+x][top+y]==1)
                            {

                            }
                            else
                            {
                                shape.setLeft(leftbeck);
                                return true;
                            }
                        }
                    }
                    leftbeck++;
            }
            while (leftbeck>4&&leftbeck<10)
            {
                for (int x = 0; x < 4; x++)
                    for (int y = 0; y < 4; y++) {
                        if (shape.isMember(x,y,action == ShapeAction.ROTATE))
                        {
                        /*
                        高度，宽度，障碍物验证
                         */
                            if ((top+y >= CELLHEIGTH)||(leftbeck +x <0)||((leftbeck+x)>CELLWEITH-1)
                                    ||ground[leftbeck+x][top+y]==1)
                            {

                            }
                            else
                            {
                                shape.setLeft(leftbeck);
                                return true;
                            }
                        }
                    }
                leftbeck--;
            }
            return false;
        }
        return true;
    }

    public boolean isFull()
    {
        for (int x= 0 ; x<CELLWEITH;x++)
        {
            if (ground[x][0] == 1)
                return false;
        }
        return false;
    }
}

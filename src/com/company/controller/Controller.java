package com.company.controller;

import com.company.model.*;
import com.company.myenum.ShapeAction;
import com.company.view.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by asus on 2017/4/17.
 */
public class Controller extends KeyAdapter implements  ShapeListener{
    Ground ground;
    ShapeFactory shapeFactory;
    Shape shape ;
    Test test;
    public void setTest(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }



    public Controller(Ground ground, ShapeFactory shapeFactory, Test test) {
        this.ground = ground;
        this.shapeFactory = shapeFactory;
        this.test = test;
    }

    public static void main(String[] args) {
        Test test = new Test();
        Controller controller = new Controller( new Ground() , new ShapeFactory(), test);
        test.addKeyListener(controller);
        controller.newGame();
    }

    public void newGame()
    {
        shape = shapeFactory.getShape(this);
    }

    @Override
    public void shapeMoveDown(Shape shape) {
        test.display(this.ground,shape);
    }

    @Override
    public synchronized boolean shapeIsMoveDownable(Shape shape) {
        if (this.shape!=shape)
        {
            return false;
        }
        if (ground.isMoveabel(shape, ShapeAction.DOWN)) {
            return true;
        }
        ground.add(this.shape);
        if (!ground.isFull())
            this.shape = shapeFactory.getShape(this);
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (ground.isMoveabel(shape, ShapeAction.ROTATE))
                    shape.rotate();
                break;
            case KeyEvent.VK_DOWN:
                if (shapeIsMoveDownable(shape))
                    shape.down();
                break;
            case KeyEvent.VK_LEFT:
                if (ground.isMoveabel(shape,ShapeAction.LEFT))
                    shape.moveleft();
                break;
            case KeyEvent.VK_RIGHT:
                if (ground.isMoveabel(shape,ShapeAction.RIGHT))
                    shape.moveright();
                break;
        }
        test.display(ground,shape);
    }


}

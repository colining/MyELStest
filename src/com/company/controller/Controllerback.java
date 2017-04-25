package com.company.controller;


import com.company.model.Ground;
import com.company.model.Shape;
import com.company.model.ShapeFactory;
import com.company.myenum.ShapeAction;

import com.company.view.Testpanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by asus on 2017/4/24.
 */
public class Controllerback extends KeyAdapter implements ShapeListener{

    Ground ground;
    ShapeFactory shapeFactory;
    Shape shape ;
    Testpanel test;
    public void setTest(Testpanel test) {
        this.test = test;
    }

    public Testpanel getTest() {
        return test;
    }



    public Controllerback(Ground ground, ShapeFactory shapeFactory, Testpanel test) {
        this.ground = ground;
        this.shapeFactory = shapeFactory;
        this.test = test;
    }


    public void newShape()
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

package com.company.model;

import com.company.controller.ShapeListener;
import util.util;

/**
 * Created by asus on 2017/4/17.
 */
public class ShapeFactory {

    public ShapeFactory() {
    }

    public Shape getShape(ShapeListener shapeListener)
    {
        Shape shape = new Shape();
        int shapekind = (int)(Math.random()*10000%7);
        //shapekind = 0;
        shape.setBody(util.shape[shapekind]);
        shape.setShapekind(shapekind);
        int state = (int)(Math.random()*1000%4);
        shape.setState(state);
        shape.addListenser(shapeListener);

        return shape;
    }
}

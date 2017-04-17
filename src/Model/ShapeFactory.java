package Model;

import util.util;

import java.util.Random;

/**
 * Created by asus on 2017/4/17.
 */
public class ShapeFactory {

    public Shape getshape()
    {
        Shape shape = new Shape();
        int shapekind = (int)(Math.random()*10000%7);
        shape.setBody(util.shape[shapekind]);
        int state = (int)(Math.random()*1000%4);
        shape.setState(state);
        return shape;
    }
}

package com.company;

import com.company.controller.*;
import com.company.model.*;

import com.company.view.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asus on 2017/4/24.
 */
public class Game {
    public static void main(String[] args) {
        Ground ground = new Ground();
        ShapeFactory shapeFactory = new ShapeFactory();
        Testpanel testpanel = new Testpanel();
        Controllerback controllerback = new Controllerback(new Ground(),new ShapeFactory(),testpanel);

        Start start = new Start();
        com.company.view.Menu menu = new com.company.view.Menu(controllerback);
        JPanel panel = menu.getPanel();
        start.setLayout(new BorderLayout());
        start.add(new Label("          "),BorderLayout.WEST);
        start.add(testpanel,BorderLayout.CENTER);
        start.add(panel,BorderLayout.EAST);
        start.addKeyListener(controllerback);
        controllerback.newShape();
        start.setVisible(true);
    }

}

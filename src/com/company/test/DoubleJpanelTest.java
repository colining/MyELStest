package com.company.test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by asus on 2017/4/25.
 */
public class DoubleJpanelTest extends JPanel{
    public static void main(String[] args) {
        JFrame testframe = new JFrame();
        testframe.setSize(800,800);
        testframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testframe.setLayout(new BorderLayout());
        testframe.setVisible(true);
        JPanel jPanel = new JPanel();
        jPanel.add(new Button("Menu"));
        JPanel jPanel1 = new JPanel();
        jPanel1.add(new Button("test2"));
        testframe.add(jPanel,BorderLayout.SOUTH);
        testframe.add(jPanel1,BorderLayout.NORTH);

    }
}

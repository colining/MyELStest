package com.company.view;

import com.company.controller.Controllerback;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by asus on 2017/4/24.
 */
public class Menu implements ActionListener{

    Controllerback controllerback = null;
    private JPanel panel;
    private JButton newgameButton;
    private JButton returnButton;
    private JLabel soccer;
    private JLabel num;
    public Menu(Controllerback controllerback) {
        this.controllerback = controllerback;
        panel.addKeyListener(controllerback);
        newgameButton.addKeyListener(controllerback);
        returnButton.addKeyListener(controllerback);
        newgameButton.addActionListener(this);
    }

    public JPanel getPanel() {
        return panel;
    }
    public JButton getNewgameButton() {
        return newgameButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==newgameButton)
        {
            controllerback.newShape();
        }
    }
}

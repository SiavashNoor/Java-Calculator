package com.javaCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenubarListener implements ActionListener {

Calculator calculator;
JMenuItem helpItem;
JMenuItem aboutItem;
JMenuItem ItemModeScientific;
JMenuItem ItemModeNormal;
//pass class into constructor .see the question in stackoverflow .
MenubarListener(Calculator calculator,JMenuItem helpItem, JMenuItem aboutItem,JMenuItem ItemModeScientific,JMenuItem ItemModeNormal){
    this.calculator = calculator;
    this.helpItem = helpItem;
    this.aboutItem = aboutItem;
    this.ItemModeScientific = ItemModeScientific;
    this.ItemModeNormal = ItemModeNormal;
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == helpItem) {
             new HelpWindow();
        }
        if (e.getSource() == aboutItem) {
             new AboutFrame();
        }
        if (e.getSource() == ItemModeScientific) {
            System.out.println("scientific mode");
          calculator.changeFrame2Scientific();
        }
        if (e.getSource() == ItemModeNormal) {
            System.out.println("normal mode");
            calculator.changeFrame2Normal();
        }
    }
}


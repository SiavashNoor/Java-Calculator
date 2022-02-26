package com.javaCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//this class contains the action listener implementation for number buttons.0-9
public class NumButtListener implements ActionListener {

    JButton[] numberButtons = new JButton[10];
    JTextField textField;

    NumButtListener(JButton[] numberButtons, JTextField textField) {
        System.arraycopy(numberButtons, 0, this.numberButtons, 0, 10);
        //the above code is replaced with the blew code :
        // for (int i=0; i<10;i++){
        //     this.numberButtons[i]= numberButtons[i];
        // }
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }
    }
}

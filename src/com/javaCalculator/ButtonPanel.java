package com.javaCalculator;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    JButton[] numberButtons = new JButton[10] ;
    JButton[] functionButtons = new JButton[7];
    JButton button;



    ButtonPanel() {
       for(int i =0;i<10 ;i++ ){
           numberButtons[i] = new JButton();
           numberButtons[i].setText(String.valueOf(i));
        }

        this.setLayout(new GridLayout(4,4,10,10));
        this.setBackground(Color.darkGray);
        this.setBounds(10, 70, 390, 350);

    }
}

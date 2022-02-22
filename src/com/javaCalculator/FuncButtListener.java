package com.javaCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncButtListener implements ActionListener {
    JTextField textField;
    char operator;
    double num1;
    double temp ;
    double num2;


    JButton addButton,subButton,divideButton,multiplyButton,decButton,equButton ;

    FuncButtListener( JButton[] functionButtons, JTextField textField) {
        this.addButton = functionButtons[0];
        this.subButton = functionButtons[1];
        this.multiplyButton = functionButtons[2];
        this.equButton = functionButtons[3];
        this.divideButton = functionButtons[4];
        this.decButton = functionButtons[5];

        this.textField = textField;


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            System.out.println(num1);
            operator = '+';
        }

        if (e.getSource() == subButton) {
            if (textField.getText().isEmpty()) {
                textField.setText("-");
            } else {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
            }
            operator = '-';
        }

        if (e.getSource() == divideButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '÷';
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '×';
        }
        if (e.getSource() == decButton) {
            textField.setText(textField.getText() + ".");

        }

        if (e.getSource() == equButton) {

            num2 = Double.parseDouble(textField.getText());
            textField.setText("");
            System.out.println(num2);

            switch (operator) {
                case '+' -> temp = num1 + num2;
                case '-' -> temp = num1 - num2;
                case '×' -> temp = num1 * num2;
                case '÷' -> temp = num1 / num2;
                case '^' -> temp = Math.pow(num1, num2);
                case 'l' -> temp = Math.log(num1)/Math.log(num2);



            }
            System.out.println(temp);
            textField.setText(String.valueOf(temp));

        }

    }
}

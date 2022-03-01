package com.javaCalculator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ButtonsKeyListener implements KeyListener {
    JTextField textField;
    char operator;
    double num1, num2;
    ButtonsKeyListener(JTextField textField) {
        this.textField = textField;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 96 -> textField.setText(textField.getText() + 0);
            case 97 -> textField.setText(textField.getText() + 1);
            case 98 -> textField.setText(textField.getText() + 2);
            case 99 -> textField.setText(textField.getText() + 3);
            case 100 -> textField.setText(textField.getText() + 4);
            case 101 -> textField.setText(textField.getText() + 5);
            case 102 -> textField.setText(textField.getText() + 6);
            case 103 -> textField.setText(textField.getText() + 7);
            case 104 -> textField.setText(textField.getText() + 8);
            case 105 -> textField.setText(textField.getText() + 9);
            case 10 -> {
                num2 = Double.parseDouble(textField.getText());
                textField.setText("");
                System.out.println(num2);
             double temp = ArithmeticOperation.mainOperation(num1,num2,operator);
                System.out.println(temp);
                textField.setText(String.valueOf(temp));
            }
            case 110 -> textField.setText(textField.getText() + ".");
            case 107 -> {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                System.out.println(num1);
                operator = '+';
            }
            case 109 -> {
                if (textField.getText().isEmpty()) {
                    textField.setText("-");
                } else {
                    num1 = Double.parseDouble(textField.getText());
                    textField.setText("");
                }
                operator = '-';
            }
            case 106 -> {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '×';
            }
            case 111 -> {
                num1 = Double.parseDouble(textField.getText());
                textField.setText("");
                operator = '÷';
            }
            case 8 -> {
                if (textField.getText().length() > 1) {
                    textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
                } else {
                    textField.setText("");
                }
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}

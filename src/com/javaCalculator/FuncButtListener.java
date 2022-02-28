package com.javaCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FuncButtListener implements ActionListener {
    JTextField textField;
    char operator;
    double num1;
    double temp;
    double num2;

    JButton addButton, subButton, divideButton, multiplyButton, decButton, equButton, numberPowerOfNumber, factorialNumber,
            numberPowerOfTwo, logarithmBaseNumber, naturalLogarithm, neperNumber, PiNumber, percentOfnumber, squareRoot, multiplicativeInverse;

    FuncButtListener(JButton[] functionButtons, JButton[] ScientificButton, JTextField textField) {
        this.addButton = functionButtons[0];
        this.subButton = functionButtons[1];
        this.multiplyButton = functionButtons[2];
        this.equButton = functionButtons[3];
        this.divideButton = functionButtons[4];
        this.decButton = functionButtons[5];

        this.textField = textField;

        this.multiplicativeInverse = ScientificButton[0];
        this.squareRoot = ScientificButton[1];
        this.PiNumber = ScientificButton[2];
        this.numberPowerOfTwo = ScientificButton[3];
        this.numberPowerOfNumber = ScientificButton[4];
        this.percentOfnumber = ScientificButton[5];
        this.logarithmBaseNumber = ScientificButton[6];
        this.naturalLogarithm = ScientificButton[7];
        this.neperNumber = ScientificButton[8];
        this.factorialNumber = ScientificButton[9];
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
        //scientific buttons  listeners
        if (e.getSource() == numberPowerOfNumber) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '^';
        }
        if (e.getSource() == numberPowerOfTwo) {

            num1 = Double.parseDouble(textField.getText());
            temp = num1 * num1;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == multiplicativeInverse) {
            num1 = Double.parseDouble(textField.getText());
            temp = 1 / num1;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == squareRoot) {
            num1 = Double.parseDouble(textField.getText());
            temp = Math.sqrt(num1);
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == PiNumber) {
            textField.setText(String.valueOf(Math.PI));
        }
        if (e.getSource() == percentOfnumber) {
            num1 = Double.parseDouble(textField.getText());
            temp = num1 / 100;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == naturalLogarithm) {
            num1 = Double.parseDouble(textField.getText());
            temp = Math.log(num1);
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == logarithmBaseNumber) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = 'l';
        }
        if (e.getSource() == neperNumber) {
            temp = Math.E;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == factorialNumber) {
            num1 = Integer.parseInt(textField.getText());
            double fact = 1;
            for (int i = (int) num1; i > 0; i--) {
                fact = fact * i;
            }
            textField.setText(String.valueOf(fact));
        }
        //

        if (e.getSource() == equButton) {

            num2 = Double.parseDouble(textField.getText());
            textField.setText("");
            System.out.println(num2);

           temp=  ArithmeticOperation.mainOperation(num1,num2,operator);
            System.out.println(temp);
            textField.setText(String.valueOf(temp));
        }
    }
}

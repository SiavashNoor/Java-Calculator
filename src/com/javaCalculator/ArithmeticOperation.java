package com.javaCalculator;

public class ArithmeticOperation {

    public static double mainOperation(double num1, double num2, char operator) {
        double temp = 0;
        switch (operator) {
            case '+' -> temp =  num1 + num2;
            case '-' -> temp =  num1 - num2;
            case '×' -> temp = num1 * num2;
            case '÷' -> temp = num1 / num2;
            case '^' -> temp = Math.pow(num1, num2);
            case 'l' -> temp = Math.log(num1) / Math.log(num2);
        }
        return temp;
    }
}



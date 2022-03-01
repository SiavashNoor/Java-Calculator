package com.javaCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryButtListener implements ActionListener {
    JTextField textField;
    JButton deleteButton, clearButton, memorySave, memoryClear, memoryLoad;
    double memory;

    MemoryButtListener(JButton[] memoryFunctionButtons, JTextField textField) {
        this.deleteButton = memoryFunctionButtons[0];
        this.clearButton = memoryFunctionButtons[1];
        this.memorySave = memoryFunctionButtons[2];
        this.memoryClear = memoryFunctionButtons[3];
        this.memoryLoad = memoryFunctionButtons[4];
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            textField.setText("");
        }
        if (e.getSource() == memoryClear) {
            memory = 0;
        }
        if (e.getSource() == memorySave) {
            memory = Double.parseDouble(textField.getText());
            textField.setText("");
        }

        if (e.getSource() == memoryLoad) {
            textField.setText(String.valueOf(memory));
        }
        if (e.getSource() == deleteButton) {
            if (textField.getText().length() > 1) {
                textField.setText(textField.getText().substring(0, textField.getText().length() - 1));
            } else {
                textField.setText("");
            }
        }
    }
}

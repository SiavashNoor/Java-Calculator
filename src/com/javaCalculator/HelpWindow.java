package com.javaCalculator;

import javax.swing.*;
import java.awt.*;

public class HelpWindow {
    JFrame helpFrame;
    JTextArea helpText;
    JPanel helpPanel;

    HelpWindow() {

        helpPanel = new JPanel();
        helpPanel.setBounds(10, 10, 420, 400);
        helpPanel.setBackground(new Color(50, 50, 50));
        //this is a text block of text for help window .
        String text = """
                 ML  = Memory Load\s
                 MS = Memory Save\s
                 MC = Memory Clear C = Clear\s
                 AC = All Clear""";
        helpText = new JTextArea(text);
        helpText.setBackground(new Color(50, 50, 50));
        helpText.setLineWrap(true);
        helpText.setWrapStyleWord(true);
        helpText.setFont(new Font("Helvetica", Font.PLAIN, 20));
        helpText.setBounds(0, 0, 350, 350);
        helpText.setForeground(Color.white);
        helpText.setEditable(false);

        helpFrame = new JFrame("Help");
        helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        helpFrame.setLayout(null);
        helpFrame.setSize(new Dimension(450, 450));
        helpFrame.getContentPane().setBackground(new Color(50, 50, 50));
        helpFrame.setLocation(300, 300);
        helpFrame.setResizable(false);
        helpPanel.add(helpText);
        helpFrame.add(helpPanel);

        helpFrame.setVisible(true);
    }
}

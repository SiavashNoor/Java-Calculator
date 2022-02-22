package com.javaCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements KeyListener, ActionListener {

    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[6];
    JButton[] memoryFunctionButtons = new JButton[5];
    JButton addButton;
    JButton divideButton;
    JButton subButton;
    JButton decButton;
    JButton multiplyButton;
    JButton deleteButton;
    JButton equButton;
    JButton clearButton;
    JButton memorySave;
    JButton memoryClear;
    JButton memoryLoad;

    JButton[] ScientificButton = new JButton[10];
    JButton multiplicativeInverse;
    JButton squareRoot;
    JButton PiNumber;
    JButton numberPowerOfTwo;
    JButton numberPowerOfNumber;
    JButton percentOfnumber;
    JButton logarithmBaseNumber;
    JButton naturalLogarithm;
    JButton neperNumber;
    JButton factorialNumber;


    JFrame frame;
    JPanel memoryFunctionPanel;
    JPanel panel;
    JPanel scientificPanel;
    JTextField textField;


    JMenuBar menuBar;
    JMenu helpMenu;
    JMenu modeMenu;
    JMenuItem helpItem;
    JMenuItem ItemModeNormal;
    JMenuItem ItemModeScientific;
    JMenuItem aboutItem;

    ActionListener actionListener;



    Font font = new Font("helvetica", Font.BOLD, 30);

    double num1;
    double num2;
    double temp;
    double memory;
    char operator;
    ImageIcon icon = new ImageIcon("D:\\java_codes\\media\\icon.png");
    Calculator() {



        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(font);
            numberButtons[i].setBackground(new Color(130, 130, 130));
            numberButtons[i].setFocusable(false);
        }


        for (int i = 0; i < 6; i++) {
            functionButtons[i] = new JButton();
            functionButtons[i].setFont(font);
            functionButtons[i].setBackground(new Color(227, 84, 23));

            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 5; i++) {
            memoryFunctionButtons[i] = new JButton();
            memoryFunctionButtons[i].setFont(new Font("helvetica", Font.BOLD, 20));
            memoryFunctionButtons[i].setBackground(new Color(222, 37, 4));
            memoryFunctionButtons[i].setFocusable(false);
            memoryFunctionButtons[i].setBorder(null);
        }

        addButton = functionButtons[0];
        subButton = functionButtons[1];
        multiplyButton = functionButtons[2];
        equButton = functionButtons[3];
        divideButton = functionButtons[4];
        decButton = functionButtons[5];

        deleteButton = memoryFunctionButtons[0];
        clearButton = memoryFunctionButtons[1];
        memorySave = memoryFunctionButtons[2];
        memoryClear = memoryFunctionButtons[3];
        memoryLoad = memoryFunctionButtons[4];

        addButton.setText("+");
        subButton.setText("-");
        multiplyButton.setText("×");
        equButton.setText("=");
        divideButton.setText("÷");
        decButton.setText(".");
        deleteButton.setText("C");
        clearButton.setText("AC");
        memorySave.setText("MS");
        memoryClear.setText("MC");
        memoryLoad.setText("ML");

        menuBar = new JMenuBar();
        modeMenu = new JMenu("Mode");
        helpMenu = new JMenu("Help");
        helpItem = new JMenuItem("Help          ");
        aboutItem = new JMenuItem("About ");
        ItemModeNormal = new JMenuItem("Normal          ");
        ItemModeScientific = new JMenuItem("Scientific");

        ItemModeScientific.setMnemonic(KeyEvent.VK_S);
        ItemModeNormal.setMnemonic(KeyEvent.VK_N);

        helpItem.addActionListener(this);
        aboutItem.addActionListener(this);
        ItemModeNormal.addActionListener(this);
        ItemModeScientific.addActionListener(this);

        modeMenu.add(ItemModeNormal);
        modeMenu.add(ItemModeScientific);
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        menuBar.add(modeMenu);
        menuBar.add(helpMenu);


        textField = new JTextField();
        textField.setEditable(false);
        textField.setFont(new Font("helvetica", Font.BOLD, 40));
        textField.setForeground(Color.white);
        textField.setBounds(10, 10, 390, 60);
        textField.setBackground(Color.darkGray);
        textField.setBorder(null);

        memoryFunctionPanel = new JPanel();
        memoryFunctionPanel.setLayout(new GridLayout(1, 5, 10, 10));
        memoryFunctionPanel.setBounds(10, 80, 390, 55);
        memoryFunctionPanel.setBackground(new Color(100, 100, 100));

        memoryFunctionPanel.add(memoryClear);
        memoryFunctionPanel.add(memorySave);
        memoryFunctionPanel.add(memoryLoad);
        memoryFunctionPanel.add(deleteButton);
        memoryFunctionPanel.add(clearButton);

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(10, 150, 390, 390);
        panel.setBackground(new Color(100, 100, 100));

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(divideButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(multiplyButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);


        //////scientific panel components
        for (int i = 0; i < ScientificButton.length; i++) {
            ScientificButton[i] = new JButton();
            ScientificButton[i].setFocusable(false);
            ScientificButton[i].setFont(new Font("Tahoma", Font.PLAIN, 18));
            ScientificButton[i].setForeground(Color.black);
            ScientificButton[i].setBackground(Color.orange);
            ScientificButton[i].setBorder(null);
            ScientificButton[i].addActionListener(this);
        }

        multiplicativeInverse = ScientificButton[0];
        squareRoot = ScientificButton[1];
        PiNumber = ScientificButton[2];
        numberPowerOfTwo = ScientificButton[3];
        numberPowerOfNumber = ScientificButton[4];
        percentOfnumber = ScientificButton[5];
        logarithmBaseNumber = ScientificButton[6];
        naturalLogarithm = ScientificButton[7];
        neperNumber = ScientificButton[8];
        factorialNumber = ScientificButton[9];


        multiplicativeInverse.setText("1/x");

        //not all fonts support the unicode  the below commented code checks the validated fonts for specified unicode.
        //this code is not efficient but it works .
        /*
          String s = "\u03C0";
        Font[] fonts = GraphicsEnvironment.
                getLocalGraphicsEnvironment().getAllFonts();
        System.out.println("Total fonts: \t" + fonts.length);
        int count = 0;
        for (Font font : fonts) {
            if (font.canDisplayUpTo(s) < 0) {
                count++;
                System.out.println(font.getName());
            }
        }
        System.out.println("Compatible fonts: \t" + count);
        */
        squareRoot.setText("\u221A" + "x"); //radical unicode
        PiNumber.setText("\u03C0");  //pi number unicode
        numberPowerOfTwo.setText("<html>x <sup>2</sup></html>");
        numberPowerOfNumber.setText("<html> x <sup>n</sup></html>");
        percentOfnumber.setText("%");
        logarithmBaseNumber.setText("<html> Log<sub>y</sub>x</html>");
        naturalLogarithm.setText("ln(X)");
        neperNumber.setText("e");
        factorialNumber.setText("x!");

        scientificPanel = new JPanel();
        scientificPanel.setBounds(10, 150, 170, 390);
        scientificPanel.setBackground(Color.darkGray);
        scientificPanel.setLayout(new GridLayout(5, 2, 4, 4));

        scientificPanel.add(numberPowerOfNumber);
        scientificPanel.add(numberPowerOfTwo);
        scientificPanel.add(multiplicativeInverse);
        scientificPanel.add(squareRoot);
        scientificPanel.add(PiNumber);
        scientificPanel.add(percentOfnumber);
        scientificPanel.add(naturalLogarithm);
        scientificPanel.add(logarithmBaseNumber);
        scientificPanel.add(neperNumber);
        scientificPanel.add(factorialNumber);
        /////////


        panel.add(subButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(addButton);


        actionListener = new NumButtListener(numberButtons,  textField);
        for (int i = 0; i < 10; i++) {
            numberButtons[i].addActionListener(actionListener);
        }

        actionListener= new FuncButtListener(functionButtons,textField);
        for(int i=0;i<6;i++){
            functionButtons[i].addActionListener(actionListener);
        }
        actionListener = new MemoryButtListener(memoryFunctionButtons,textField);
        for(int i = 0;i<5;i++){
            memoryFunctionButtons[i].addActionListener(actionListener);
        }






        frame = new JFrame();
        frame.setTitle("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(this);
        frame.setIconImage(icon.getImage());
        frame.setLayout(null);
        frame.setSize(420, 600);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(80, 80, 80));
        frame.setJMenuBar(menuBar);

        frame.setFocusable(true);

        frame.add(textField);
        frame.add(memoryFunctionPanel);
        frame.add(panel);



        frame.setVisible(true);

    }
/////////////////////////////////////////////////////////
    //@Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
        System.out.println(frame.isFocused());
/*
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }


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


        if (e.getSource() == clearButton) {
            textField.setText("");

        }
        if (e.getSource() == memoryClear) {
            memory = 0;
        }
        if (e.getSource() == memorySave) {
            memory = Double.parseDouble(textField.getText());
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

 */

        //scientific buttons  listeners
        if (e.getSource() == numberPowerOfNumber) {
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = '^';
        }
        if (e.getSource()== numberPowerOfTwo){

            num1 = Double.parseDouble(textField.getText());
            temp = num1*num1;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource()== multiplicativeInverse){
            num1 = Double.parseDouble(textField.getText());
            temp = 1/num1;
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource()==squareRoot){
            num1 = Double.parseDouble(textField.getText());
            temp = Math.sqrt(num1);
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource()== PiNumber){
            textField.setText(String.valueOf(Math.PI));
        }
        if(e.getSource()== percentOfnumber){
            num1 = Double.parseDouble(textField.getText());
            temp = num1/100;
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource()== naturalLogarithm){
            num1 = Double.parseDouble(textField.getText());
            temp = Math.log(num1);
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource()== logarithmBaseNumber){
            num1 = Double.parseDouble(textField.getText());
            textField.setText("");
            operator = 'l';
        }
        if (e.getSource()==neperNumber){
            temp = Math.E;
            textField.setText(String.valueOf(temp));
        }
        if (e.getSource() == factorialNumber) {
            num1 = Integer.parseInt(textField.getText());
                    double fact =1;
            for(int i =(int)num1 ;i> 0;i--){
                fact = fact*i;
            }
            textField.setText(String.valueOf(fact));
        }
        //
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

        if (e.getSource() == helpItem) {
            HelpWindow helpWindow = new HelpWindow();


        }
        if (e.getSource() == aboutItem) {
            AboutFrame frame = new AboutFrame();
        }
        if (e.getSource() == ItemModeScientific) {

            frame.setSize(600, 600);
            frame.setResizable(false);
            memoryFunctionPanel.setBounds(10, 80, 570, 55);
            textField.setBounds(10, 10, 570, 60);
            panel.setBounds(190, 150, 390, 390);
            frame.add(scientificPanel);

        }
        if (e.getSource() == ItemModeNormal) {
            memoryFunctionPanel.setBounds(10, 80, 390, 55);
            textField.setBounds(10, 10, 390, 60);
            panel.setBounds(10, 150, 390, 390);
            frame.setSize(420, 600);
            frame.remove(scientificPanel);
        }
    }

    //add key listener to the keyboard ;
    @Override
    public void keyTyped(KeyEvent g) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(frame.isFocused());
        System.out.println(e.getKeyCode());
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

                switch (operator) {
                    case '+' -> temp = num1 + num2;
                    case '-' -> temp = num1 - num2;
                    case '×' -> temp = num1 * num2;
                    case '÷' -> temp = num1 / num2;
                }
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

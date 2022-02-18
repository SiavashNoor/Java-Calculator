package com.javaCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class AboutFrame  {
    JFrame aboutFrame;
    JLabel label1;
    JLabel hyperLink1;
    JLabel hyperLink2;


    AboutFrame() {
        label1 = new JLabel();
        label1.setText("Find me in these places:");


        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setFont(new Font("Helvetica", Font.PLAIN, 15));
        label1.setForeground(Color.darkGray);

        hyperLink1 = new JLabel();
        hyperLink1.setBackground(Color.green);

        String textHyp1 = "StackOverflow";
        hyperLink1.setText(textHyp1);
        hyperLink1.setHorizontalAlignment(JLabel.CENTER);
        hyperLink1.setFont(new Font("Helvetica", Font.PLAIN, 15));
        hyperLink1.setForeground(Color.blue.darker());
        hyperLink1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    //opens the default browser and passes the uri to that .
                    Desktop.getDesktop().browse(new URI("https://stackoverflow.com/users/13074882/siavosh-noor"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseEntered (MouseEvent e){
                hyperLink1.setText("<html><a href=''>"+textHyp1+"</a></html>");
                hyperLink1.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e ){
                hyperLink1.setText(textHyp1);
                hyperLink1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        hyperLink2 = new JLabel();
        String textHyp2 = "Github ";
        hyperLink2.setText(textHyp2);
        hyperLink2.setHorizontalAlignment(JLabel.CENTER);
        hyperLink2.setFont(new Font("Helvetica", Font.PLAIN, 15));
        hyperLink2.setForeground(Color.BLUE.darker());
        hyperLink2.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e){
                try {
                    //opens the default browser and passes the uri to that .
                    Desktop.getDesktop().browse(new URI("https://github.com/SiavashNoor/Java-Calculator"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            public void mouseEntered (MouseEvent e){
                // a trick : we can pass this HTML snippet to  the string and make it underlined .
                hyperLink2.setText("<html><a href=''>"+textHyp2+"</a></html>");
                //set cursor to hand cursor when the cursor goes on the label.
                hyperLink2.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
             @Override
            public void mouseExited(MouseEvent e ){
                hyperLink2.setText(textHyp2);
                hyperLink2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
             }
        });

        aboutFrame = new JFrame("Help");
        aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aboutFrame.setLayout(new GridLayout(3,1));
        aboutFrame.setSize(new Dimension(400, 150));
        aboutFrame.getContentPane().setBackground(Color.white);
        aboutFrame.setLocation(400, 200);
        aboutFrame.setResizable(false);
        aboutFrame.add(label1);
        aboutFrame.add(hyperLink1);
        aboutFrame.add(hyperLink2);

        aboutFrame.setVisible(true);

    }
}

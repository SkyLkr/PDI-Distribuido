package com.pdidist.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel mainPanel;
    private JButton button1;
    private JButton button2;
    private JRadioButton filtro1RadioButton;
    private JRadioButton filtro2RadioButton;
    private JRadioButton filtro3RadioButton;
    private JTextField textField1;
    private JTextField textField2;

    public App() {

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

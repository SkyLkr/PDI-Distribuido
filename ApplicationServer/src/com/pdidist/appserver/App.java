package com.pdidist.appserver;

import javax.swing.*;

public class App {
    private JTextArea textArea1;
    private JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

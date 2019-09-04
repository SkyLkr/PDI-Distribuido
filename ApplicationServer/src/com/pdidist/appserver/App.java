package com.pdidist.appserver;

import inter.DataInterface;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class App {
    private JTextArea textArea1;
    private JPanel mainPanel;

    public static void main(String[] args) {

        try {
            DataInterface data = (DataInterface) Naming.lookup("rmi://localhost/DataServer");

            System.out.println(data.teste("Testando conexão"));

        } catch (NotBoundException | MalformedURLException | RemoteException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

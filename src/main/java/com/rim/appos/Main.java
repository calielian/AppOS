package com.rim.appos;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends JFrame {
    public static void main(String[] args) {

        // setup inicial
        JFrame frame = new JFrame("AppOS Desktop");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1100, 700));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new BotoesMenuIniciar();

        // criação da thread do desktop
        Desktop desktop = new Desktop(frame);
        Thread threadDesktop = new Thread(desktop);

        // inicializando a thread
        threadDesktop.setDaemon(true);
        threadDesktop.start();
    }
}
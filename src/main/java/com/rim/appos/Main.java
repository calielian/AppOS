package com.rim.appos;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends JFrame {

    private static JFrame frame;
    private static Thread threadDesktop;
    public static void main(String[] args) {

        // setup inicial
        frame = new JFrame("AppOS Desktop");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1100, 700));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new BotoesMenuIniciar();

        iniciarDesktop();

        BotoesMenuIniciar.botaoReinciar.addActionListener(e -> reiniciarDesktop());
    }

    private static void iniciarDesktop() {
        Desktop desktop = new Desktop(frame);
        threadDesktop = new Thread(desktop);
        threadDesktop.setDaemon(true);
        threadDesktop.start();
    }

    private static void reiniciarDesktop() {
        frame.getContentPane().removeAll();

        Desktop.limpar();

        if (threadDesktop != null && threadDesktop.isAlive()) {
            threadDesktop.interrupt();
        }

        System.gc();

        iniciarDesktop();
        frame.revalidate();
        frame.repaint();
    }
}
package com.rim.appos.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.rim.appos.Desktop;

public class UI {
    
    public static JPanel janelaApp;

    public static void iniciar() {

        JPanel barraJanela = new JPanel();
        barraJanela.setBackground(Color.RED);

        JButton botaoFecharJanela = new JButton();
        JButton botaoMinimizarJanela = new JButton();

        botaoFecharJanela.setBackground(Color.MAGENTA);
        botaoFecharJanela.setPreferredSize(new Dimension(20, 20));

        janelaApp.setBounds(0, 0, 500, 500);
        janelaApp.setBackground(Color.CYAN);
        janelaApp.setLayout(new BorderLayout());

        janelaApp.add(barraJanela, BorderLayout.NORTH);

        janelaApp.setVisible(true);

        Desktop.menuIniciar.setVisible(false);

        
    }
}

package com.rim.appos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Desktop extends JFrame {
    Desktop(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1100, 700));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("AppOS Desktop");

        JPanel barraTarefas = new JPanel();
        barraTarefas.setBackground(Color.GREEN);
        barraTarefas.setPreferredSize(new Dimension(0, 40));
        barraTarefas.setLayout(new BorderLayout());

        JPanel desktop = new JPanel();
        desktop.setBackground(Color.RED);

        JButton menuIniciar = new JButton();
        menuIniciar.setBackground(Color.BLACK);
        menuIniciar.setBorder(null);
        menuIniciar.setFocusable(false);
        menuIniciar.setPreferredSize(new Dimension(50,40));

        JPanel processos = new JPanel();
        processos.setBackground(Color.ORANGE);

        JPanel extras = new JPanel();
        JLabel relogio = new JLabel();

        LocalTime hora = LocalTime.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");

        hora.format(formatador);

        barraTarefas.add(menuIniciar, BorderLayout.WEST);
        barraTarefas.add(processos, BorderLayout.CENTER);

        this.add(barraTarefas, BorderLayout.SOUTH);
        this.add(desktop, BorderLayout.CENTER);
        this.setVisible(true);
    }
}

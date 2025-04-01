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
import javax.swing.border.Border;

public class Desktop extends JFrame {

    public static JPanel desktop = new JPanel(); // possui 1090 de largura por 630 de altura

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

        desktop.setLayout(null);

        JPanel menuIniciar = new JPanel();
        menuIniciar.setBackground(Color.RED);
        menuIniciar.setBorder(null);
        menuIniciar.setBounds(0, /* 331 */ 500, 400, 300); // colocar o y sempre como altura desktop - altura menuIniciar + 1
        menuIniciar.setVisible(true);

        BotaoIniciar.menuIniciar = menuIniciar;

        JPanel processos = new JPanel();
        processos.setBackground(Color.ORANGE);

        JPanel extras = new JPanel();
        JLabel relogio = new JLabel();

        LocalTime hora = LocalTime.now();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm:ss");

        hora.format(formatador);

        desktop.add(menuIniciar);

        barraTarefas.add(processos, BorderLayout.CENTER);
        barraTarefas.add(BotaoIniciar.pegarBotaoIniciar(), BorderLayout.WEST);

        this.add(barraTarefas, BorderLayout.SOUTH);
        this.add(desktop, BorderLayout.CENTER);
        this.setVisible(true);

        System.out.println(desktop.getSize());
    }
}

package com.rim.appos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Desktop extends JFrame {

    public static JPanel desktop = new JPanel(); // possui 1090 de largura por 630 de altura

    Desktop(){
        // setup inicial
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(new Dimension(1100, 700));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("AppOS Desktop");

        // declaração de variáveis
        JPanel barraTarefas = new JPanel();
        JPanel menuIniciar = new JPanel();
        JPanel processos = new JPanel();
        JPanel extras = new JPanel();

        JButton botaoDesligar = new JButton("Desligar");

        // declarações das variáveis da thread do relógio da barra de tarefas
        JLabel horario = new JLabel();
        horario.setForeground(Color.WHITE);

        Relogio relogio = new Relogio();
        relogio.horario = horario;

        Thread threadRelogio = new Thread(relogio); // inicia uma thread (processo separado) para o relógio
        threadRelogio.setDaemon(true); // esse comando faz a thread encerrar quando essa thread (o processo do desktop) ser encerrado
        threadRelogio.start();

        // fim das declarações, início das configurações

        // configurando os JPanels

        desktop.setLayout(null);
        desktop.setBackground(Color.GRAY);

        barraTarefas.setBackground(Color.GREEN);
        barraTarefas.setPreferredSize(new Dimension(0, 40));
        barraTarefas.setLayout(new BorderLayout());

        menuIniciar.setBackground(Color.LIGHT_GRAY);
        menuIniciar.setBorder(null);
        menuIniciar.setBounds(0, 331, 400, 300); // colocar o y sempre como altura desktop - altura menuIniciar + 1
        menuIniciar.setVisible(false);

        processos.setBackground(new Color(0x2A2E32));

        extras.setBackground(Color.DARK_GRAY);
        extras.setPreferredSize(new Dimension(100, barraTarefas.getHeight()));

        botaoDesligar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Desktop.desligar();
            }
        });

        // fim das configurações, início dos comandos de adicionar
        desktop.add(menuIniciar);

        extras.add(horario);

        barraTarefas.add(processos, BorderLayout.CENTER);
        barraTarefas.add(BotaoIniciar.pegarBotaoIniciar(), BorderLayout.WEST);
        barraTarefas.add(extras, BorderLayout.EAST);

        BotaoIniciar.menuIniciar = menuIniciar;

        menuIniciar.add(botaoDesligar);

        this.add(barraTarefas, BorderLayout.SOUTH);
        this.add(desktop, BorderLayout.CENTER);
        this.setVisible(true);

        // fim das adições, abaixo é após a desktop iniciar

        System.out.println(desktop.getSize());
    }

    public static void desligar(){
        System.exit(0);
    }
}

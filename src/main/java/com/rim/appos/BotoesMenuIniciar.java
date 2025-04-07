package com.rim.appos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotoesMenuIniciar {

    public static JButton botaoDesligar = new JButton();
    private ImageIcon iconeBotaoDesligar = new ImageIcon(BotaoIniciar.class.getResource("/assets/botaoDesligar.png"));

    public static JButton botaoReinciar = new JButton();
    private ImageIcon iconeBotaoReiniciar = new ImageIcon(BotaoIniciar.class.getResource("/assets/botaoReiniciar.png"));

    private JButton[] botoes = {botaoDesligar, botaoReinciar};

    BotoesMenuIniciar() {
        for (JButton botao : botoes) {
            botao.setPreferredSize(new Dimension(50, 40));
            botao.setBackground(Color.DARK_GRAY);
            botao.setBorder(null);
            botao.setFocusable(false);
        }

        botaoDesligar.setIcon(iconeBotaoDesligar);
        botaoReinciar.setIcon(iconeBotaoReiniciar);

        botaoDesligar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });
    }
}

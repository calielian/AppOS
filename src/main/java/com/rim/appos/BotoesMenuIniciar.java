package com.rim.appos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotoesMenuIniciar {

    private static JButton botaoDesligar = new JButton();
    private static ImageIcon iconeBotaoDesligar = new ImageIcon(BotaoIniciar.class.getResource("/assets/botaoDesligar.png"));

    private static JButton botaoReinciar = new JButton();
    private static ImageIcon iconeBotaoReiniciar = new ImageIcon(BotaoIniciar.class.getResource("/assets/botaoReiniciar.png"));

    public static JButton pegarBotaoDesligar() {

        botaoDesligar.setPreferredSize(new Dimension(50, 40));
        botaoDesligar.setBackground(Color.DARK_GRAY);
        botaoDesligar.setBorder(null);
        botaoDesligar.setFocusable(false);
        botaoDesligar.setIcon(iconeBotaoDesligar);

        botaoDesligar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        return botaoDesligar;
    }

    public static JButton pegarBotaoReiniciar(){

        botaoReinciar.setPreferredSize(new Dimension(50, 40));
        botaoReinciar.setBackground(Color.DARK_GRAY);
        botaoReinciar.setBorder(null);
        botaoReinciar.setFocusable(false);
        botaoReinciar.setIcon(iconeBotaoReiniciar);

        botaoReinciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Reiniciar");
            }
        });

        return botaoReinciar;
    }
}

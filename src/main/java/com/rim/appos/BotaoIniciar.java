package com.rim.appos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BotaoIniciar extends JButton {

    public static JPanel menuIniciar;

    public static JButton pegarBotaoIniciar() {
        JButton botao = new JButton();

        botao.setBackground(Color.BLACK);
        botao.setBorder(null);
        botao.setFocusable(false);
        botao.setPreferredSize(new Dimension(50, 40));

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                menuIniciar.setVisible((menuIniciar.isVisible()) ? false : true);
            }
        });

        return botao;
    }
}

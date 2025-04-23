package com.rim.appos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.rim.appos.editor.UI;

public class BotoesMenuIniciar {

    public static JButton botaoDesligar = new JButton();
    private ImageIcon iconeBotaoDesligar = new ImageIcon(BotaoIniciar.class.getResource("/assets/botaoDesligar.png"));

    public static JButton botaoReinciar = new JButton();
    private ImageIcon iconeBotaoReiniciar = new ImageIcon(BotaoIniciar.class.getResource("/assets/botaoReiniciar.png"));

    public static JButton botaoEditorDeTexto = new JButton();

    private JButton[] botoes = {botaoDesligar, botaoReinciar, botaoEditorDeTexto};

    BotoesMenuIniciar() {
        for (JButton botao : botoes) {
            botao.setPreferredSize(new Dimension(50, 40));
            botao.setBackground(Color.DARK_GRAY);
            botao.setBorder(null);
            botao.setFocusable(false);
        }

        botaoDesligar.setIcon(iconeBotaoDesligar);
        botaoReinciar.setIcon(iconeBotaoReiniciar);
        botaoEditorDeTexto.setIcon(iconeBotaoDesligar);

        botaoDesligar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        botaoEditorDeTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.iniciar();
            }
        });
    }
}

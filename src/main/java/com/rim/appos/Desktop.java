package com.rim.appos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.rim.appos.editor.UI;

public class Desktop extends JFrame implements Runnable {

    public JFrame frame;

    private static JPanel barraTarefas = new JPanel();
    public static JPanel menuIniciar = new JPanel();
    private static JPanel desktop = new JPanel();
    private static JPanel processos = new JPanel();
    private static JPanel extras = new JPanel();

    private static JPanel botoesMenuIniciar = new JPanel();
    private static JPanel appsMenuIniciar = new JPanel();
    private static JLabel wallpaper = new JLabel(new ImageIcon(Desktop.class.getResource("/assets/wallpaper.png")));

    private static JPanel janelaApp = new JPanel();

    private static JLabel horario = new JLabel();

    private static JComponent[] listaComponentes = {barraTarefas, menuIniciar, desktop, processos, extras, botoesMenuIniciar, appsMenuIniciar, wallpaper, janelaApp, horario};

    private static Relogio relogio;
    private static Thread threadRelogio;

    Desktop(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void run() {
        // declarações das variáveis da thread do relógio da barra de tarefas
        
        horario.setForeground(Color.WHITE);

        relogio = new Relogio();
        relogio.horario = horario;

        threadRelogio = new Thread(relogio); // inicia uma thread (processo separado) para o relógio
        threadRelogio.setDaemon(true); // esse comando faz a thread encerrar quando essa thread (o processo do desktop) ser encerrado
        threadRelogio.start();

        // fim das declarações, início das configurações

        desktop.setLayout(null);

        barraTarefas.setBackground(Color.GREEN);
        barraTarefas.setPreferredSize(new Dimension(0, 40));
        barraTarefas.setLayout(new BorderLayout());

        menuIniciar.setBackground(Color.DARK_GRAY);
        menuIniciar.setLayout(new BorderLayout());
        menuIniciar.setBorder(null);
        menuIniciar.setBounds(0, 331, 400, 300); // colocar o y sempre como altura desktop - altura menuIniciar + 1
        menuIniciar.setVisible(false);

        botoesMenuIniciar.setLayout(new FlowLayout(FlowLayout.RIGHT));
        botoesMenuIniciar.setPreferredSize(new Dimension(0, 50));

        processos.setBackground(new Color(0x2A2E32));

        extras.setBackground(Color.DARK_GRAY);
        extras.setPreferredSize(new Dimension(100, barraTarefas.getHeight()));

        botoesMenuIniciar.setBackground(Color.GRAY);

        appsMenuIniciar.setBackground(null);

        wallpaper.setBounds(0, 0, 1100, 700);
        wallpaper.setFocusable(false);

        // fim das configurações, início dos comandos de adicionar
        desktop.add(menuIniciar);
        desktop.add(wallpaper);
        desktop.add(janelaApp);

        extras.add(horario);

        barraTarefas.add(processos, BorderLayout.CENTER);
        barraTarefas.add(BotaoIniciar.pegarBotaoIniciar(), BorderLayout.WEST);
        barraTarefas.add(extras, BorderLayout.EAST);

        BotaoIniciar.menuIniciar = menuIniciar;

        UI.janelaApp = janelaApp;

        appsMenuIniciar.add(BotoesMenuIniciar.botaoEditorDeTexto);

        botoesMenuIniciar.add(BotoesMenuIniciar.botaoDesligar);
        botoesMenuIniciar.add(BotoesMenuIniciar.botaoReinciar);

        menuIniciar.add(botoesMenuIniciar, BorderLayout.SOUTH);
        menuIniciar.add(appsMenuIniciar, BorderLayout.CENTER);

        frame.add(barraTarefas, BorderLayout.SOUTH);
        frame.add(desktop, BorderLayout.CENTER);
        
        frame.revalidate();
        frame.repaint();

        // fim das adições, abaixo é após a desktop iniciar

        System.out.println(desktop.getSize());
    }

    public static void limpar() {
        for (JComponent componente : listaComponentes) {
            if (componente.getComponentCount() > 0) {
                componente.removeAll();
            }

            componente = null;
        }

        threadRelogio.interrupt();
        relogio = null;
    }
}

package com.rim.appos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class Relogio implements Runnable {

    public JLabel horario;

    @Override
    public void run() {
        while (true) {
            horario.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }
    }
}

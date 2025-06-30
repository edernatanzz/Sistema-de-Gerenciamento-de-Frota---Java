package com.frota;

import com.frota.gui.MainFrame;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainFrame.getInstance().setVisible(true);
        });
    }
}
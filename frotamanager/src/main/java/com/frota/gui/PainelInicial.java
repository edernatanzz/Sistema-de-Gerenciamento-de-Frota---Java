package com.frota.gui;

import javax.swing.*;
import java.awt.*;

public class PainelInicial extends AbstractPanel {
    public PainelInicial(NavegacaoListener navegacaoListener) {
        super(navegacaoListener);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Bem-vindo ao Sistema de Gerenciamento de Frota!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.CENTER);
    }
} 
package com.frota.gui;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel {
    protected NavegacaoListener navegacaoListener;

    public AbstractPanel(NavegacaoListener navegacaoListener) {
        this.navegacaoListener = navegacaoListener;
    }
} 
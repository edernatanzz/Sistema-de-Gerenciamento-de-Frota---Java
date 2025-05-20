package com.frota;

import javax.swing.JOptionPane;

import com.frota.src.model.Carro;
import com.frota.src.model.Veiculo;


public class Main {
    public static void main(String[] args) {
        Veiculo meuCarro = new Carro("ABC1234", "Toyota", "Corolla");
        
        JOptionPane.showMessageDialog(null,
            "Bem-vindo ao Sistema de Gerenciamento de Frota!\n\n" +
            "Veículo cadastrado:\n" + meuCarro.toString(),
            "Sistema de Frota",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
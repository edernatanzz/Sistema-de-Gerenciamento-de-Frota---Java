package com.frota;



import javax.swing.JOptionPane;

import com.frota.model.Carro;
import com.frota.model.Veiculo;




public class Main {
    public static void main(String[] args) {
        Veiculo meuCarro = new Carro("ABC1234", "Toyota", "Corolla", 2020, 4, "Preto", 2.0);
        
        JOptionPane.showMessageDialog(null,
            "Bem-vindo ao Sistema de Gerenciamento de Frota!\n\n" +
            "Veículo cadastrado:\n" + meuCarro.toString(),
            "Sistema de Frota",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
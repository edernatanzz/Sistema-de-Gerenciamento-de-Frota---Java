package main;

import javax.swing.*;
import main.model.Veiculo;
import main.model.Carro;

public class App {
    public static void main(String[] args) {
        Veiculo meuCarro = new Carro("ABC1234", "Toyota", "Corolla");
        
        JOptionPane.showMessageDialog(null,
            "Bem-vindo ao Sistema de Gerenciamento de Frota!\n\n" +
            "Veículo cadastrado:\n" + meuCarro.toString(),
            "Sistema de Frota",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
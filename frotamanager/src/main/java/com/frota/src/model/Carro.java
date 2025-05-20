package com.frota.src.model;

public class Carro extends Veiculo {
    public Carro(String placa, String marca, String modelo) {
        super(placa, marca, modelo);
    }
    
    @Override
    public String toString() {
        return "Carro: " + super.toString();
    }
}
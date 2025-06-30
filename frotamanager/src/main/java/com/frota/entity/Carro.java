package com.frota.entity;

public class Carro extends Veiculo {
    public Carro(String placa, String marca, String modelo, int ano) {
        super(placa, marca, modelo, ano);
    }
    
    /**
     * Implementação fictícia do cálculo de custo de manutenção para Carro.
     * @return custo de manutenção estimado
     */
    @Override
    public double calcularCustoManutencao() {
        // Exemplo: custo fixo fictício
        return 500.0;
    }
    
    @Override
    public String toString() {
        return "Carro: " + super.toString();
    }
}
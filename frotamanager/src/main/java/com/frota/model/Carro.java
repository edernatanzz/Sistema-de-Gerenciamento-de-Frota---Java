package com.frota.model;

/**
 * Classe que representa um carro da frota.
 * Herda de Veiculo e implementa Rastreavel.
 */
public class Carro extends Veiculo implements Rastreavel {
    private int numeroPortas;
    private String tipoCarroceria;
    private double capacidadeTanque;
    private String localizacaoAtual;

    /**
     * Construtor do Carro.
     * @param placa Placa do veículo
     * @param marca Marca do veículo
     * @param modelo Modelo do veículo
     * @param ano Ano de fabricação
     * @param numeroPortas Número de portas
     * @param tipoCarroceria Tipo da carroceria
     * @param capacidadeTanque Capacidade do tanque em litros
     */
    public Carro(String placa, String marca, String modelo, int ano, int numeroPortas, String tipoCarroceria, double capacidadeTanque) {
        super(placa, marca, modelo, ano);
        this.numeroPortas = numeroPortas;
        this.tipoCarroceria = tipoCarroceria;
        this.capacidadeTanque = capacidadeTanque;
        this.localizacaoAtual = "";
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }

    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public double getCapacidadeTanque() {
        return capacidadeTanque;
    }

    public void setCapacidadeTanque(double capacidadeTanque) {
        this.capacidadeTanque = capacidadeTanque;
    }

    @Override
    public double calcularCustoManutencao() {
        // Exemplo: custo base + custo por porta
        return 300.0 + (numeroPortas * 50.0);
    }

    @Override
    public String obterLocalizacaoAtual() {
        return localizacaoAtual;
    }

    @Override
    public void atualizarLocalizacao(String novaLocalizacao) {
        this.localizacaoAtual = novaLocalizacao;
    }

    @Override
    public String toString() {
        return "Carro: " + super.toString() + ", Portas: " + numeroPortas + ", Carroceria: " + tipoCarroceria + ", Tanque: " + capacidadeTanque + "L";
    }
}
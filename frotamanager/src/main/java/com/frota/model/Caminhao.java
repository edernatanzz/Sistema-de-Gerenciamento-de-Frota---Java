package com.frota.model;

/**
 * Classe que representa um caminhão da frota.
 * Herda de Veiculo e implementa Rastreavel.
 */
public class Caminhao extends Veiculo implements Rastreavel {
    private int numeroEixos;
    private double capacidadeCarga;
    private double comprimento;
    private String localizacaoAtual;

    /**
     * Construtor do Caminhao.
     * @param placa Placa do veículo
     * @param marca Marca do veículo
     * @param modelo Modelo do veículo
     * @param ano Ano de fabricação
     * @param numeroEixos Número de eixos
     * @param capacidadeCarga Capacidade de carga em toneladas
     * @param comprimento Comprimento em metros
     */
    public Caminhao(String placa, String marca, String modelo, int ano, int numeroEixos, double capacidadeCarga, double comprimento) {
        super(placa, marca, modelo, ano);
        this.numeroEixos = numeroEixos;
        this.capacidadeCarga = capacidadeCarga;
        this.comprimento = comprimento;
        this.localizacaoAtual = "";
    }

    public int getNumeroEixos() {
        return numeroEixos;
    }

    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }

    @Override
    public double calcularCustoManutencao() {
        // Exemplo: custo base + custo por eixo + custo por tonelada
        return 800.0 + (numeroEixos * 200.0) + (capacidadeCarga * 100.0);
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
        return "Caminhão: " + super.toString() + ", Eixos: " + numeroEixos + ", Carga: " + capacidadeCarga + "t, Comprimento: " + comprimento + "m";
    }
} 
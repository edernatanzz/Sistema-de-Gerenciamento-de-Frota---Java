package com.frota.model;

/**
 * Classe que representa uma van da frota.
 * Herda de Veiculo e implementa Rastreavel.
 */
public class Van extends Veiculo implements Rastreavel {
    private int capacidadePassageiros;
    private boolean possuiAcessibilidade;
    private String localizacaoAtual;

    /**
     * Construtor da Van.
     * @param placa Placa do veículo
     * @param marca Marca do veículo
     * @param modelo Modelo do veículo
     * @param ano Ano de fabricação
     * @param capacidadePassageiros Capacidade de passageiros
     * @param possuiAcessibilidade Se possui acessibilidade
     */
    public Van(String placa, String marca, String modelo, int ano, int capacidadePassageiros, boolean possuiAcessibilidade) {
        super(placa, marca, modelo, ano);
        this.capacidadePassageiros = capacidadePassageiros;
        this.possuiAcessibilidade = possuiAcessibilidade;
        this.localizacaoAtual = "";
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public boolean isPossuiAcessibilidade() {
        return possuiAcessibilidade;
    }

    public void setPossuiAcessibilidade(boolean possuiAcessibilidade) {
        this.possuiAcessibilidade = possuiAcessibilidade;
    }

    @Override
    public double calcularCustoManutencao() {
        // Exemplo: custo base + custo por passageiro + adicional se tiver acessibilidade
        double custo = 400.0 + (capacidadePassageiros * 20.0);
        if (possuiAcessibilidade) {
            custo += 150.0;
        }
        return custo;
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
        return "Van: " + super.toString() + ", Passageiros: " + capacidadePassageiros + ", Acessibilidade: " + (possuiAcessibilidade ? "Sim" : "Não");
    }
} 
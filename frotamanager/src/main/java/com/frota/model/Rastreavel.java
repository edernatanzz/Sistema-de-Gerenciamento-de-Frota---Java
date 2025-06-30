package com.frota.model;

/**
 * Interface para veículos rastreáveis.
 */
public interface Rastreavel {
    /**
     * Obtém a localização atual do veículo.
     * @return localização atual em formato String
     */
    String obterLocalizacaoAtual();

    /**
     * Atualiza a localização do veículo.
     * @param novaLocalizacao nova localização em formato String
     */
    void atualizarLocalizacao(String novaLocalizacao);
} 
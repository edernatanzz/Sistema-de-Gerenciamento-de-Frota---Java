package com.frota.entity;

/**
 * Interface para veículos que podem ser submetidos à manutenção.
 */
public interface Manutencivel {
    /**
     * Agenda uma manutenção para o veículo.
     */
    void agendarManutencao();

    /**
     * Verifica se há manutenção pendente para o veículo.
     * @return true se houver manutenção pendente, false caso contrário
     */
    boolean verificarManutencaoPendente();
} 
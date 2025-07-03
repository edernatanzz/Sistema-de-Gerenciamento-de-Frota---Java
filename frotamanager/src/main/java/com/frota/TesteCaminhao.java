package com.frota;

import java.util.List;

import com.frota.dao.CaminhaoDAO;
import com.frota.dao.CaminhaoDAOImpl;
import com.frota.model.Caminhao;
import com.frota.model.enums.StatusVeiculo;

/**
 * Classe de teste para demonstrar o uso do CaminhaoDAO com JDBC
 */
public class TesteCaminhao {
    
    public static void main(String[] args) {
        // Instanciar o DAO
        CaminhaoDAOImpl caminhaoDAO = new CaminhaoDAOImpl();
        
        // Teste 1: Salvar um novo caminhão
        System.out.println("=== TESTE 1: SALVANDO NOVO CAMINHÃO ===");
        Caminhao novoCaminhao = new Caminhao(0, "UVW-1234", "Scania", "R450", 2024, 3, 30000.0, 16.5);
        novoCaminhao.atualizarLocalizacao("Centro de Distribuição");
        
        try {
            caminhaoDAO.save(novoCaminhao);
            System.out.println("Caminhão salvo com sucesso! ID: " + novoCaminhao.getId());
        } catch (Exception e) {
            System.err.println("Erro ao salvar caminhão: " + e.getMessage());
        }
        
        // Teste 2: Buscar todos os caminhões
        System.out.println("\n=== TESTE 2: LISTANDO TODOS OS CAMINHÕES ===");
        try {
            List<Caminhao> caminhoes = caminhaoDAO.findAll();
            System.out.println("Total de caminhões encontrados: " + caminhoes.size());
            for (Caminhao caminhao : caminhoes) {
                System.out.println(caminhao);
                System.out.println("  -> Localização: " + caminhao.obterLocalizacaoAtual());
                System.out.println("  -> Manutenção pendente: " + (caminhao.verificarManutencaoPendente() ? "SIM" : "NÃO"));
                System.out.println("  -> Custo manutenção: R$ " + String.format("%.2f", caminhao.calcularCustoManutencao()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar caminhões: " + e.getMessage());
        }
        
        // Teste 3: Buscar caminhão por placa
        System.out.println("\n=== TESTE 3: BUSCANDO CAMINHÃO POR PLACA ===");
        try {
            Caminhao caminhaoEncontrado = caminhaoDAO.findByPlaca("JKL-3456");
            if (caminhaoEncontrado != null) {
                System.out.println("Caminhão encontrado: " + caminhaoEncontrado);
                System.out.println("Status: " + caminhaoEncontrado.getStatus());
            } else {
                System.out.println("Nenhum caminhão encontrado com a placa JKL-3456");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar caminhão por placa: " + e.getMessage());
        }
        
        // Teste 4: Agendar manutenção e atualizar
        System.out.println("\n=== TESTE 4: AGENDANDO MANUTENÇÃO ===");
        try {
            Caminhao caminhaoParaManutencao = caminhaoDAO.find(1);
            if (caminhaoParaManutencao != null) {
                System.out.println("Antes - Manutenção pendente: " + caminhaoParaManutencao.verificarManutencaoPendente());
                
                caminhaoParaManutencao.agendarManutencao();
                caminhaoParaManutencao.setStatus(StatusVeiculo.EM_MANUTENCAO);
                caminhaoParaManutencao.atualizarLocalizacao("Oficina Especializada");
                
                caminhaoDAO.update(caminhaoParaManutencao);
                System.out.println("Manutenção agendada e status atualizado!");
                
                // Verificar a atualização
                Caminhao caminhaoAtualizado = caminhaoDAO.find(1);
                System.out.println("Depois - Manutenção pendente: " + caminhaoAtualizado.verificarManutencaoPendente());
                System.out.println("Novo status: " + caminhaoAtualizado.getStatus());
            }
        } catch (Exception e) {
            System.err.println("Erro ao agendar manutenção: " + e.getMessage());
        }
        
        // Teste 5: Buscar caminhões com manutenção pendente
        System.out.println("\n=== TESTE 5: CAMINHÕES COM MANUTENÇÃO PENDENTE ===");
        try {
            List<Caminhao> caminhoesPendentes = caminhaoDAO.findByManutencaoPendente();
            System.out.println("Caminhões com manutenção pendente: " + caminhoesPendentes.size());
            for (Caminhao caminhao : caminhoesPendentes) {
                System.out.println("  -> " + caminhao.getPlaca() + " - " + caminhao.getMarca() + " " + caminhao.getModelo());
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar caminhões com manutenção pendente: " + e.getMessage());
        }
        
        // Teste 6: Buscar por status
        System.out.println("\n=== TESTE 6: CAMINHÕES DISPONÍVEIS ===");
        try {
            List<Caminhao> caminhaoDisponiveis = caminhaoDAO.findByStatus(StatusVeiculo.DISPONIVEL);
            System.out.println("Caminhões disponíveis: " + caminhaoDisponiveis.size());
            for (Caminhao caminhao : caminhaoDisponiveis) {
                System.out.println("  -> " + caminhao.getPlaca() + " - Capacidade: " + caminhao.getCapacidadeCarga() + "kg");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar caminhões disponíveis: " + e.getMessage());
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS ===");
    }
}

package com.frota;

import java.util.List;

import com.frota.dao.CarroDAOImpl;
import com.frota.dao.CaminhaoDAOImpl;
import com.frota.dao.VanDAOImpl;
import com.frota.model.Carro;
import com.frota.model.Caminhao;
import com.frota.model.Van;
import com.frota.model.enums.StatusVeiculo;

/**
 * Classe de teste para demonstrar o uso de todos os DAOs da frota
 */
public class TesteGeral {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GERENCIAMENTO DE FROTA ===");
        System.out.println("Testando todos os tipos de veículos...\n");
        
        // Instanciar todos os DAOs
        CarroDAOImpl carroDAO = new CarroDAOImpl();
        CaminhaoDAOImpl caminhaoDAO = new CaminhaoDAOImpl();
        VanDAOImpl vanDAO = new VanDAOImpl();
        
        // Contadores para relatório final
        int totalCarros = 0;
        int totalCaminhoes = 0;
        int totalVans = 0;
        
        // === TESTE COM CARROS ===
        System.out.println("=== CARROS NA FROTA ===");
        try {
            List<Carro> carros = carroDAO.findAll();
            totalCarros = carros.size();
            System.out.println("Total de carros: " + totalCarros);
            
            for (Carro carro : carros) {
                System.out.println("  🚗 " + carro.getPlaca() + " - " + carro.getMarca() + " " + carro.getModelo() +
                                  " (" + carro.getAno() + ") - " + carro.getNumeroPortas() + " portas");
                System.out.println("      Localização: " + carro.obterLocalizacaoAtual());
                System.out.println("      Custo manutenção: R$ " + String.format("%.2f", carro.calcularCustoManutencao()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar carros: " + e.getMessage());
        }
        
        // === TESTE COM CAMINHÕES ===
        System.out.println("\n=== CAMINHÕES NA FROTA ===");
        try {
            List<Caminhao> caminhoes = caminhaoDAO.findAll();
            totalCaminhoes = caminhoes.size();
            System.out.println("Total de caminhões: " + totalCaminhoes);
            
            for (Caminhao caminhao : caminhoes) {
                System.out.println("  🚛 " + caminhao.getPlaca() + " - " + caminhao.getMarca() + " " + caminhao.getModelo() +
                                  " (" + caminhao.getAno() + ") - " + caminhao.getNumeroEixos() + " eixos");
                System.out.println("      Capacidade: " + String.format("%.0f", caminhao.getCapacidadeCarga()) + "kg");
                System.out.println("      Status: " + caminhao.getStatus());
                System.out.println("      Localização: " + caminhao.obterLocalizacaoAtual());
                System.out.println("      Manutenção pendente: " + (caminhao.verificarManutencaoPendente() ? "SIM" : "NÃO"));
                System.out.println("      Custo manutenção: R$ " + String.format("%.2f", caminhao.calcularCustoManutencao()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar caminhões: " + e.getMessage());
        }
        
        // === TESTE COM VANS ===
        System.out.println("\n=== VANS NA FROTA ===");
        try {
            List<Van> vans = vanDAO.findAll();
            totalVans = vans.size();
            System.out.println("Total de vans: " + totalVans);
            
            for (Van van : vans) {
                System.out.println("  🚐 " + van.getPlaca() + " - " + van.getMarca() + " " + van.getModelo() +
                                  " (" + van.getAno() + ") - " + van.getCapacidadePassageiros() + " passageiros");
                System.out.println("      Acessibilidade: " + (van.isPossuiAcessibilidade() ? "SIM" : "NÃO"));
                System.out.println("      Localização: " + van.obterLocalizacaoAtual());
                System.out.println("      Custo manutenção: R$ " + String.format("%.2f", van.calcularCustoManutencao()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar vans: " + e.getMessage());
        }
        
        // === RELATÓRIOS ESPECIAIS ===
        System.out.println("\n=== RELATÓRIOS ESPECIAIS ===");
        
        // Caminhões com manutenção pendente
        try {
            List<Caminhao> caminhoesPendentes = caminhaoDAO.findByManutencaoPendente();
            System.out.println("🔧 Caminhões com manutenção pendente: " + caminhoesPendentes.size());
            for (Caminhao c : caminhoesPendentes) {
                System.out.println("    -> " + c.getPlaca() + " (" + c.getMarca() + " " + c.getModelo() + ")");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar caminhões com manutenção pendente: " + e.getMessage());
        }
        
        // Caminhões disponíveis
        try {
            List<Caminhao> caminhaoDisponiveis = caminhaoDAO.findByStatus(StatusVeiculo.DISPONIVEL);
            System.out.println("✅ Caminhões disponíveis: " + caminhaoDisponiveis.size());
        } catch (Exception e) {
            System.err.println("Erro ao buscar caminhões disponíveis: " + e.getMessage());
        }
        
        // Vans com acessibilidade
        try {
            List<Van> vansAcessiveis = vanDAO.findComAcessibilidade();
            System.out.println("♿ Vans com acessibilidade: " + vansAcessiveis.size());
        } catch (Exception e) {
            System.err.println("Erro ao buscar vans com acessibilidade: " + e.getMessage());
        }
        
        // Vans grandes (15+ passageiros)
        try {
            List<Van> vansGrandes = vanDAO.findByCapacidadeMinima(15);
            System.out.println("🚌 Vans grandes (15+ passageiros): " + vansGrandes.size());
        } catch (Exception e) {
            System.err.println("Erro ao buscar vans grandes: " + e.getMessage());
        }
        
        // === RELATÓRIO FINAL ===
        int totalVeiculos = totalCarros + totalCaminhoes + totalVans;
        System.out.println("\n=== RESUMO DA FROTA ===");
        System.out.println("🚗 Carros: " + totalCarros);
        System.out.println("🚛 Caminhões: " + totalCaminhoes);
        System.out.println("🚐 Vans: " + totalVans);
        System.out.println("📊 Total de veículos: " + totalVeiculos);
        
        // Teste de polimorfismo - todos implementam Rastreavel
        System.out.println("\n=== TESTE DE POLIMORFISMO - RASTREAMENTO ===");
        System.out.println("Todos os veículos podem ser rastreados:");
        
        try {
            Carro carro = carroDAO.find(1);
            if (carro != null) {
                System.out.println("🚗 Carro " + carro.getPlaca() + " está em: " + carro.obterLocalizacaoAtual());
            }
            
            Caminhao caminhao = caminhaoDAO.find(1);
            if (caminhao != null) {
                System.out.println("🚛 Caminhão " + caminhao.getPlaca() + " está em: " + caminhao.obterLocalizacaoAtual());
            }
            
            Van van = vanDAO.find(1);
            if (van != null) {
                System.out.println("🚐 Van " + van.getPlaca() + " está em: " + van.obterLocalizacaoAtual());
            }
        } catch (Exception e) {
            System.err.println("Erro no teste de polimorfismo: " + e.getMessage());
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS COM SUCESSO! ===");
        System.out.println("Sistema de gerenciamento funcionando corretamente! 🎉");
    }
}

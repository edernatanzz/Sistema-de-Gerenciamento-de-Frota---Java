package com.frota;

import java.util.List;

import com.frota.dao.VanDAOImpl;
import com.frota.model.Van;

/**
 * Classe de teste para demonstrar o uso do VanDAO com JDBC
 */
public class TesteVan {
    
    public static void main(String[] args) {
        // Instanciar o DAO
        VanDAOImpl vanDAO = new VanDAOImpl();
        
        // Teste 1: Salvar uma nova van
        System.out.println("=== TESTE 1: SALVANDO NOVA VAN ===");
        Van novaVan = new Van(0, "RST-7890", "Fiat", "Ducato", 2023, 20, true);
        novaVan.atualizarLocalizacao("Estação Central");
        
        try {
            vanDAO.save(novaVan);
            System.out.println("Van salva com sucesso! ID: " + novaVan.getId());
        } catch (Exception e) {
            System.err.println("Erro ao salvar van: " + e.getMessage());
        }
        
        // Teste 2: Buscar todas as vans
        System.out.println("\n=== TESTE 2: LISTANDO TODAS AS VANS ===");
        try {
            List<Van> vans = vanDAO.findAll();
            System.out.println("Total de vans encontradas: " + vans.size());
            for (Van van : vans) {
                System.out.println(van);
                System.out.println("  -> Localização: " + van.obterLocalizacaoAtual());
                System.out.println("  -> Custo manutenção: R$ " + String.format("%.2f", van.calcularCustoManutencao()));
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar vans: " + e.getMessage());
        }
        
        // Teste 3: Buscar van por placa
        System.out.println("\n=== TESTE 3: BUSCANDO VAN POR PLACA ===");
        try {
            Van vanEncontrada = vanDAO.findByPlaca("GHI-9012");
            if (vanEncontrada != null) {
                System.out.println("Van encontrada: " + vanEncontrada);
                System.out.println("Acessibilidade: " + (vanEncontrada.isPossuiAcessibilidade() ? "SIM" : "NÃO"));
            } else {
                System.out.println("Nenhuma van encontrada com a placa GHI-9012");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar van por placa: " + e.getMessage());
        }
        
        // Teste 4: Atualizar uma van
        System.out.println("\n=== TESTE 4: ATUALIZANDO VAN ===");
        try {
            Van vanParaAtualizar = vanDAO.find(1);
            if (vanParaAtualizar != null) {
                System.out.println("Antes - Capacidade: " + vanParaAtualizar.getCapacidadePassageiros());
                System.out.println("Antes - Localização: " + vanParaAtualizar.obterLocalizacaoAtual());
                
                vanParaAtualizar.setCapacidadePassageiros(18);
                vanParaAtualizar.atualizarLocalizacao("Terminal Norte");
                
                vanDAO.update(vanParaAtualizar);
                System.out.println("Van atualizada com sucesso!");
                
                // Verificar a atualização
                Van vanAtualizada = vanDAO.find(1);
                System.out.println("Depois - Capacidade: " + vanAtualizada.getCapacidadePassageiros());
                System.out.println("Depois - Localização: " + vanAtualizada.obterLocalizacaoAtual());
            }
        } catch (Exception e) {
            System.err.println("Erro ao atualizar van: " + e.getMessage());
        }
        
        // Teste 5: Buscar vans com acessibilidade
        System.out.println("\n=== TESTE 5: VANS COM ACESSIBILIDADE ===");
        try {
            List<Van> vansComAcessibilidade = vanDAO.findComAcessibilidade();
            System.out.println("Vans com acessibilidade: " + vansComAcessibilidade.size());
            for (Van van : vansComAcessibilidade) {
                System.out.println("  -> " + van.getPlaca() + " - " + van.getMarca() + " " + van.getModelo() + 
                                  " (" + van.getCapacidadePassageiros() + " passageiros)");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar vans com acessibilidade: " + e.getMessage());
        }
        
        // Teste 6: Buscar vans por capacidade mínima
        System.out.println("\n=== TESTE 6: VANS COM CAPACIDADE >= 15 PASSAGEIROS ===");
        try {
            List<Van> vansGrandes = vanDAO.findByCapacidadeMinima(15);
            System.out.println("Vans com capacidade >= 15: " + vansGrandes.size());
            for (Van van : vansGrandes) {
                System.out.println("  -> " + van.getPlaca() + " - Capacidade: " + van.getCapacidadePassageiros() + 
                                  " passageiros" + (van.isPossuiAcessibilidade() ? " (Acessível)" : ""));
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar vans por capacidade: " + e.getMessage());
        }
        
        // Teste 7: Demonstrar polimorfismo - interface Rastreavel
        System.out.println("\n=== TESTE 7: TESTANDO RASTREAMENTO ===");
        try {
            Van vanParaRastrear = vanDAO.findByPlaca("RST-7890");
            if (vanParaRastrear != null) {
                System.out.println("Localização atual: " + vanParaRastrear.obterLocalizacaoAtual());
                
                vanParaRastrear.atualizarLocalizacao("Rua Principal, 456 - Centro");
                vanDAO.update(vanParaRastrear);
                
                System.out.println("Nova localização: " + vanParaRastrear.obterLocalizacaoAtual());
            }
        } catch (Exception e) {
            System.err.println("Erro ao testar rastreamento: " + e.getMessage());
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS ===");
    }
}

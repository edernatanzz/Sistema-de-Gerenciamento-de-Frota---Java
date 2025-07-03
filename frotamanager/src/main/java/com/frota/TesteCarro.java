package com.frota;

import java.util.List;

import com.frota.dao.CarroDAO;
import com.frota.dao.CarroDAOImpl;
import com.frota.model.Carro;

/**
 * Classe de teste para demonstrar o uso do CarroDAO com JDBC
 */
public class TesteCarro {
    
    public static void main(String[] args) {

        CarroDAO carroDAO = new CarroDAOImpl();

        // Teste 1: Salvar um novo carro
        System.out.println("=== TESTE 1: SALVANDO NOVO CARRO ===");
        Carro novoCarro = new Carro(0, "XYZ-9999", "Volkswagen", "Jetta", 2023, 4, "Sedan", 55.0);
        
        try {
            carroDAO.save(novoCarro);
            System.out.println("Carro salvo com sucesso! ID: " + novoCarro.getId());
        } catch (Exception e) {
            System.err.println("Erro ao salvar carro: " + e.getMessage());
        }
        
        // Teste 2: Buscar todos os carros
        System.out.println("\n=== TESTE 2: LISTANDO TODOS OS CARROS ===");
        try {
            List<Carro> carros = carroDAO.findAll();
            System.out.println("Total de carros encontrados: " + carros.size());
            for (Carro carro : carros) {
                System.out.println(carro);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar carros: " + e.getMessage());
        }
        
        // Teste 3: Buscar carro por placa
        System.out.println("\n=== TESTE 3: BUSCANDO CARRO POR PLACA ===");
        try {
            Carro carroEncontrado = carroDAO.findByPlaca("ABC-1234");
            if (carroEncontrado != null) {
                System.out.println("Carro encontrado: " + carroEncontrado);
            } else {
                System.out.println("Nenhum carro encontrado com a placa ABC-1234");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar carro por placa: " + e.getMessage());
        }
        
        // Teste 4: Buscar carro por ID
        System.out.println("\n=== TESTE 4: BUSCANDO CARRO POR ID ===");
        try {
            Carro carroEncontrado = carroDAO.find(1);
            if (carroEncontrado != null) {
                System.out.println("Carro encontrado: " + carroEncontrado);
                
                // Teste 5: Atualizar o carro
                System.out.println("\n=== TESTE 5: ATUALIZANDO CARRO ===");
                carroEncontrado.setMarca("Honda Atualizada");
                carroDAO.update(carroEncontrado);
                System.out.println("Carro atualizado com sucesso!");
                
                // Verificar a atualização
                Carro carroAtualizado = carroDAO.find(1);
                System.out.println("Carro após atualização: " + carroAtualizado);
            } else {
                System.out.println("Nenhum carro encontrado com ID 1");
            }
        } catch (Exception e) {
            System.err.println("Erro ao buscar/atualizar carro: " + e.getMessage());
        }
        
        System.out.println("\n=== TESTES CONCLUÍDOS ===");
    }
}

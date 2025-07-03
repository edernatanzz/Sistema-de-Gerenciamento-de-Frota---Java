package com.frota.dao;

import java.util.List;

import com.frota.model.Carro;

public interface CarroDAO {
    void save(Carro carro);
    Carro find(int id);
    Carro findByPlaca(String placa);
    List<Carro> findAll();
    void update(Carro carro);
    void delete(int id);
}

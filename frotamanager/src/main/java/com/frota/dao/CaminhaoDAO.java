package com.frota.dao;

import java.util.List;

import com.frota.model.Caminhao;

public interface CaminhaoDAO {
    public void save (Caminhao caminhao);
    public Caminhao find(int id);
    public Caminhao findByPlaca(String placa);
    public List<Caminhao> findAll();
    public void update(Caminhao caminhao);
    public void delete(int id);
}
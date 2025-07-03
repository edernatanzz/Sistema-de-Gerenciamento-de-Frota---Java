package com.frota.dao;

import java.util.List;

import com.frota.model.Van;

public interface VanDAO {
    public void save(Van van);
    public Van find(int id);
    public Van findByPlaca(String placa);
    public List<Van> findAll();
    public void update(Van van);
    public void delete(int id);
}

package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Planta;

import java.util.List;

public interface PlantaService {
	
	List<Planta> findAll();
    Planta findByCodigo(String codigo);
    boolean save(Planta planta);
    boolean update(Planta planta);
}

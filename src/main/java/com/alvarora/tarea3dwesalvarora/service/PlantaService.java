package com.alvarora.tarea3dwesalvarora.service;

import java.util.List;

import com.alvarora.tarea3dwesalvarora.entities.Planta;

public interface PlantaService {
	
	List<Planta> findAll();
    Planta findByCodigo(String codigo);
    boolean save(Planta planta);
    boolean update(Planta planta);
}

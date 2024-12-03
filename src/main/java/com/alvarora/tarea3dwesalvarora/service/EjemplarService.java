package com.alvarora.tarea3dwesalvarora.service;

import java.util.List;

import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;

public interface EjemplarService {

	List<Ejemplar> findAll();
    Ejemplar findById(Long id);
    List<Ejemplar> findByFkPlanta(String codigo);
    boolean save(Ejemplar ejemplar);
    boolean update(Ejemplar ejemplar);
}

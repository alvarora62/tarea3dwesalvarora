package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;

import java.util.List;

public interface EjemplarService {

	List<Ejemplar> findAll();
    Ejemplar findById(Long id);
    List<Ejemplar> findByFkPlanta(String codigo);
    boolean save(Ejemplar ejemplar);
    boolean update(Ejemplar ejemplar);
}

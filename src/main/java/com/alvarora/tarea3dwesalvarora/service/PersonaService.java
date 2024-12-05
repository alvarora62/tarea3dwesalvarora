package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Credenciales;
import com.alvarora.tarea3dwesalvarora.entities.Persona;
import com.alvarora.tarea3dwesalvarora.utils.PersonaSaveResult;

import java.util.List;

public interface PersonaService {
	
	List<Persona> findAll();
    Persona findById(Long id);
    Persona findByEmail(String email);
    PersonaSaveResult save(Persona persona);
    Credenciales checkForAdmin();

}

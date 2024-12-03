package com.alvarora.tarea3dwesalvarora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvarora.tarea3dwesalvarora.entities.Credenciales;
import com.alvarora.tarea3dwesalvarora.entities.Persona;
import com.alvarora.tarea3dwesalvarora.exceptions.NotFoundException;
import com.alvarora.tarea3dwesalvarora.exceptions.PersonaSaveResult;
import com.alvarora.tarea3dwesalvarora.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

	@Override
	public Persona findById(Long id) {
		return personaRepository.findById(id).orElse(null);
	}

	@Override
	public Persona findByEmail(String email) {
		return personaRepository.findByEmail(email);
	}

    @Override
    @Transactional
    public PersonaSaveResult save(Persona persona) {
        if (checkName(persona.getNombre())) {
            return PersonaSaveResult.INVALID_NAME;
        }

        if (checkEmail(persona.getEmail())) {
            return PersonaSaveResult.INVALID_EMAIL;
        }

        try {
        	personaRepository.save(persona);
            return PersonaSaveResult.SUCCESS;
        } catch (Exception e) {
			return PersonaSaveResult.SQL_ERROR;
		}
    }

	@Override
	public Credenciales checkForAdmin() {
		// Realizar en un futuro
		return null;
	}
	
	 public boolean checkName(String name){
		 String namePattern = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
		 return !name.matches(namePattern);
	}
	 
	 /**
	     * Verifica si un correo electrónico es válido y no existe ya en el sistema.
	     * Este método realiza dos validaciones sobre el correo electrónico proporcionado:
	     *
	     *   - Primero, valida el formato del correo electrónico utilizando una expresión regular.
	     *   - Luego, comprueba en la base de datos si el correo ya está registrado.
	     *
	     * @param email el correo electrónico a verificar.
	     * @return true si el correo electrónico tiene un formato válido y no existe en el sistema;
	     *         false en caso de que el formato sea incorrecto o el correo ya exista en la base de datos.
	     */
	 
	 public boolean checkEmail(String email){
		 String emailPattern = "^[\\w.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	      
		 // Validar mail
		 if (!email.matches(emailPattern)) {
			 return false;
		 }

		 // Comprobar existencia
		 return !personaRepository.existsByEmail(email);
	    
	 }

}

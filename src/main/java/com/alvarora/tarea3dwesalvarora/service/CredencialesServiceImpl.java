package com.alvarora.tarea3dwesalvarora.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvarora.tarea3dwesalvarora.entities.Credenciales;
import com.alvarora.tarea3dwesalvarora.exceptions.CredencialesSaveResult;
import com.alvarora.tarea3dwesalvarora.exceptions.LoginResult;
import com.alvarora.tarea3dwesalvarora.repositories.CredencialesRepository;

import jakarta.transaction.Transactional;

@Service
public class CredencialesServiceImpl implements CredencialesService {
	
	@Autowired
	private CredencialesRepository credencialesRepository;

	@Override
	public Credenciales findByUsername(String username) {
		return credencialesRepository.findByUsername(username);
	}
	
	/**
	 * Método para realizar el inicio de sesión en la aplicación.
	 *
	 * @param username - usuario a loguear
	 * @param password - contraseña del usuario
	 * @return LoginResult que indica el resultado del inicio de sesión.
	 */
	@Override
	public LoginResult login(String username, String password) {
	    // usuario administrador?
	    if ("admin".equals(username) && "admin".equals(password)) {
	        return LoginResult.ADMIN;
	    }

	    // Busca credenciales en base de datos
	    Credenciales credenciales = credencialesRepository.findByUsername(username);

	    if (credenciales == null) {
	        return LoginResult.CRENDENTIALS_ERROR;
	    }

	    // Verifica las credenciales del usuario
	    if (username.equals(credenciales.getUsername()) && password.equals(credenciales.getPassword())) {
	        return LoginResult.USER;
	    }

	    return LoginResult.CRENDENTIALS_ERROR;
	}

	@Override
	@Transactional
	public CredencialesSaveResult save(Credenciales credenciales) {
	    
		// Valida nombre de usuario
		if (!isUsernameUnique(credenciales.getUsername())) {
	        return CredencialesSaveResult.INVALID_USERNAME;
	    }

	    // Valida contraseña
	    if (!isPasswordValid(credenciales.getPassword())) {
	        return CredencialesSaveResult.INVALID_PASSWORD;
	    }

	    // Intenta guardar las credenciales
	    try {
	        credencialesRepository.save(credenciales);
	        return CredencialesSaveResult.SUCCESS;
	    } catch (Exception e) {
	        return CredencialesSaveResult.SQL_ERROR;
	    }
	}

	/**
	 * Verifica si el nombre de usuario es único.
	 * @param username el nombre de usuario a verificar
	 * @return true si es único, false en caso contrario
	 */
	public boolean isUsernameUnique(String username) {
	    return !credencialesRepository.existsByUsername(username);
	}

	/**
	 * Valida que la contraseña cumpla con los requisitos de seguridad:
	 * - Al menos 8 caracteres
	 * - Al menos una letra mayúscula
	 * - Al menos un número
	 * - Al menos un carácter especial
	 * @param password la contraseña a validar
	 * @return true si la contraseña es válida, false en caso contrario
	 */
	public boolean isPasswordValid(String password) {
	    if (password == null || password.length() < 8) {
	        return false;
	    }

	    if (!password.matches(".*[A-Z].*")) { // Al menos una letra mayúscula
	        return false;
	    }

	    if (!password.matches(".*[0-9].*")) { // Al menos un número
	        return false;
	    }

	    if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~].*")) { // Al menos un carácter especial
	        return false;
	    }

	    return true;
	}
}

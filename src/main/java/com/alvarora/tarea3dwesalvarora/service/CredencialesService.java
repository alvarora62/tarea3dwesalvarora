package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Credenciales;
import com.alvarora.tarea3dwesalvarora.utils.CredencialesSaveResult;
import com.alvarora.tarea3dwesalvarora.utils.LoginResult;

public interface CredencialesService {
	
	Credenciales findByUsername(String username);
	CredencialesSaveResult save(Credenciales credenciales);
	LoginResult login(String username, String password);
}

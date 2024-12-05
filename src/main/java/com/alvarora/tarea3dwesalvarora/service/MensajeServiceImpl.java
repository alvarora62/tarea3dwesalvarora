package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import com.alvarora.tarea3dwesalvarora.repositories.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService{
	
	@Autowired
	private MensajeRepository mensajeRepository;

	@Override
	public List<Mensaje> findAll() {
		return mensajeRepository.findAll();
	}

	@Override
	public List<Mensaje> findByPersona(Long id) {
		return mensajeRepository.findByFKPersona(id);
	}

	@Override
	public List<Mensaje> findByEjemplar(Long id) {
		return mensajeRepository.findByFKEjemplar(id);
	}

	@Override
	public List<Mensaje> findBetweenDateTime(LocalDateTime firstLocalDateTime, LocalDateTime secondLocalDateTime) {
		return mensajeRepository.findBetweenDateTime(firstLocalDateTime, secondLocalDateTime);
	}

	@Override
	public void save(Mensaje mensaje) {
		mensajeRepository.save(mensaje);
	}

	@Override
	public void mensajeInicial(Mensaje mensaje) {
		mensaje.setMensaje("Añadido el ejemplar " + mensaje.getEjemplar().getNombre() + " a la base de datos");
        LocalDateTime localDateTime = LocalDateTime.now();
        mensaje.setFechaHora(localDateTime);
        mensajeRepository.save(mensaje);
	}

}

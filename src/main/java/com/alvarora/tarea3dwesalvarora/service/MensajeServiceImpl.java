package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import com.alvarora.tarea3dwesalvarora.repositories.MensajeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService{
	
	@Autowired
	private MensajeRepository mensajeRepository;

	@Autowired
	private PersonaServiceImpl personaService;

	@Autowired
	private EjemplarServiceImpl ejemplarService;

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
	@Transactional
	public void save(Mensaje mensaje) {
		mensajeRepository.save(mensaje);
	}

	@Override
	public void mensajeInicial(Long idPersona, Long idEjemplar) {
		// Creación de mensaje inicial
		Mensaje starterMensaje = new Mensaje();
		starterMensaje.setPersona(personaService.findById(idPersona));
		starterMensaje.setEjemplar(ejemplarService.findById(idEjemplar));

		// Escritura del mensaje inicial
		starterMensaje.setMensaje("Añadido el ejemplar " + starterMensaje.getEjemplar().getNombre() + " a la base de datos");
        LocalDateTime localDateTime = LocalDateTime.now();
		starterMensaje.setFechaHora(localDateTime);

		// Guardado del mensaje
		mensajeRepository.save(starterMensaje);
	}

}

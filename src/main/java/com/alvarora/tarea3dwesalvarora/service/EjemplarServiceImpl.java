package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;
import com.alvarora.tarea3dwesalvarora.exceptions.NotFoundException;
import com.alvarora.tarea3dwesalvarora.repositories.EjemplarRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjemplarServiceImpl implements EjemplarService {
	
	@Autowired
	private EjemplarRepository ejemplarRepository;

	@Override
	public List<Ejemplar> findAll() {
		return ejemplarRepository.findAll();
	}

	@Override
	public Ejemplar findById(Long id){
        return ejemplarRepository.findById(id).orElseThrow(() -> new NotFoundException("Ejemplar no encontrado."));
    }

	@Override
	public List<Ejemplar> findByFkPlanta(String codigo) {
		return ejemplarRepository.findByFkPlanta(codigo);
	}

	@Override
	@Transactional
	public boolean save(Ejemplar saveEjemplar, Long idPersona) {
		// Guardar el ejemplar recien creado
		ejemplarRepository.save(saveEjemplar);

		// Recoger todos los ejemplares
        List<Ejemplar> ejemplares = ejemplarRepository.findAll();
        Ejemplar e = ejemplares.get(ejemplares.size() - 1);

		// Buscar la id del ultimo añadido y ponerle el nombre
		saveEjemplar.setId(e.getId());
		saveEjemplar.setNombre(e.getPlanta().getCodigo() + "-" + e.getId());

		// Actualizar el ejemplar con el nombre nuevo
        ejemplarRepository.save(saveEjemplar);

		// Crear el mensaje inicial
		MensajeServiceImpl mensajeService = new MensajeServiceImpl();
		mensajeService.mensajeInicial(idPersona,saveEjemplar.getId());

        return true;
	}

	@Override
	public boolean update(Ejemplar ejemplar) {
		ejemplarRepository.save(ejemplar);
		return true;
	}

}

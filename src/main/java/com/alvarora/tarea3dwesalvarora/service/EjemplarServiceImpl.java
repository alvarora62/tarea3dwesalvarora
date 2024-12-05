package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;
import com.alvarora.tarea3dwesalvarora.exceptions.NotFoundException;
import com.alvarora.tarea3dwesalvarora.repositories.EjemplarRepository;
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
	public boolean save(Ejemplar ejemplar) {
		ejemplarRepository.save(ejemplar);
        List<Ejemplar> ejemplars = ejemplarRepository.findAll();
        Ejemplar e = ejemplars.get(ejemplars.size() - 1);
        ejemplar.setId(e.getId());
        ejemplar.setNombre(e.getPlanta().getCodigo() + "-" + e.getId());
        ejemplarRepository.save(ejemplar);
        return true;
	}

	@Override
	public boolean update(Ejemplar ejemplar) {
		ejemplarRepository.save(ejemplar);
		return true;
	}

}

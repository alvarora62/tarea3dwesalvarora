package com.alvarora.tarea3dwesalvarora.service;

import com.alvarora.tarea3dwesalvarora.entities.Planta;
import com.alvarora.tarea3dwesalvarora.repositories.PlantaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaServiceImpl implements PlantaService {
	
	private final String codigoPattern = "^[A-Za-z]+$";
	
	@Autowired
	private PlantaRepository plantaRepository;

	@Override
	public List<Planta> findAll() {
		return plantaRepository.findAll();
	}

	@Override
	public Planta findByCodigo(String codigo) {
		Planta planta = plantaRepository.findByCodigo(codigo);
		if (planta == null) {
		}
		return planta;
	}

	@Override
	@Transactional
	public boolean save(Planta planta) {
		if (planta == null) {
			return false;
		}
		
		if (isCodigoValid(planta)) {
			return false;
		}
		
		plantaRepository.save(planta);
		return true;
	}

	@Override
	@Transactional
	public boolean update(Planta planta) {
		if (planta == null) {
			return false;
		}
		
		if (isCodigoValid(planta)) {
			return false;
		}
		
		plantaRepository.save(planta);
		return true;
	}
	
	private boolean isCodigoValid(Planta planta) {
		if (planta.getCodigo() == null || !planta.getCodigo().toUpperCase().matches(codigoPattern)) {
            return false;
        }
		
		Planta plantaCheckCodigo = plantaRepository.findByCodigo(planta.getCodigo());
		
		if (plantaCheckCodigo != null && !plantaCheckCodigo.getId().equals(planta.getId())) {
			return false;
		}
		
		return true;
	}
	

}

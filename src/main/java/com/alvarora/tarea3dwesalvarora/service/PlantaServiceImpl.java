package com.alvarora.tarea3dwesalvarora.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvarora.tarea3dwesalvarora.entities.Planta;
import com.alvarora.tarea3dwesalvarora.repositories.PlantaRepository;

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
	public boolean save(Planta planta) {
		if (planta == null) {
			return false;
		}
		
		if (!checkCodigo(planta)) {
			return false;
		}
		
		plantaRepository.save(planta);
		return true;
	}

	@Override
	public boolean update(Planta planta) {
		if (planta == null) {
			return false;
		}
		
		if (!checkCodigo(planta)) {
			return false;
		}
		
		plantaRepository.save(planta);
		return true;
	}
	
	private boolean checkCodigo(Planta planta) {
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

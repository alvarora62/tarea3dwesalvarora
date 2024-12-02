package com.alvarora.tarea3dwesalvarora.servicies;

import com.alvarora.tarea3dwesalvarora.entities.Planta;
import com.alvarora.tarea3dwesalvarora.exceptions.NotFoundException;
import com.alvarora.tarea3dwesalvarora.repositories.PlantaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantaServicioImpl implements PlantaServicio{

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
        if (planta == null){
            throw new NotFoundException("La planta con ese codigo non existe.");
        }
        return planta;
    }

    @Override
    @Transactional
    public boolean save(Planta planta) {
        if (!planta.getCodigo().toUpperCase().matches(codigoPattern)){
            return false;
        }
        planta.setCodigo(planta.getCodigo().toUpperCase());
        plantaRepository.save(planta);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Planta planta) {
        plantaRepository.save(planta);
        return true;
    }
}

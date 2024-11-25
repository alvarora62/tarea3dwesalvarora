package com.alvarora.tarea3dwesalvarora.servicies;

import com.alvarora.tarea3dwesalvarora.entities.Planta;
import com.alvarora.tarea3dwesalvarora.repositories.PlantaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlantaServicioImpl implements PlantaServicio{

    private final PlantaRepository plantaRepository;

    @Override
    public List<Planta> findAll(){
        return plantaRepository.findAll();
    }

    @Override
    @Transactional
    public boolean save(Planta planta) {
        try {
            plantaRepository.saveAndFlush(planta);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}

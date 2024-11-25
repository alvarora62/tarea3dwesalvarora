package com.alvarora.tarea3dwesalvarora.servicies;

import com.alvarora.tarea3dwesalvarora.entities.Planta;

import java.util.List;

public interface PlantaServicio {

    List<Planta> findAll();
    boolean save(Planta planta);
}

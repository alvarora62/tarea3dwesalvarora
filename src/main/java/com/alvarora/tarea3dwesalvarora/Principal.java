package com.alvarora.tarea3dwesalvarora;

import com.alvarora.tarea3dwesalvarora.servicies.PlantaServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class Principal implements CommandLineRunner {

    @Autowired
    private PlantaServicioImpl plantaServicio;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("A");
        System.out.println(plantaServicio.findAll());
    }
}

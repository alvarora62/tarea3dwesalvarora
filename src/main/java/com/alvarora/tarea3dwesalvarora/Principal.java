package com.alvarora.tarea3dwesalvarora;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.alvarora.tarea3dwesalvarora.service.CredencialesServiceImpl;
import com.alvarora.tarea3dwesalvarora.service.EjemplarServiceImpl;
import com.alvarora.tarea3dwesalvarora.service.PersonaServiceImpl;
import com.alvarora.tarea3dwesalvarora.service.PlantaServiceImpl;

public class Principal implements CommandLineRunner {

    @Autowired
    private Controller controller;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("A");
        
        System.out.println(controller.getServicioCredenciales().login("a", "a"));
        System.out.println(controller.getServicioPlanta().findAll());
        System.out.println(controller.getServicioEjemplar().findAll());
        System.out.println(controller.getServicioMensaje().findAll());
        
   
    }
}

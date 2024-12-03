package com.alvarora.tarea3dwesalvarora;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.alvarora.tarea3dwesalvarora.service.CredencialesServiceImpl;
import com.alvarora.tarea3dwesalvarora.service.EjemplarServiceImpl;
import com.alvarora.tarea3dwesalvarora.service.PersonaServiceImpl;
import com.alvarora.tarea3dwesalvarora.service.PlantaServiceImpl;

public class Principal implements CommandLineRunner {

    //TODO aplicar patrones factory y singletone a los servicios. (Controlador)
	@Autowired
	private CredencialesServiceImpl credencialesServiceImpl;
	
	@Autowired
	private PersonaServiceImpl personaServiceImpl;
	
	@Autowired
	private PlantaServiceImpl plantaServiceImpl;
	
	@Autowired
	private EjemplarServiceImpl ejemplarServiceImpl;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("A");
        
        System.out.println(credencialesServiceImpl.login("a", "a"));
        System.out.println(personaServiceImpl.findAll());
        System.out.println(ejemplarServiceImpl.findAll());
        System.out.println(plantaServiceImpl.findAll());
        
   
    }
}

package com.alvarora.tarea3dwesalvarora.controller;

import com.alvarora.tarea3dwesalvarora.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    private static Controller controller;

    @Autowired
    private CredencialesServiceImpl servicioCredenciales;
    @Autowired
    private PersonaServiceImpl servicioPersona;
    @Autowired
    private PlantaServiceImpl servicioPlanta;
    @Autowired
    private EjemplarServiceImpl servicioEjemplar;
    @Autowired
    private MensajeServiceImpl servicioMensaje;

    public static Controller getControlador() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public CredencialesServiceImpl getServicioCredenciales() {
        return servicioCredenciales;
    }

    public PersonaServiceImpl getServicioPersona() {
        return servicioPersona;
    }

    public PlantaServiceImpl getServicioPlanta() {
        return servicioPlanta;
    }

    public EjemplarServiceImpl getServicioEjemplar() {
        return servicioEjemplar;
    }

    public MensajeServiceImpl getServicioMensaje() {
        return servicioMensaje;
    }

}

package com.alvarora.tarea3dwesalvarora.view;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;
import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.alvarora.tarea3dwesalvarora.view.MainMenu.activeUser_username;
import static com.alvarora.tarea3dwesalvarora.view.Spacer.spacer;

public class MensajesMenu {

    // Variables de utilidad
    boolean on = true;
    Scanner sc = new Scanner(System.in);

    @Autowired
    private Controller controller;

    PlantasMenu plantasMenu = new PlantasMenu();

    /**
     * Menu presentado a un perfil de usuario
     */
    public void menuMensajesUser(){
        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero** (Gestión de Mensajes) [Usuario activo: " + activeUser_username + "]");
            System.out.println("\t\t\t1 - Hacer anotacion a un ejemplar");
            System.out.println("\t\t\t2 - Listar mensajes");
            System.out.println("\t\t\t3 - Listar mensajes por persona");
            System.out.println("\t\t\t4 - Listar mensajes por rango de fechas");
            System.out.println("\t\t\t5 - Listar por tipo de planta");
            System.out.println("\t\t\t9 - Cerrar Sesion");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        spacer();
                        saveMensaje();
                        break;
                    case 2:
                        spacer();
                        findAll();
                        break;
                    case 3:
                        spacer();
                        findAllByPersona();
                        break;
                    case 4:
                        spacer();
                        findBetweenDates();
                        break;
                    case 5:
                        spacer();
                        findAllByPlanta();
                        break;
                    case 9:
                        spacer();
                        System.out.println("Saliendo de la gestion de mensajes...");
                        on = false;
                        break;
                    default:
                        spacer();
                        System.err.println("Opción no válida. Por favor, introduzca alguna opción válida de las presentadas.");
                        break;
                }
            } catch (InputMismatchException e){
                spacer();
                System.err.println("Dato introducido no válido. Por favor, introduce una opcion valida.");
                sc.next();
            }
        } while (on);
    }

    private void saveMensaje() {
        List<Ejemplar> ejemplares = controller.getServicioEjemplar().findAll();

        if (!ejemplares.isEmpty()){
            System.out.println("¿Sobre que ejemplar quieres hacer una anotacion?");

            System.out.println("----------------------------------------------------------------------");
            for (Ejemplar ejemplar : ejemplares){
                System.out.println(ejemplar.toString());
            }
            System.out.println("----------------------------------------------------------------------");

            Long id = null;
            do {
                try{
                    id = sc.nextLong();
                } catch (InputMismatchException inputMismatchException){
                    System.err.println("El Id introducido no es un numero.");
                }
                if (controller.getServicioEjemplar().findById(id) == null && id == null){
                    System.err.println("Dato introducio no valido.");
                }
            } while (controller.getServicioEjemplar().findById(id) == null && id == null);

            System.out.println("¿Qué anotación quieres hacer?");
            String txt = sc.next();

            Mensaje mensaje = new Mensaje();
            mensaje.setEjemplar(controller.getServicioEjemplar().findById(id));
            mensaje.setPersona(controller.getServicioPersona().findById(controller.getServicioCredenciales().findByUsername(activeUser_username).getId()));
            mensaje.setMensaje(txt);
            mensaje.setFechaHora(LocalDateTime.now());

            if (controller.getServicioMensaje().save(mensaje)){
                System.out.println("Anotacion creada con exito.");
            } else {
                System.err.println("Error creando el mensaje.");
            }
        } else {
            System.err.println("Todavia no hay ejemplares en el sistema.");
        }
    }

}

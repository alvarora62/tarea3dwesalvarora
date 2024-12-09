package com.alvarora.tarea3dwesalvarora.view;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import com.alvarora.tarea3dwesalvarora.entities.Ejemplar;
import com.alvarora.tarea3dwesalvarora.entities.Mensaje;
import com.alvarora.tarea3dwesalvarora.entities.Persona;
import com.alvarora.tarea3dwesalvarora.entities.Planta;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.*;

import static com.alvarora.tarea3dwesalvarora.view.MainMenu.activeUser_username;
import static com.alvarora.tarea3dwesalvarora.view.Spacer.spacer;

public class EjemplaresMenu {

    // Variables de utilidad
    boolean on = true;
    Scanner sc = new Scanner(System.in);

    @Autowired
    private Controller controller;

    PlantasMenu plantasMenu = new PlantasMenu();

    /**
     * Menu presentado a un perfil de usuario
     */
    public void menuEjemplaresUser(){
        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero** (Gestion de Ejemplares)  [Usuario Activo: " + activeUser_username + "]");
            System.out.println("\t\t\t1 - Resgistrar ejemplar");
            System.out.println("\t\t\t2 - Listar ejemplares por Planta");
            System.out.println("\t\t\t3 - Ver mensajes de seguimiento");
            System.out.println("\t\t\t9 - Atrás");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        spacer();
                        saveEjemplar();
                        break;
                    case 2:
                        spacer();
                        listByPlantFK();
                        break;

                    case 3:
                        spacer();
                        listAllMensajeByEjemplarID();
                        break;
                    case 9:
                        spacer();
                        System.out.println("Saliendo de la gestion de ejemplares...");
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

    private void saveEjemplar() {
        Ejemplar saveEjemplar = new Ejemplar();
        Planta planta;
        System.out.println("Registro de un nuevo ejemplar.\n");

        if (!controller.getServicioPlanta().findAll().isEmpty()){
            // Listar plantas
            plantasMenu.listadoPlantas();

            // Recoger los datos del usuario.
            System.out.println("¿De qué tipo de planta es el ejemplar nuevo?");
            String fk_planta = sc.next().toUpperCase().trim();


            // Comprobar si la planta existe
            planta = controller.getServicioPlanta().findByCodigo(fk_planta);
            if (planta == null){
                System.err.println("Código de planta NO válido.");
            }

            // Guardar ejemplar
            saveEjemplar.setPlanta(planta);
            controller.getServicioEjemplar().save(saveEjemplar,controller.getServicioPersona().findById(controller.getServicioCredenciales().findByUsername(activeUser_username).getPersona().getId()).getId());

        } else {
            System.err.println("No hay plantas en el sistema");
        }
    }

    private void listByPlantFK() {
        List<String> codigosPlantas = new ArrayList<>();
        String salir = "salir";
        String codigoBuscar;
        System.out.println("Estas son las plantas guardadas actualmente en el sistema:");

        // Comprobar si hay plantas en el sistema
        if (!controller.getServicioPlanta().findAll().isEmpty()){
            // Listar las plantas del sistema
            plantasMenu.listadoPlantas();

            // Bucle para pedir los codigos de planta
            do {
                // Pedir codigo al usuario
                System.out.print("\nIngrese el código de la planta para buscar sus ejemplares (usa '" + salir + "' para finalizar la selección): ");
                codigoBuscar = sc.next().trim().toUpperCase();

                // Comprobar si el codigo es igual al codigo de salida
                if (!codigoBuscar.equalsIgnoreCase(salir)){

                    // Comprobar si el codigo de la planta existe.
                    if (controller.getServicioPlanta().findByCodigo(codigoBuscar) != null){
                        codigosPlantas.add(codigoBuscar);
                    } else {
                        System.err.println("El codigo introducido no existe.");
                    }
                }
            } while (!codigoBuscar.equalsIgnoreCase(salir));

            // Listado de ejemplares
            System.out.println("\nEjemplares encontrados:");
            System.out.println("----------------------------------------------------------------------");

            for (String codigoPlanta : codigosPlantas){
                List<Ejemplar> ejemplares = controller.getServicioEjemplar().findByFkPlanta(codigoPlanta);

                for (Ejemplar ejemplar : ejemplares){
                    int numMensajes = controller.getServicioMensaje().findByEjemplar(ejemplar.getId()).size();
                    List<Mensaje> mensajes = controller.getServicioMensaje().findByEjemplar(ejemplar.getId());

                    LocalDateTime localDateTime = null;
                    if (!mensajes.isEmpty()){
                        localDateTime = mensajes.get(mensajes.size()-1).getFechaHora();
                        System.out.println("Nombre del ejemplar" + ejemplar.getNombre() + " | Nº de mensajes: " + numMensajes + " | Fecha y Hora ultima actualizacion: " + localDateTime);
                    } else {
                        System.out.println("Nombre del ejemplar" + ejemplar.getNombre() + " | No hay mensajes todavia");
                    }
                }
            }
            System.out.println("----------------------------------------------------------------------");
        }
    }

    private void listAllMensajeByEjemplarID() {
        long ejemplarId = 0L;

        // Comprobar si hay listado o no
        if (listEjemplar()) {
            // Pedir el id de un ejemplar
            System.out.println("¿De qué ejemplar quieres ver los mensajes? (Introduce el ID del ejemplar)");
            try{
                ejemplarId = sc.nextLong();
            } catch (InputMismatchException e){
                System.err.println("Valor no válido.");
            }

            // Buscar los mensajes del ejemplar solicitado y ordenarlos por fecha
            List<Mensaje> ejemplarMensajes = controller.getServicioMensaje().findByEjemplar(ejemplarId);
            ejemplarMensajes.sort(Comparator.comparing(Mensaje::getFechaHora));

            // Lista los mensajes enseñando la informacioón necesaria
            for (Mensaje mensaje : ejemplarMensajes) {
                Persona persona = controller.getServicioPersona().findById(mensaje.getPersona().getId());
                System.out.println("Fecha y Hora: " + mensaje.getFechaHora() + " | Mensaje: " + mensaje.getMensaje() + " | Creado por: " + persona.getNombre());
            }
        }
    }

    /**
     * Método que devuelve una lista de todos los ejemplares.
     *
     * @return true - si hay ejemplares en el sistema. false - si no hay ejemplares en el sistema
     */
    public boolean listEjemplar(){
        List<Ejemplar> ejemplares = controller.getServicioEjemplar().findAll();
        if (ejemplares.isEmpty()){
            System.err.println("No hay ejemplares registrados en el sistema.");
            return false;
        }
        System.out.println("----------------------------------------------------------------------");
        for (Ejemplar ejemplar : ejemplares) {
            System.out.println(ejemplar.toString());
        }
        System.out.println("----------------------------------------------------------------------");
        return true;
    }

}

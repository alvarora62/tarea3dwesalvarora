package com.alvarora.tarea3dwesalvarora.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import com.alvarora.tarea3dwesalvarora.entities.Planta;

import static com.alvarora.tarea3dwesalvarora.view.Spacer.spacer;

public class PlantasMenu {
	
	// Variables de utilidad
	boolean on = true;
    Scanner sc = new Scanner(System.in);
    
    @Autowired
    private Controller controller;

    /**
     * Vista del menu de plantas para un perfil de administrador
     */
    public void menuPlantas(){
        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero** (Gestión de Plantas) [Usuario activo: " + MainMenu.activeUser_username + "]");
            System.out.println("\t\t\t1 - Registrar planta");
            System.out.println("\t\t\t2 - Listar plantas");
            System.out.println("\t\t\t3 - Modificar planta");
            System.out.println("\t\t\t9 - Atrás");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                    	Planta planta = new Planta();
                        spacer();

                        System.out.println("Registro de una nueva planta.");
                        System.out.println("");

                        do {
                        	// Se le pide un codigo para la planta
                            System.out.println("\tCódigo de la planta: (Deberá de ser entero en mayusculas)");
                            String codigo = sc.next();
                            planta.setCodigo(codigo);
                            
                            // Se pide el nombre comun de la planta
                            System.out.println("\tNombre comun de la planta:");
                            String nombreComun = sc.next();
                            planta.setNombreComun(nombreComun);
                            
                            // Se pide el nombre cientifico de la planta
                            System.out.println("\tNombre cientifico de la planta");
                            String nombreCientifico = sc.next();
                            planta.setNombreCientifico(nombreCientifico);

                            // Si guardar la planta falla, muestra un mensaje de error
                            if (!controller.getServicioPlanta().save(planta)){
                                System.err.println("Error de formato en la planta introducida.");
                            }
                        } while (!controller.getServicioPlanta().save(planta));
                        break;
                        
                    case 2:
                        spacer();
                        // Llamo al listado de plantas
                        listadoPlantas();
                        break;
                        
                    case 3:
                        spacer();

                        System.out.println("Actualizar una planta existente.\n");
                        String codigo;
                        
                        // Compruebo si la lista de plantas esta vacia o no.
                        if (!controller.getServicioPlanta().findAll().isEmpty()) {
                        	// Muestro todas las plantas
                        	listadoPlantas();
                        	
                        	// Pregunto que planta quiere actualizar
                        	System.out.println("¿Qué planta quieres actualizar? (Introduce el código)");
                            codigo = sc.next();
                            
                            // Busco la planta por codigo
                            Planta plantaBuscada = controller.getServicioPlanta().findByCodigo(codigo);
                            
                            // Comprueba si la planta es nula
                        	if (!plantaBuscada.equals(null)) {
                        		System.out.println("Planta no encontrada o codigo no válido.");
							} else {
								Planta plantaNueva = new Planta();
								plantaNueva.setCodigo(codigo);
								System.out.println("Planta valida para la actualizacion de datos.");
								
								// Nuevo nombre comun
								System.out.println("\tNuevo nombre comun para la planta:");
                                String nombreComun = sc.next();
                                plantaNueva.setNombreComun(nombreComun);
                                
                                // Nuevo nombre cientifico
                                System.out.println("\tNuevo nombre cientifico para la planta");
                                String nombreCientifico = sc.next();
                                plantaNueva.setNombreCientifico(nombreCientifico);
                                
                                // Actualizar la planta
                                if (!controller.getServicioPlanta().update(plantaNueva)) {
                                	System.err.println("Error de formato en la planta introducida.");
								}
								
							}
                        	
                        	
                        	
                        	

                            do {
                                

                              

                                if (controlador.getServicioPlanta().update(planta)){
                                    
                                    estado = true;
                                } else {
                                    System.err.println("Error de formato en la planta introducida.");
                                }

                            }while (!estado);
                            estado = false;
                        	
                        	
                        } else {
                        	System.err.println("No hay plantas en el sistema.");
                        }
                        
                        
                        
                        listadoPlantas();

                        
                       
                        break;
                    case 4:
                        spacer();
                        // Eliminar planta
                        break;
                    case 9:
                        spacer();
                        System.out.println("Saliendo de la gestion de plantas.");
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


    /**
     * Metodo que muestra por pantalla todas las plantas registradas en el sistema.
     * Si no hay ninguna mostrara un mensaje diciendolo.
     */
    public void listadoPlantas(){
        List<Planta> plantas = controller.getServicioPlanta().findAll();

        if (plantas.isEmpty()){
            System.out.println("No hay plantas registradas en el sistema.");
        } else {
            System.out.println("Listado de plantas");
            System.out.println("");
            System.out.println("--------------------------------------------------------------------");
            for (Planta planta : plantas) {
                System.out.println(planta.toString());
            };
            System.out.println("--------------------------------------------------------------------");
        }
    }
    
}

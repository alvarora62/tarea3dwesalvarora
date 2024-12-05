package com.alvarora.tarea3dwesalvarora.view;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.alvarora.tarea3dwesalvarora.view.Spacer.spacer;

@Component
public class MainMenu {

    // Variables de utilidad
    static Long activeUser_id;
    static String activeUser_username;
    boolean on = true;
    Scanner sc = new Scanner(System.in);

    @Autowired
    private Controller controller;

    /**
     * Menu presentado al perfil de invitado (al abrir la aplicación).
     */
    public void menuPrincipal(){
//        Credenciales credenciales = controlador.getServicioPersona().checkForAdmin();
//        if (credenciales != null)
//            controlador.getServicioCredenciales().save(credenciales);

        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero**");
            System.out.println("\t\t\t1 - Ver plantas");
            System.out.println("\t\t\t2 - Iniciar sesión");
            System.out.println("\t\t\t9 - Salir de la aplicación");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        spacer();
                        // Llamada al menu de plantas?
                        controller.getServicioPlanta().findAll();
                        on = true;
                        break;
                    case 2:
                        spacer();
                        int nivel;

                        System.out.println("\tNombre de usuario");
                        activeUser_username = sc.next();
                        System.out.println("\tContraseña:");
                        String password = sc.next();

                        switch (controller.getServicioCredenciales().login(activeUser_username, password)) {
                            case USERNAME_ERROR:
                                System.err.println("Error en el nombre de usuario.");
                                break;
                            case PASSWORD_ERROR:
                                System.err.println("Error en la contraseña.");
                                break;
                            case USER:
                                // Mirar si necesario?
//                                Credenciales login = controller.getServicioCredenciales().findByUsername(activeUser_username);
//                                activeUser_id = controlador.getServicioPersona().findById(login.getFk_persona().getId()).getId();
                                password = "";
                                menuPrincipalPersonal();
                                break;
                            case ADMIN:
                                activeUser_id = controller.getServicioPersona().findByEmail("admin@admin.com").getId();
                                //menuPrincipalAdmin();
                                break;
                        }

                        on = true;
                        break;
                    case 9:
                        spacer();
                        System.out.println("Apagando aplicación.");
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
     * Menu presentado a un empleado del vivero
     */
    public void menuPrincipalPersonal(){
        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero** [Usuario Actual: " + activeUser_username + "]");
            System.out.println("\t\t\t1 - Gestión ejemplares");
            System.out.println("\t\t\t2 - Gestión de mensajes");
            System.out.println("\t\t\t9 - Cerrar Sesión");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        spacer();
                        //ejemplaresMenu.menuEjemplaresUser();
                        on = true;
                        break;
                    case 2:
                        spacer();
                        //mensajesMenu.menuMensajesUser();
                        on = true;
                    case 9:
                        spacer();
                        System.out.println("Cerrando sesion...");
                        on = false;
                        break;
                    default:
                        spacer();
                        System.err.println("Opción no válida. Por favor, introduzca alguna opción válida de las presentadas.");
                        break;
                }
            } catch (InputMismatchException e){
                spacer();
                System.err.println("Opción no válida. Por favor, introduzca alguna opción válida de las presentadas.");
                sc.next();
            }
        } while (on);
    }

    /**
     * Menu presentado a un perfil de administrador
     */
    public void menuPrincipalAdmin(){
        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero** [Usuario Actual " + activeUser_username + "]");
            System.out.println("\t\t\t1 - Gestion de plantas");
            System.out.println("\t\t\t2 - Gestión ejemplares");
            System.out.println("\t\t\t3 - Gestion de empleados");
            System.out.println("\t\t\t4 - Gestión de mensajes");
            System.out.println("\t\t\t9 - Cerrar Sesion");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        spacer();
                        //plantasMenu.menuPlantas();
                        on = true;
                        break;
                    case 2:
                        spacer();
                        //ejemplaresMenu.menuEjemplaresUser();
                        on = true;
                        break;
                    case 3:
                        spacer();
                        //personaMenu.menuPersona();
                        on = true;
                        break;
                    case 4:
                        spacer();
                        //mensajesMenu.menuMensajesUser();
                        on = true;
                        break;
                    case 9:
                        spacer();
                        System.out.println("Cerrando sesion...");
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
}

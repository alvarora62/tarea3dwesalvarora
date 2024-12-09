package com.alvarora.tarea3dwesalvarora.view;

import com.alvarora.tarea3dwesalvarora.controller.Controller;
import com.alvarora.tarea3dwesalvarora.entities.Credenciales;
import com.alvarora.tarea3dwesalvarora.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.InputMismatchException;
import java.util.Scanner;

import static com.alvarora.tarea3dwesalvarora.view.MainMenu.activeUser_username;
import static com.alvarora.tarea3dwesalvarora.view.Spacer.spacer;

public class PersonaMenu {

    // Variables de utilidad
    boolean on = true;
    Scanner sc = new Scanner(System.in);

    @Autowired
    private Controller controller;

    public void menuPersona(){
        do {
            System.out.println("\t\t\t**Sistema Gestor del Viviero** (Gestión de Personal) [Usuario activo: " + activeUser_username + "]");
            System.out.println("\t\t\t1 - Alta de un empleado");
            System.out.println("\t\t\t9 - Atrás");

            try{
                int answer = sc.nextInt();

                switch (answer) {
                    case 1:
                        spacer();
                        savePersona();
                        break;
                    case 9:
                        spacer();
                        System.out.println("Saliendo de la gestión de empleados...");
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

    private void savePersona() {
        Persona persona = new Persona();
        String nombre;
        String email;
        System.out.println("Alta de un nuevo empleado. ");
        System.out.print("\n\nDatos personales del usuario.");

        // Pedir nombre
        System.out.println("\nIntroduce el nombre del nuevo empleado:");
        nombre = sc.next();

        // Pedir email
        System.out.println("\nIntroduce el email del nuevo empleado: \nSe tendrá en cuenta el siguiente patrón: x@x.(com/es/org). Además, el email no puede existir ya en el sistema.\n");
        email = sc.next();

        // Guardado de la persona
        persona.setNombre(nombre);
        persona.setEmail(email);
        switch (controller.getServicioPersona().save(persona)) {
            case SUCCESS -> {
                System.out.println("Empleado añadido con exito.");
                saveCredenciales(persona.getEmail());
            }
            case INVALID_NAME -> System.err.println("Nombre de persona invalido.");
            case INVALID_EMAIL -> System.err.println("Email de persona invalido.");
            case SQL_ERROR -> System.err.println("Error interno sql.");
        }

    }

    private void saveCredenciales(String personaEmail) {
        Credenciales credenciales = new Credenciales();
        String username;
        String passwd;

        System.out.println("\n\nCreacion de datos de acceso para el usuario nuevo.");

        // Validacion username
        System.out.println("Ingrese un nombre de usuario único:");
        username = sc.next();

        // Validacion passwd
        System.out.println("Ingrese una contraseña para el empleado (mínimo 8 caracteres, al menos una mayúscula, un símbolo y un número):");
        passwd = sc.next();

        // Guardado de las credenciales
        credenciales.setUsername(username);
        credenciales.setPassword(passwd);
        switch (controller.getServicioCredenciales().save(credenciales)) {
            case SUCCESS -> System.out.println("Credenciales creadas con exito.");
            case INVALID_USERNAME -> System.err.println("Nombre de usuario repetido.");
            case INVALID_PASSWORD -> System.err.println("Contraseña con formato incorrecto.");
            case SQL_ERROR -> System.err.println("Error sql.");
        }

    }
}

package com.alvarora.tarea3dwesalvarora.utils;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Validations {

    public static LocalDateTime pedirFecha() {

        Scanner sc = new Scanner(System.in);

        // Crear datos para la fecha
        System.out.println("Dime un día:");
        String dia_String = sc.next();
        System.out.println("Dime un mes:");
        String mes_String = sc.next();
        System.out.println("Dime un año:");
        String ano_String = sc.next();

        int dia = 0;
        int mes = 0;
        int ano = 0;
        try {
            dia = Integer.parseInt(dia_String);
            mes = Integer.parseInt(mes_String);
            ano = Integer.parseInt(ano_String);
        } catch (NumberFormatException e) {
            System.err.println("Valor introducido NO válido: " + e.getMessage());
            return null;
        }

        // Validar fecha
        LocalDateTime userDate;
        try {
            userDate = LocalDateTime.of(ano, mes, dia, 0, 0);
        } catch (Exception e) {
            System.err.println("Fecha no válida: " + e.getMessage());
            return null;
        }

        // Mirar si la fecha actual es menor que la introducida
        LocalDateTime currentDate = LocalDateTime.now();
        if (userDate.isAfter(currentDate)) {
            System.err.println("La fecha es futura. Fecha inválida.");
            return null;
        }

        sc.close();
        return userDate;
    }
}

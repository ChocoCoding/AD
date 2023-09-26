package org.example.primera_evaluacion.unidad1.Ejercicio102;

import java.text.BreakIterator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
Realiza un programa en Java que pida por teclado el nombre y la edad de una persona mayor de edad (se debe validar el valor introducido) y responda indicando:

Si no está jubilado (edad de jubilación = 65 años), cuántos años le quedan para jubilarse.
Si ya está jubilada indicará cuántos años lleva jubilado.
*/

public class Ejercicio102 {
    static Scanner sc = new Scanner(System.in);
    static final int EDAD_JUBILACION = 65;

    public static int pedirEdad(){
        int edad = 0;
        System.out.println("Introduce tu edad: ");
        while (true){
            sc = new Scanner(System.in);
            try {
                edad = sc.nextInt();
                if (edad >= 18){
                    break;
                }else System.out.println("Eres menor de edad, para pode acceder al programa debes ser mayor de 18, introduce tu edad: ");
            }catch (InputMismatchException ex){
                System.out.println("El dato introducido debe ser un numero");
            }
        }
        return edad;
    }

    public static void comprobarJubilacion(int edad){
        int diferencia = 0;
        if (EDAD_JUBILACION > edad){
            diferencia = EDAD_JUBILACION - edad;
            System.out.println("Le quedan: " + diferencia + " años para jubilarse");
        }else if (EDAD_JUBILACION == edad){
            System.out.println("Usted acaba de jubilarse");
        }else {
            diferencia = edad - EDAD_JUBILACION;
            System.out.println("Lleva jubilado: " + diferencia + " años");
        }

    }
}

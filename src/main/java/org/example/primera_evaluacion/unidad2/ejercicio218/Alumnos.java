package org.example.primera_evaluacion.unidad2.ejercicio218;


/*Dado el archivo binario alumnos.dat que tiene el siguiente contenido:

        Apellido "FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"
        Edad 17, 20, 18, 17, 19, 21, 20
        Nota 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9

        Desarrolla un programa Java que permita:

        Convertir el archivo binario a un archivo XML llamado alumnos.xml utilizando DOM.
        Visualizar el archivo alumnos.xml utilizando DOM.
        Visualizar el archivo alumnos.xml utilizando SAX.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Alumnos {
    public static void main(String[] args) {
        LecturaArchivos.leerArchivo();


    }
}

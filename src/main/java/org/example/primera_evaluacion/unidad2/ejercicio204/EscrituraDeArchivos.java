package org.example.primera_evaluacion.unidad2.ejercicio204;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Desarrolla un programa Java que permita crea un directorio vacío en la ruta dada.
// Podéis usar la siguiente ruta si estáis en Windows C:\\Users\\Antonio\\Descargas\\ficheros,
// si usáis Linux: /home/usuario/Descargas/ficheros o bien podéis usar la ruta que queráis.

public class EscrituraDeArchivos {
    File file = new File(".\\files\\file2");

    String texto = "Texto a escribir";
    public void escribirArchivo(){
        try(FileWriter escritor = new FileWriter(file)) {
            escritor.write(texto);
            escritor.close();
            System.out.println("El archivo " + file +" se ha escrito correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo");
        }
        }

    }


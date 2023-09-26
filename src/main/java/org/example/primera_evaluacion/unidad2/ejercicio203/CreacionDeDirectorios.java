package org.example.primera_evaluacion.unidad2.ejercicio203;

import java.io.File;

//Desarrolla un programa Java que permita crea un directorio vacío en la ruta dada.
// Podéis usar la siguiente ruta si estáis en Windows C:\\Users\\Antonio\\Descargas\\ficheros,
// si usáis Linux: /home/usuario/Descargas/ficheros o bien podéis usar la ruta que queráis.

public class CreacionDeDirectorios {
    public void crearDirectorio(){
        File file = new File(".\\files\\carpeta_vacia");
        file.mkdir();
        }

    }


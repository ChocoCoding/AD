package org.example.primera_evaluacion.unidad2.ejercicio210;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        FicheroTexto ficheroTexto = new FicheroTexto();

        try {
            ficheroTexto.escribir("HOLA");
            ficheroTexto.leer();
        }
        catch (IOException e) {
            System.out.println("Se ha generado una IOEx");
        }
    }
}

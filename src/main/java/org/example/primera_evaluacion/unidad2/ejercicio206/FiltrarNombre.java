package org.example.primera_evaluacion.unidad2.ejercicio206;
//Utilizando la interfaz FilenameFilter realiza los siguientes apartados:
//
//Crear una clase FiltrarNombre que implemente el siguiente método:
//
//filtrar(String ruta, String extension): lista solo aquellos archivos
// de la ruta que tienen una determinada extension
//Crear una clase FiltrarTamano que implemente el siguiente método:
//
//filtrar(String ruta, float minTamano): lista solo aquellos archivos
// de la ruta que tienen un tamaño mayor que el especificado.
//Realizar un programa main que permita comprobar el funcionamiento
// de los métodos anteriores

import java.io.File;
import java.io.FilenameFilter;

public class FiltrarNombre implements FilenameFilter {

    String ruta = "C:\\Users\\a16gonzalocd\\IdeaProjects\\AD\\files\\hola";

    String extension = ".txt";

    public void filtrar(String ruta, String extension){
       File file = new File(ruta);
       File[] archivos = file.listFiles();
        for (File f: archivos) {
            if (accept(f,f.getName())){
                System.out.println(f.getName());
            }
        }

    }



    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(".txt");
    }
}

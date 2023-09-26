package org.example.primera_evaluacion.unidad2.ejercicio202;

import java.io.File;

//Desarrolla un programa Java que permita enumerar todos los ficheros y subdirectorios que tiene un directorio dado.
public class EnumerarFicheros {
    public void EnumerarFicherosYSub(){
        File file = new File(".\\files");
        File fileEnCarpeta = null;
        File[] files = file.listFiles();
        for (File archivo : files) {
            System.out.println(archivo.getName());
            if (archivo.isDirectory()){
                fileEnCarpeta = archivo;
                File[] filesEnCarpeta = fileEnCarpeta.listFiles();
                if (filesEnCarpeta != null){
                    for (File archivoEnCarpeta: filesEnCarpeta) {
                        System.out.println("> " + archivoEnCarpeta.getName());
                    }
                }
            }
        }

    }
}

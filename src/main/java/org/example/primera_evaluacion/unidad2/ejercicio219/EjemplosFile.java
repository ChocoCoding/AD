package org.example.primera_evaluacion.unidad2.ejercicio219;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

public class EjemplosFile {

    public static void crearFichero(String ruta){
        File file = new File(ruta);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void borrarFichero(String ruta){
        File file = new File(ruta);
        if (!file.exists()){
            System.out.println("El fichero no existe");
        }else {
            file.delete();
            System.out.println("El fichero ha sido eliminado con éxito");
        }
    }

    public static void copiar(String origen, String destino){
        File fOrigen = new File(origen);
        File fDestino = new File(destino);

        try {
            if (!fDestino.exists()){
                Files.copy(fOrigen.toPath(), fDestino.toPath());
            }else System.out.println("El destino ya existe");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getFileInfo(String ruta){
        File file = new File(ruta);
        Date date = new Date(file.lastModified());
        System.out.println("Nombre del fichero: " + file.getName());
        System.out.println("Ruta absoluta: " + file.getAbsoluteFile());
        System.out.println("Fecha de última modificación: " + date);
        System.out.println("Tamaño del fichero en KB: " + file.length() *1.0/1000.0);

    }
}

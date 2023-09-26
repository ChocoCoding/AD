package org.example.primera_evaluacion.unidad2.ejercicio201;
//La clase File tiene tres constructores
//
//File(String path)
//File(String path, String name)
//File(File dir, String name)
//El parámetro path indica el camino hacia el directorio donde se encuentra el archivo,
// y name indica el nombre del archivo. Los métodos más importantes que describe esta clase son los siguientes:
//Nombre	Descripción                                                                                                         Parámetros	                            Dato devuelto
//exists	Indica si existe o no el fichero.                                                                                   Ninguno.	                            boolean
//isDirectory	Indica si el objeto File es un directorio.                                                                      Ninguno.	                            boolean
//isFile	Indica si el objeto File es un fichero.	                                                                            Ninguno.	                            boolean
//isHidden	Indica si el objeto File esta oculto.	                                                                            Ninguno.	                            boolean
//getAbsolutePath	Devuelve una cadena con la ruta absoluta del fichero o directorio.	                                        Ninguno.	                            String
//canRead	Indica si se puede leer.	                                                                                        Ninguno.	                            boolean
//canWrite	Indica si se puede escribir.	                                                                                    Ninguno.                                boolean
//canExecute	Indica si se puede ejecutar.	                                                                                Ninguno.	                            boolean
//getName	Devuelve una cadena con el nombre del fichero o directorio.	                                                        Ninguno.	                            String
//getParent	Devuelve una cadena con el directorio padre.	                                                                    Ninguno.	                            String
//listFiles	Devuelve un array de File con los directorios hijos. Solo funciona con directorios.	                                Ninguno.	                            Array de File
//list	Devuelve un array de String con los directorios hijos. Solo funciona con directorios.	                                Ninguno.	                            Array de String
//mkdir	Permite crear el directorio en la ruta indicada. Solo se creara si no existe.	                                        Ninguno.	                            boolean
//mkdirs	Permite crear el directorio en la ruta indicada, también crea los directorios intermedios.
// Solo se creara si no existe.	                                                                                                Ninguno.	                            boolean
//createNewFile	Permite crear el fichero en la ruta indicada. Solo se creara si no existe.
// Debemos controlar la excepcion con IOException.	                                                                            Ninguno.	                            boolean


import java.io.File;
import java.io.IOException;

//Desarrolla un programa Java que permita mostrar por pantalla
// la siguiente información de un fichero o de un directorio:
//
//Nombre
//Ruta relativa
//Ruta absoluta
//Si permite lectura
//Si permite escritura
//Su tamaño
//Si es un fichero o no
public class InformacionFichero {
public void metodosDeFile(){
    File file = new File(".\\files\\ejercicio201.txt");
    crearArchivo(file);
    System.out.println("Nombre del fichero: " + file.getName());
    System.out.println("Ruta relativa del fichero: " + file);
    System.out.println("Ruta absoluta del fichero: " + file.getAbsoluteFile());
    if (file.canRead()){
        System.out.println("Permite lectura");
    }else System.out.println("No permite lectura");
    if (file.canWrite()){
        System.out.println("Permite escritura");
    }else System.out.println("No permite escritura");
    System.out.println("Tamaño del File: " + file.length() + "KB");
    if (file.isFile()){
        System.out.println("Es un fichero");
    }else System.out.println("Es un directorio");
}

    private void crearArchivo(File file) {
        try {
            if (!file.exists()){
                file.createNewFile();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

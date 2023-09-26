package org.example.primera_evaluacion.unidad2.ejercicio205;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Desarrolla un programa Java que defina una clase ManejoFicheros que implemente los siguientes métodos:
//
//void crearFichero(String fichero): crea el fichero indicado
//
//void borrarFichero(String fichero): borra el fichero indicado.
//
//void crearDirectorio(String ruta): crea el directorio indicado.
//
//void borrarDirectorio(String ruta): borra el directorio indicado.
//
//void listarDirectorio(String ruta): lista el contenido del directorio
//
//Clase main que permita comprobar el funcionamiento de los métodos anteriores.
//
//Nota: usa la clase File para realizar el ejercicio
public class ManejoFicheros {
    Scanner sc = new Scanner(System.in);
    String entrada = "";
    public void menu(){
        String fichero = "";
        do{
            System.out.println("Selecciona una opcion o [Introduce 'Salir' para terminar el programa]");
            System.out.println("1.---Crear un fichero");
            System.out.println("2.---Borra un fichero");
            System.out.println("3.---Crear un directorio");
            System.out.println("4.---Borra un directorio");
            System.out.println("5.---Lista el contenido de un directorio");
            entrada = sc.next();

            switch (entrada){
                case "1":
                    System.out.println("Introduce la ruta del fichero: ");
                    fichero =sc.next();
                    crearFichero(fichero);
                    break;
                case "2":
                    System.out.println("Introduce la ruta del fichero a eliminar: ");
                    fichero =sc.next();
                    borrarFichero(fichero);
                    break;
                case "3":
                    System.out.println("Introduce la ruta del directorio a crear");
                    fichero =sc.next();
                    crearDirectorio(fichero);
                    break;
                case "4":
                    System.out.println("Introduce la ruta del directorio a eliminar");
                    fichero =sc.next();
                    eliminarDirectorio(fichero);
                    break;
                case "5":
                    System.out.println("Introduce la ruta del directorio para ver su contenido");
                    fichero =sc.next();
                    listarDirectorio(fichero);
            }

        }while(!entrada.equalsIgnoreCase("Salir"));

    }

    private void listarDirectorio(String fichero) {
        File file = new File(fichero);
        File[] files = file.listFiles();
        if (file.exists()){
            for (File f: files) {
                System.out.println(f.getName());
            }
        }else System.out.println("El directorio no existe");
    }

    private void eliminarDirectorio(String fichero) {
        File file = new File(fichero);
        File[] files = file.listFiles();
        String respuesta = "";
        if (file.exists()){
            assert files != null;
            if (files.length > 0){
                System.out.println("La carpeta tiene archivos dentro, ¿Deseas eliminar los archivos y la carpeta? SI/NO");
                respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("si")){
                    for (File f: files) {
                        f.delete();
                        System.out.println("Se ha eliminado el archivo: " + f.getName());
                    }
                    file.delete();
                    System.out.println("Se ha eliminardo la carpeta: " + file.getName());
                }else if (respuesta.equalsIgnoreCase("no")){
                    System.out.println("No se ha eliminado la carpeta");
                }else System.out.println("La respuesta introducida no es correcta");
            }else file.delete();

        }else System.out.println("El fichero no existe");
    }

    private void crearDirectorio(String fichero) {
        File file = new File(fichero);
        if (!file.exists()){
            file.mkdir();
            System.out.println("Se ha creado la carpeta correctamente");
        }else System.out.println("El directorio ya existe");

    }

    public void borrarFichero(String fichero){
        File file = new File(fichero);
        if (file.exists()){
            file.delete();
            System.out.println("Se ha eliminado correctamente el archivo");
        }else System.out.println("El archivo no existe");
    }


    void crearFichero(String fichero){
        File file = new File(fichero);
        if (!file.exists()){
            try {
                if (file.createNewFile()){
                    System.out.println("Se ha creado el fichero en " + file.getAbsolutePath());
                }else System.out.println("No se ha podido crear el fichero");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else System.out.println("El nombre del fichero ya existe en la ruta especificada");
    }
}

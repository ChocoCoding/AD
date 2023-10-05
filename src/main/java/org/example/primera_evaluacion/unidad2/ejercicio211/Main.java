package org.example.primera_evaluacion.unidad2.ejercicio211;

import java.io.File;
import java.io.IOException;

////Además, debes implementar un método main que haga lo siguiente:
////
////Crear una persona.
////Crear un fichero persona.txt.
////Escribir los datos de la persona en el fichero.
////Leer los datos y almacenarlos en un objeto diferente.
////Mostrar por consola los datos recuperados.
public class Main {
    public static void main(String[] args) {
        File file = new File(".\\files\\ejercicio211\\archivo.txt");
        Persona persona1 = new Persona("Paco",25);

        SerializarPersona serializarPersona = new SerializarPersona();
        try {
            serializarPersona.escribirPersonaEnFichero(persona1,file);
            serializarPersona.escribirPersonaEnFichero(new Persona("Maria",55),file);
            Persona persona2 = serializarPersona.leerPersonaDeFichero(file);
            System.out.println(persona2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

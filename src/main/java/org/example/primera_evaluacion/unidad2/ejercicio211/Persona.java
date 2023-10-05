package org.example.primera_evaluacion.unidad2.ejercicio211;
//Crea una clase Persona, que tenga las siguientes características:
//
//Dos atributos nombre y edad.
//Getters y setters.
//Constructor con dos parámetros.
//Que la clase sea serializable.


import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private int edad;


    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
}

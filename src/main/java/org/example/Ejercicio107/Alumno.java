package org.example.Ejercicio107;

import java.util.HashMap;
import java.util.Map;

public class Alumno {
    private String nombre;
    private Map<String, Integer> moduloNota;

    public Alumno(String nombre, Map<String, Integer> moduloNota) {
        this.nombre = nombre;
        this.moduloNota = moduloNota;
    }

    public String getNombre() {
        return nombre;
    }

    public Map<String, Integer> getModuloNota() {
        return moduloNota;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alumno{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", moduloNota=").append(moduloNota);
        sb.append('}');
        return sb.toString();
    }
}

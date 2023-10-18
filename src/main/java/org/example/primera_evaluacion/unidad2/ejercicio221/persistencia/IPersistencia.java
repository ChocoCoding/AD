package org.example.primera_evaluacion.unidad2.ejercicio221.persistencia;

import org.example.primera_evaluacion.unidad2.ejercicio221.teis.Persona;

public interface IPersistencia {

    void escribirPersona(Persona persona, String ruta);

    Persona leerDatos(String ruta);


}

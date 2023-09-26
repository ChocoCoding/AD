package org.example.primera_evaluacion.unidad1.Ejercicio101;


import java.util.ArrayList;
import java.util.List;

/**Realiza un programa en Java que usando una variable estática*/

public class Ejercicio101 {
    static String texto = "4;5;7;8;4";

    public static int separarYSumarNumeros(){
        int suma = 0;

        String[] numeros = texto.split(";");
        for (String num:numeros) {
            suma += Integer.parseInt(num);
        }
        return suma;
    }
}

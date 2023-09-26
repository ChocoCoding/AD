package org.example.primera_evaluacion.unidad1.Ejercicio109;

import java.util.HashSet;

public class EliminarDuplicadosArray {

    public static void main(String[] args) {
        int[] entrada = {20, 20, 30, 40, 50, 50, 50};
        HashSet<Integer> salida = new HashSet<>();
        for (int i = 0; i< entrada.length; i++){
            salida.add(entrada[i]);
        }
        System.out.println(salida.size());
        }

    }




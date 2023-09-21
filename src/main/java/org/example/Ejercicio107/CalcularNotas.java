package org.example.Ejercicio107;

import com.sun.source.tree.NewArrayTree;

import java.util.HashMap;
import java.util.Map;

public class CalcularNotas {

    String entrada = "Nombre_Alumno# LMSXI # SI # BD # PRO # CD # FOL;Alumno 1  # 4     #    # 5  #  2  # 8  # 9;Alumno 2     # 5     # 3  # 6  #  7  # 10 # 6;Alumno 3     # 7     # 4  # 9  #  9  # 9  # 8;";
    Map<String,Integer> notasAlumnos = new HashMap<>();
    Map<String,Map<String,Integer>> nombresAlumnosModulosYNotas = new HashMap<>();
    public void divirEnLineas(){

        // Dividir la entrada en líneas y separar por "#"
        String[] lineas = entrada.split(";");
        String[] nombresModulos = lineas[0].split("#");

        // Crear un mapa para almacenar las notas de cada módulo
        Map<String, Double> notaModulo = new HashMap<>();
        Map<String, Integer> contadorModulo = new HashMap<>();

        // Inicializar el mapa con 0 para todas las notas
        for (int i = 1; i < nombresModulos.length; i++) {
            notaModulo.put(nombresModulos[i].trim(), 0.0);
            contadorModulo.put(nombresModulos[i].trim(), 0);

        }


        // Procesar las notas de cada alumno
        for (int i = 1; i < lineas.length; i++) {
            String[] campos = lineas[i].split("#");
            for (int j = 1; j < campos.length; j++) {
                String modulo = nombresModulos[j].trim();
                String notaStr = campos[j].trim();
                if (!notaStr.isEmpty()) {
                    double nota = Double.parseDouble(notaStr);
                    notaModulo.put(modulo, notaModulo.get(modulo) + nota);
                    contadorModulo.put(modulo, contadorModulo.get(modulo) + 1);
                }
            }
        }

        // Calcular la nota media de cada módulo
        System.out.println("Nota media de cada módulo:");
        for (int i = 1; i < nombresModulos.length; i++) {
            String modulo = nombresModulos[i].trim();
            int contador = contadorModulo.get(modulo);
            double notaMedia = contador > 0 ? notaModulo.get(modulo) / contador : 0.0;
            System.out.println(modulo + ": " + notaMedia);
        }

        // Calcular la nota media de cada alumno en el ciclo
        System.out.println("\nNota media de cada alumno en el ciclo:");
        for (int i = 1; i < lineas.length; i++) {
            String[] campos = lineas[i].split("#");
            String nombreAlumno = campos[0].trim();
            double sumaNotas = 0.0;
            int contador = 0;
            for (int j = 1; j < campos.length; j++) {
                String notaStr = campos[j].trim();
                if (!notaStr.isEmpty()) {
                    sumaNotas += Double.parseDouble(notaStr);
                    contador++;
                }
            }
            double notaMediaAlumno = contador > 0 ? sumaNotas / contador : 0.0;
            System.out.println(nombreAlumno + ": " + notaMediaAlumno);
        }
    }

    }



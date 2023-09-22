package org.example.Ejercicio107;

import java.sql.SQLOutput;
import java.util.*;

public class NotasAlumnos {
    String entrada = "Nombre_Alumno# LMSXI # SI # BD # PRO # CD # FOL;Alumno 1  # 4     #    # 5  #  2  # 8  # 9;Alumno 2     # 5     # 3  # 6  #  7  # 10 # 6;Alumno 3     # 7     # 4  # 9  #  9  # 9  # 8;";
    List<Alumno> alumnos;
    
    public void trocearEntradaYCrearAlumnos() {
        //Obtenemos las lineas de la entrada
        String[] lineas = entrada.split(";");
        String[] partes;
        String[] modulos;
        String modulo = "";
        String nombreAlumno = "";
        Map<String, Integer> modulosNotas;
        Alumno alumno = null;
        alumnos = new ArrayList<>();

        int nota = 0;
        for (int x = 1; x < lineas.length; x++) {
            modulosNotas = new LinkedHashMap<>();
            //Obtenemos cada una de las partes: MODULOS + Alumno + notas
            partes = lineas[x].split("#");
            modulos = lineas[0].split("#");
            nombreAlumno = partes[0].trim();

            for (int j = 1; j < partes.length; j++) {
                modulo = modulos[j].trim();
                if (!partes[j].trim().isEmpty()) {
                    nota = Integer.parseInt(partes[j].trim());
                    //Metemos clave valor en el hashmap
                    modulosNotas.put(modulo, nota);
                } else {
                    nota = -1;
                    modulosNotas.put(modulo, -1);
                }
            }
            alumno = new Alumno(nombreAlumno,modulosNotas);
            //Añadimos los alumnos al arraylist
            alumnos.add(alumno);
        }
    }

    public void calcularAlumnoConNotaMasAltaPorModulo(){
        double contadorModulos = 0;
        String nombreModulo = "";
        int contador = 0;
        String nombreAlumno = "";
        //Recorremos el numero de modulos
        for (Map.Entry<String,Integer> entry : alumnos.get(0).getModuloNota().entrySet()) {
            int notaMasAlta = 0;
            nombreModulo = entry.getKey();
            contador = 0;
            for (Alumno alum : alumnos) {
                //Filtramos por el nombre del modulo
                if (alum.getModuloNota().get(nombreModulo) > notaMasAlta){
                    nombreAlumno = alum.getNombre();
                    notaMasAlta = alum.getModuloNota().get(nombreModulo);
                }
            }
            System.out.println("La nota mas alta del módulo: " + nombreModulo + " es del alumno: " + nombreAlumno + " con un: " + notaMasAlta);
        }
    }


    public void calcularMediaMasAlta() {
        double suma = 0;
        double contadorModulos = 0;
        double media = 0.0;
        String nombreModulo = "";
        int contador = 0;
        //Recorremos el numero de modulos
        for (Map.Entry<String, Integer> entry : alumnos.get(0).getModuloNota().entrySet()) {
            nombreModulo = entry.getKey();
            contador = 0;
            suma = 0;
            for (Alumno alum : alumnos) {
                //Filtramos por el nombre del modulo
                if (alum.getModuloNota().containsKey(nombreModulo)) {
                    //Comprobamos que es distinto de -1
                    if (alum.getModuloNota().get(nombreModulo) != -1) {
                        contador++;
                        suma += alum.getModuloNota().get(nombreModulo);
                    }
                }
            }
            if (media < suma / contador) {
                media = suma / contador;
            }
        }
        System.out.println("La media mas alta es: "  + media);
    }

    public void calcularAlumnosAprobados() {
        double suma = 0;
        String nombreModulo = "";
        int totalModulosMatriculado = alumnos.get(0).getModuloNota().size();
        int contadorModulosAprobados = 0;
        int contadorTotalAlumnosAprobados = 0;

        for (Alumno alum : alumnos) {
             totalModulosMatriculado = alumnos.get(0).getModuloNota().size();
             contadorModulosAprobados = 0;
             contadorTotalAlumnosAprobados = 0;
            //Filtramos por el nombre del modulo
            for (Map.Entry<String, Integer> entry : alumnos.get(0).getModuloNota().entrySet()) {
                nombreModulo = entry.getKey();
                if (alum.getModuloNota().get(nombreModulo) != -1) {
                    if (alum.getModuloNota().get(nombreModulo) >= 5){
                        contadorModulosAprobados++;
                    }

                }else totalModulosMatriculado -= 1;
            }
            if (contadorModulosAprobados == totalModulosMatriculado){
                contadorTotalAlumnosAprobados +=1;
            }
        }
        System.out.println("Alumnos con todos los módulos aprobados: " + contadorTotalAlumnosAprobados);

    }

    public void calcularAlumnosQueNoHanCursadoAlgunModulo(){
        String nombreModulo;
        int contadorAlumnosSinModulo = 0;
        for (Alumno alum : alumnos){
            for (Map.Entry<String, Integer> entry : alumnos.get(0).getModuloNota().entrySet()) {
                nombreModulo = entry.getKey();
                if (alum.getModuloNota().get(nombreModulo) == -1){
                    contadorAlumnosSinModulo += 1;
                }

            }
        }
        System.out.println("El numero de alumnos que no han cursado algun modulo es: " + contadorAlumnosSinModulo);

    }

    public void calcularMediaModulos() {
        double suma = 0;
        double contadorModulos = 0;
        double media = 0.0;
        String nombreModulo = "";
        int contador = 0;
        //Recorremos el numero de modulos
        for (Map.Entry<String,Integer> entry : alumnos.get(0).getModuloNota().entrySet()){
            nombreModulo = entry.getKey();
            contador = 0;
            suma = 0;
            for (Alumno alum : alumnos) {
                //Filtramos por el nombre del modulo
                if (alum.getModuloNota().containsKey(nombreModulo)){
                    //Comprobamos que es distinto de -1
                    if (alum.getModuloNota().get(nombreModulo) != -1){
                        contador++;
                        suma += alum.getModuloNota().get(nombreModulo);
                    }
                }
            }
        media = suma / contador;
        System.out.println("La media del módulo: " + entry.getKey() + " es : " + media);
        }

    }

    public void calcularMedia() {
        double suma = 0;
        double contador = 0;
        double media = 0.0;
        for (Alumno alum: alumnos) {
            contador = 0;
            suma = 0;
            for (String clave : alum.getModuloNota().keySet()) {
                int valor = alum.getModuloNota().get(clave);
                if (valor != -1) {
                    contador++;
                    suma += valor;
                }
            }
            media = suma / contador;
            System.out.println("La media del alumno: " + alum.getNombre() + " es: " + media);
        }
    }
}

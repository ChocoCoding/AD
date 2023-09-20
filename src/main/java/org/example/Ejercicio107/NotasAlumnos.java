package org.example.Ejercicio107;

import javax.print.MultiDoc;
import java.util.HashMap;
import java.util.Map;

public class NotasAlumnos {
    String entrada = "Nombre_Alumno# LMSXI # SI # BD # PRO # CD # FOL;Alumno 1  # 4     #    # 5  #  2  # 8  # 9;Alumno 2     # 5     # 3  # 6  #  7  # 10 # 6;Alumno 3     # 7     # 4  # 9  #  9  # 9  # 8;";

    public void trocearEntrada(){
        //Obtenemos las lineas de la entrada
        String[] lineas = entrada.split(";");
        String[] partes;
        String[] modulos;
        String modulo = "";
        String nombreAlumno = "";
        Map<String,Integer> modulosNotas;
        Alumno alumno = null;

        int nota = 0;
        for (int x = 1; x < lineas.length; x++){
            modulosNotas = new HashMap<>();
            //Obtenemos cada una de las partes: MODULOS + Alumno + notas
            partes = lineas[x].split("#");
            modulos = lineas[0].split("#");

            nombreAlumno = partes[0].trim();

            for (int j = 1; j < partes.length; j++){
             if (!partes[j].trim().isEmpty()){
                nota = Integer.parseInt(partes[j].trim());
                modulo = modulos[j].trim();
                //Metemos clave valor en el hashmap
                 modulosNotas.put(modulo,nota);
             }else {
                 nota = -1;
                 modulosNotas.put(modulo,nota);

             }
             alumno = new Alumno(nombreAlumno,modulosNotas);

            }
            calcularMedia(alumno);

        }
        
        
    }

    public void calcularMedia(Alumno alumno){
        double suma = 0;
        double contador = 0;
        double media = 0.0;
        for (String clave:alumno.getModuloNota().keySet()) {
            int valor = alumno.getModuloNota().get(clave);
            if (valor != -1){
                System.out.println(alumno.getModuloNota());
                contador ++;
                suma += valor;
            }
        }
        //TODO LA MEDIA ESTA MAL
        System.out.println(suma);
        System.out.println("contador : " + contador);
        media = suma / contador;
        System.out.println("Medias alumnos");
        System.out.println("La media de " + alumno.getNombre() + " es " + media);
    }

}

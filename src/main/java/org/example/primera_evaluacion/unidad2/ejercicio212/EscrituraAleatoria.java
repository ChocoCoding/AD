package org.example.primera_evaluacion.unidad2.ejercicio212;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//Desarrolla un programa Java que permita:
//
//Escribir en un fichero binario alumnos.dat de forma aleatoria la siguiente información:
//
//Apellido "FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"
//Edad 17, 20, 18, 17, 19, 21, 20
//Nota 7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9
//
//Visualizar el contenido del fichero anterior de forma aleatoria.
public class EscrituraAleatoria {
    public void escribirDeFormaAleatoriaUnFichero() throws IOException {
        File file = new File(".\\files\\ejercicio212\\alumnos.dat");
        String[] apellidos = {"FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"};
        int[] edades = {17, 20, 18, 17, 19, 21, 20};
        double[] notas = {7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};

            RandomAccessFile raf = new RandomAccessFile(file,"rw");

            //Posicionar el puntero
            raf.seek(200);

            //Conseguir la posicion del archivo
            long position = raf.getFilePointer();
            System.out.println("Posicion del archivo: " + position);

            //Leer bytes de un archivo (Devuelve el siguiente byte y "-1" si esta vacio)
            int aByte = raf.read();
            System.out.println(aByte);

            //Leer un array de bytes
            byte[] dest      = new byte[1024];
            int    offset    = 0;
            int    length    = 1024;
            int    bytesRead = raf.read(dest, offset, length);

            //Write Byte to a RandomAccessFile
            raf.write(65); // ASCII code for A


    }

    public static void main(String[] args) throws IOException {
        File file = new File(".\\files\\ejercicio212\\alumnos.dat");
        String[] apellidos = {"FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"};
        int[] edades = {17, 20, 18, 17, 19, 21, 20};
        double[] notas = {7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};

        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        byte[] bytes = "Hello World".getBytes("UTF-8");
        raf.write(bytes, 2, 5);
        List<Byte> bytes1 = new ArrayList<>();

        ByteArrayOutputStream escribir = new ByteArrayOutputStream();
        
    }
}

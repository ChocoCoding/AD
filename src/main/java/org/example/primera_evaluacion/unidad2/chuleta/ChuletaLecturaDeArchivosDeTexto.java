package org.example.primera_evaluacion.unidad2.chuleta;

import java.io.*;

public class ChuletaLecturaDeArchivosDeTexto {
    public static void main(String[] args) {
        //lecturaConFileReader();
        //escrituraConFileWriter();
        //escrituraConBufferedWriter();
        //lecturaConBufferedReader();


    }

    /**
     ************** BufferedWriter *************
     *  FICHEROS DE TEXTO
     *  Escritura de un fichero de texto en java con BufferedWriter
     * -Permite leer por lineas
     * -Bucle hasta que readLine() != null
     * *************************************
     */
    private static void escrituraConBufferedWriter() {
        File file = new File(".\\files\\chuleta\\file_reader.txt");
        try (FileWriter fr = new FileWriter(file,true);BufferedWriter bw = new BufferedWriter(fr)) {
            bw.write("Hola mundo");
            bw.write(55);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    /**
     ************** BufferedReader *************
     *  FICHEROS DE TEXTO
     *  Lectura de un fichero de texto en java con BufferedReader
     * -Permite leer por lineas
     * -Bucle hasta que readLine() != null
     * *************************************
     */
    private static void lecturaConBufferedReader() {
        File file = new File(".\\files\\chuleta\\file_reader.txt");
        try(FileReader fr = new FileReader(file);
            BufferedReader br  = new BufferedReader(fr)){
            String linea = "";
            while ((linea = br.readLine()) != null){
                System.out.println(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     ************** FileWriter *************
     *  FICHEROS DE TEXTO
     *  Escritura de un fichero de texto en java con FileWriter
     * -Escribe datos primitivos
     * -Permite append
     * -NO RECOMENDABLE PARA ESCRIBIR YA QUE ESCRITE CARAACTERES PROPIOS
     * *************************************
     */
    private static void escrituraConFileWriter() {
        File file = new File(".\\files\\chuleta\\file_reader.txt");
        try (FileWriter fw = new FileWriter(file,true)) {
            char[] chars = {'a','b','c'};
                fw.write('A');
                fw.write("Hola");
                fw.write(5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




    /**
     ************** FileReader *************
     *  FICHEROS DE TEXTO
     *  Lectura de un fichero de texto en java con FileWriter
     * -Permite leer por caracteres
     * -Bucle hasta que read() =! -1
     * *************************************
     */
    private static void lecturaConFileReader() {
        File file = new File(".\\files\\chuleta\\file_reader.txt");
        try(FileReader fr = new FileReader(file)){
            int caracter = 0;
            while ((caracter = fr.read()) != -1){
                System.out.println((char) caracter);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}

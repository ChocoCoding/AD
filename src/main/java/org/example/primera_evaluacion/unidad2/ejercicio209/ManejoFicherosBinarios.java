package org.example.primera_evaluacion.unidad2.ejercicio209;

import java.io.*;

public class ManejoFicherosBinarios {
    static File origen = new File(".\\files\\ejercicio209\\origen.bin");
    static File destino = new File(".\\files\\ejercicio209\\destino.bin");

    public static void main(String[] args) {
        String text = "ESTE ES EL TEXTO DE ORIGEN";
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream(origen);
            dos = new DataOutputStream(fos);

            dos.writeUTF(text);
            dos.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }

        DataInputStream dis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(origen);
            dis = new DataInputStream(fis);

            String linea = "";
            while (true){
                linea = dis.readUTF();
                System.out.println(linea);
            }
        }catch (EOFException eof){
            try {
                dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fis = new FileInputStream(origen);
            fos = new FileOutputStream(destino);
            dis = new DataInputStream(fis);
            dos = new DataOutputStream(fos);

            String linea = "";
            while (true){
                linea = dis.readUTF();
                dos.writeUTF(linea);
                System.out.println("Linea: " + linea);
            }

        }catch (EOFException eof){
            try {
                fis.close();
                dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        catch (FileNotFoundException f){
            System.out.println("No se ha encontrado el archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

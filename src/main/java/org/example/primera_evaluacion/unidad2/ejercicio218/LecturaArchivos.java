package org.example.primera_evaluacion.unidad2.ejercicio218;

import java.io.*;

public class LecturaArchivos {
    static File file = new File(".\\files\\ejercicio218\\alumnos.dat");

    public static void main(String[] args) {
        leerArchivo();
    }

    public static void leerArchivo() {
        String apellido;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file,true))){
            int content = 0;
            String linea = "";
            dos.writeUTF("Patata");

            while (true){
                System.out.println(dis.readUTF());
            }



        }catch (EOFException eof){
            System.out.println("Fin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
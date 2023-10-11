package org.example.primera_evaluacion.unidad2.ejercicio218;

import java.io.*;

public class LecturaArchivos {
    static File file = new File(".\\files\\ejercicio218\\alumnos.dat");

    public static void leerArchivo() {
        String apellido;
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            int content = 0;
            String linea = "";
            while ((content = dis.read()) != -1){
                linea = dis.readLine();
                System.out.println(linea);

            }



        }catch (EOFException eof){
            System.out.println("Fin");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
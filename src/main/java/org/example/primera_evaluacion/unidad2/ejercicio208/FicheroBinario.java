package org.example.primera_evaluacion.unidad2.ejercicio208;
//Desarrolla un programa Java que permita:
//
//Escribir en un fichero binario Empleados.dat de manera secuencial, la siguiente información:
//
//Departamento "Contabilidad","Informática","Dirección","Análisis","Finanzas","Hardware"
//Nª Empleados 3,10,2,5,4,8
//
//Mostrar la información del fichero anterior de forma secuencial.

import java.io.*;
import java.lang.reflect.Array;

public class FicheroBinario {

    File file = new File(".\\files\\empleados.dat");

    String[] deps = {"Contabilidad","Informática","Dirección","Análisis","Finanzas","Hardware"};
    int[] emps = {3,10,2,5,4,8};

    public void escribirEnFicheroBinario(){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos = new DataOutputStream(fos);

            for (int x = 0; x <= deps.length; x++){
                dos.writeUTF(deps[x]);
                dos.writeInt(emps[x]);
            }
            //Cerramos la conexion
            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void leerFicheros(){
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            String nombreDep = "";
            int numEmp = 0;
            while (true){
                nombreDep = dis.readUTF();
                numEmp = dis.readInt();
                //Mostramos por pantalla los departamentos y el numero de empleados
                System.out.println("El departamento: " + nombreDep + " tiene: " + numEmp + " empleados");
            }

        }catch (EOFException eo){
            try {
                dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}

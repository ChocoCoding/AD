package org.example.primera_evaluacion.unidad2.ejercicio220.config;

import java.io.*;
import java.util.HashMap;

public class Config {
    public static void crearConfigFile(HashMap<String, String> mapa, String rutaFichero){
        File file = new File(rutaFichero);
        if (!file.exists()){
            try {
                file.createNewFile();
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));

                for (String clave : mapa.keySet()) {
                    String valor = mapa.get(clave);
                    dos.writeUTF(clave + "=" + valor + "\n");
                }
                dos.close();
                System.out.println("El fichero " + file.getName() + " se ha creado con éxito");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else System.out.println("El fichero ya existe");

    }

    public static String leerConfig(String rutaFichero,String clave){
        File file = new File(rutaFichero);

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            String[] claveValor;
            boolean lineaEncontrada = false;
            String linea;
            while (true){
                linea= dis.readUTF();
                claveValor = linea.split("=");
                if (claveValor[0].equalsIgnoreCase(clave)){
                    lineaEncontrada = true;
                    return claveValor[1];
                }
            }

        }catch (EOFException eof){
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

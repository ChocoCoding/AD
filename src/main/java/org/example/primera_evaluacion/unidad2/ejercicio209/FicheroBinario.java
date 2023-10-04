package org.example.primera_evaluacion.unidad2.ejercicio209;

import java.io.*;

//Crea una clase FicheroBinario que represente a un fichero binario. La clase tendrá un atributo de tipo File, que almacenará el fichero correspondiente. Además, tendrá los siguientes métodos:
//
//Constructor.
//Getter.
//public void escribir(String texto): escribe en el propio fichero el texto pasado por parámetro.
//public void leer(): muestra por consola el contenido del fichero.
//public void copiar(FicheroBinario ficheroDestino): copia el contenido del fichero en el fichero de destino.
//NOTA: Debes usar las clases FileInputStream y FileOutputStream.
//
//A continuación, se pide crear una clase ManejoFicherosBinarios, que implemente el método main. En esta clase debes crear dos ficheros binarios origen.bin y destino.bin y hacer lo siguiente:
//
//Escribir en el fichero de origen el texto: ESTE ES EL TEXTO DE ORIGEN.
//Leer y mostrar el contenido del fichero por consola.
//Copia el contenido al fichero de destino.
public class FicheroBinario {
    private File fichero;

    public FicheroBinario(File ficheroBinario) {
        this.fichero = ficheroBinario;
    }

    public File getFichero() {
        return fichero;
    }

    public void escribir(String texto){
        try {
            FileOutputStream fos = new FileOutputStream(this.fichero);
            DataOutputStream dos = new DataOutputStream(fos);

            dos.writeUTF(texto);

            dos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void leer(){
        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(this.fichero);
            dis = new DataInputStream(fis);

            String lectura = "";
            while (true){
                lectura = dis.readUTF();
                System.out.println(lectura);
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

    public void copiar(FicheroBinario ficheroDestino){
        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(this.fichero);
            dis = new DataInputStream(fis);
            FileOutputStream fos = new FileOutputStream(ficheroDestino.getFichero());
            DataOutputStream dos = new DataOutputStream(fos);

            String lectura = "";
            while (true){
                lectura = dis.readUTF();
                dos.writeUTF(lectura);
                System.out.println(lectura);
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

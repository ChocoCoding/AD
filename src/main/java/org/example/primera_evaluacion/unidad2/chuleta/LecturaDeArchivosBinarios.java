package org.example.primera_evaluacion.unidad2.chuleta;

import java.io.*;
import java.util.Arrays;

public class LecturaDeArchivosBinarios {
    static File file = new File(".\\files\\chuleta\\fichero_binario.dat");
    static File salida = new File(".\\files\\chuleta\\salida.bin");


    public static void main(String[] args) {
        escribirFicheroBinario();
        //leerLineasFicheroBinario();
        //leerArchivoPorBytes();
        //leerConRamdomAccessFile();
    }

    private static void leerArchivoPorBytes() {
        try (FileInputStream fis = new FileInputStream(file)) {
            String linea = "";
            char letra = 0;
            byte[] arrayBytes = new byte[(int) file.length()];
            fis.read(arrayBytes);
            for (Byte b : arrayBytes) {
                //Lo transformamos en Strings
                letra = (char) b.intValue();
                linea += letra;
            }
            System.out.print(linea);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void leerConRamdomAccessFile() {
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            int id, edad, pos = 0;
            Double nota;
            char apellido[] = new char[10], aux;

            for (; ; ) {
                raf.seek(pos);

                for (int x = 0; x < apellido.length; x++) {

                    aux = raf.readChar();

                    apellido[x] = aux;
                    System.out.println(aux);

                    pos = pos + 36;

                    if (raf.getFilePointer() == file.length())
                        break;
                }
            }

        } catch (EOFException eof) {
            System.out.println("Fin del archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Para poder leer el contenido de un fichero binario debemos conocer la estructura interna del fichero,
     * es decir, debemos saber cómo se han escrito: si hay enteros, long, etc. y en qué orden están escritos en el fichero.
     * Si no se conoce su estructura podemos leerlo byte a byte
     */
    private static void leerLineasFicheroBinario() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            String linea = "";
            while (true) {
                System.out.println(dis.readUTF());
            }
        } catch (EOFException eof) {
            System.out.println("Fin del archivo");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void escribirFicheroBinario() {
        String[] apellidos = {"FERNANDEZ", "LOPEZ", "GOMEZ", "CHEN", "SERRANO", "CASILLAS", "ALONSO"};
        int[] edades = {17, 20, 18, 17, 19, 21, 20};
        double[] notas = {7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length());
            for (int x = 0; x < apellidos.length; x++) {
                raf.writeUTF(apellidos[x]);
                raf.writeInt(edades[x]);
                raf.writeDouble(notas[x]);
            }
            raf.seek(0);
            //Leemos el archivo
            String linea = "";
            while (true) {
                System.out.println(raf.readUTF());
                System.out.println(raf.readInt());
                System.out.println(raf.readDouble());
            }


        }catch (EOFException eof){
            System.out.println("Fin");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
package org.example.primera_evaluacion.unidad2.ejercicio212;

import java.io.IOException;
import java.io.RandomAccessFile;

class RandomAccessFileExample {

    public static void main(String[] args) {
        try {
            // file content is "ABCDEFGH"
            String filePath = ".\\files\\ejercicio212\\alumnos.dat";

            System.out.println(new String(readCharsFromFile(filePath, 5)));

            writeData(filePath, "Data", 10);
            //now file content is "ABCDEData"

            appendData(filePath, "hola mundo");
            //now file content is "ABCDEDatapankaj"
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendData(String filePath, String data) throws IOException {
        RandomAccessFile raFile = new RandomAccessFile(filePath, "rw");
        raFile.seek(raFile.length());
        System.out.println("current pointer = "+raFile.getFilePointer());
        raFile.write(data.getBytes());
        raFile.close();

    }

    private static void writeData(String filePath, String data, int seek) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "rw");
        file.seek(seek);
        file.write(data.getBytes());
        file.close();
    }

    private static byte[] readCharsFromFile(String filePath, int chars) throws IOException {
        RandomAccessFile file = new RandomAccessFile(filePath, "r");
        System.out.println(file.getFilePointer());
        file.write(2);
        file.seek(10);
        byte[] bytes = new byte[chars];
        file.read(bytes);
        file.close();
        return bytes;
    }

}
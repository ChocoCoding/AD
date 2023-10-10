package org.example.primera_evaluacion.unidad2.ejercicio210;

import java.io.*;

public class FicheroTexto {
    private File file = new File(".\\files\\ejercicio210\\fichero.txt");

    public FicheroTexto() {
    }

    public File getFile() {
        return file;
    }

    public void escribir(String texto){
        crearFichero(file);
        try(FileWriter fw = new FileWriter(file)) {
            fw.write(texto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void leer() throws IOException {
        File file = new File(".\\files\\ejercicio210\\fichero.txt");
        FileReader fr = new FileReader(file);
        int caracter;
            while ((caracter = fr.read()) != -1){
                System.out.println((char)caracter);
            }
    }

    private void crearFichero(File file) {
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

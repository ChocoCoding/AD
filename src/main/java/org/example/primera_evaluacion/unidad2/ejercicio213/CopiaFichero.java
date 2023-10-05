package org.example.primera_evaluacion.unidad2.ejercicio213;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopiaFichero {
    public static void main(String[] args) throws IOException {

        Path rutaOrigen = Paths.get(".\\files\\ejercicio213\\directorio\\origen.txt");
        Path rutaDestino = Paths.get(".\\files\\ejercicio213\\directorio\\destino.txt");
        InputStream is = new FileInputStream(new File(String.valueOf(rutaOrigen)));

        Files.copy(rutaOrigen,rutaDestino);

    }
}

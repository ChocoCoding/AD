package org.example.primera_evaluacion.unidad2.ejercicio214;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoverFichero {
    public static void main(String[] args) throws IOException {

        Path rutaOrigen = Paths.get(".\\files\\ejercicio214\\\\destino.txt");
        Path rutaDestino = Paths.get(".\\files\\ejercicio214\\subdirectorio\\NuevoDestino.txt");

        Files.move(rutaOrigen,rutaDestino);

    }
}

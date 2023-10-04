package org.example.primera_evaluacion.unidad2.ejercicio209;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File ficheroOrigen = new File(".\\files\\ficheroBinario.dat");
        File ficheroDestino = new File(".\\files\\ficheroDestino.dat");
        FicheroBinario ficheroBinario = new FicheroBinario(ficheroOrigen);
        FicheroBinario ficheroDestino2 = new FicheroBinario(ficheroDestino);
        ficheroBinario.escribir("Arriba españa");
        ficheroBinario.leer();
        ficheroBinario.copiar(ficheroDestino2);
    }
}

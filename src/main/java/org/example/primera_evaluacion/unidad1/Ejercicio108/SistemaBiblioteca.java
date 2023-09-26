package org.example.primera_evaluacion.unidad1.Ejercicio108;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Material material = new Libro("En busca de la felicidad","AA234");
        Material material1 = new Libro("En busca de la felicidad1","BB234");
        Material material2 = new Libro("En busca de la felicidad2","CC234");

        Biblioteca biblioteca = new Biblioteca();

        biblioteca.getCatalogo().add(material);
        biblioteca.getCatalogo().add(material1);
        biblioteca.getCatalogo().add(material2);

        biblioteca.prestarMaterial(material);
        biblioteca.prestarMaterial(material1);

        biblioteca.verMaterialPrestado();

        biblioteca.devolverMaterialPrestado();

        biblioteca.verMaterialPrestado();

    }
}

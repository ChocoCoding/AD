package org.example.Ejercicio108;

public class Libro extends Material{
    private String autor;

    public Libro() {
    }

    public Libro(String titulo, String numeroIdentificacion) {
        super(titulo, numeroIdentificacion);
    }

    public Libro(String titulo, String numeroIdentificacion, String autor) {
        super(titulo, numeroIdentificacion);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}

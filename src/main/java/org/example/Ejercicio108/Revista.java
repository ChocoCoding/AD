package org.example.Ejercicio108;

public class Revista extends Material{

    private int numero;


    public Revista() {
    }

    public Revista(String titulo, String numeroIdentificacion) {
        super(titulo, numeroIdentificacion);
    }

    public Revista(String titulo, String numeroIdentificacion, int numero) {
        super(titulo, numeroIdentificacion);
        this.numero = numero;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

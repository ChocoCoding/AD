package org.example.primera_evaluacion.unidad1.Ejercicio108;

public class Revista extends Material{

    private int numero;
    private boolean prestado;


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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Revista{");
        sb.append("numero=").append(numero);
        sb.append(", prestado=").append(prestado);
        return sb.toString();
    }
}

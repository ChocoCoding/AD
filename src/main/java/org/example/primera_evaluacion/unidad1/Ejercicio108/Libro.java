package org.example.primera_evaluacion.unidad1.Ejercicio108;

public class Libro extends Material{
    private String autor;
    private boolean prestado;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Libro{");
        sb.append("autor='").append(autor).append('\'');
        sb.append(", prestado=").append(prestado);
        return sb.toString();
    }
}

package org.example.Ejercicio108;

public class Material {

    private String titulo;
    private String numeroIdentificacion;

    public Material() {
    }

    public Material(String titulo, String numeroIdentificacion) {
        this.titulo = titulo;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}

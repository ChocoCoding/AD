package org.example.primera_evaluacion.unidad1.Ejercicio108;

public class Material {

    private String titulo;
    private String numeroIdentificacion;
    private boolean prestado;

    public Material() {
    }

    public Material(String titulo, String numeroIdentificacion) {
        this.titulo = titulo;
        this.numeroIdentificacion = numeroIdentificacion;
        this.prestado = false;
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

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Material{");
        sb.append("titulo='").append(titulo).append('\'');
        sb.append(", numeroIdentificacion='").append(numeroIdentificacion).append('\'');
        sb.append(", prestado=").append(prestado);
        return sb.toString();
    }
}

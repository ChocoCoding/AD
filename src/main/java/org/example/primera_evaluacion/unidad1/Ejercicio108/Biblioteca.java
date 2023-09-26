package org.example.primera_evaluacion.unidad1.Ejercicio108;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private List<Material> catalogo = new ArrayList<>();


    public Biblioteca() {
        this.catalogo = catalogo;
    }

    public List<Material> getCatalogo() {
        return catalogo;
    }

    public void prestarMaterial(Material material){
        if (material instanceof Libro){
            material.setPrestado(true);
            System.out.println("Se ha prestado el libro: " + material.getTitulo() );
        }

    }

    public void verMaterialPrestado(){
        for (Material mat: catalogo) {
            if (mat instanceof Libro){
                System.out.println(mat);
            }else System.out.println("no hay libros");
        }
    }

    public void devolverMaterialPrestado(){
        for (Material mat: catalogo) {
            if (mat instanceof Libro){
                mat.setPrestado(true);
                System.out.println("Se ha devuelto el libro: " + mat.getTitulo());
            }
        }
    }





    public void setCatalogo(List<Material> catalogo) {
        this.catalogo = catalogo;
    }


}

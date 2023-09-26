package org.example.primera_evaluacion.unidad1.Ejercicio107;

public class Main {

    public static void main(String[] args) {
    NotasAlumnos notasAlumnos = new NotasAlumnos();
    notasAlumnos.trocearEntradaYCrearAlumnos();
    System.out.println("********* MEDIA DE LOS ALUMNOS *********");
    notasAlumnos.calcularMedia();
    System.out.println();
    System.out.println("********* MEDIA DE LOS MÓDULOS *********");
    notasAlumnos.calcularMediaModulos();
        System.out.println();
        System.out.println("********* ALUMNOS CON TODOS LOS MÓDULOS APROBADOS *********");
    notasAlumnos.calcularAlumnosAprobados();
        System.out.println();
        System.out.println("********* ALUMNOS QUE NO HAN CURSADO ALGUN MÓDULO *********");
        notasAlumnos.calcularAlumnosQueNoHanCursadoAlgunModulo();
        System.out.println();
        System.out.println("********* ALUMNOS QUE NO HAN CURSADO ALGUN MÓDULO *********");
        notasAlumnos.calcularAlumnosQueNoHanCursadoAlgunModulo();
        System.out.println();
        System.out.println("********* MEDIA MAS ALTA *********");
        notasAlumnos.calcularMediaMasAlta();
        System.out.println();
        System.out.println("********* NOTA MAS ALTA *********");
        notasAlumnos.calcularAlumnoConNotaMasAltaPorModulo();

    }
}

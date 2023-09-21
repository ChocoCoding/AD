package org.example.Ejercicio106;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    Scanner sc = new Scanner(System.in);
    List<Contacto> contactos = new ArrayList<>();

    public void agregarContacto(){
        while (true){
        System.out.println("Introduce un nombre para el contacto: ");
        String nombre = sc.nextLine();
        System.out.println("Introduce el numero del contacto: ");
        String num = sc.nextLine();
        Contacto contacto = new Contacto(nombre,num);
        contactos.add(contacto);
        System.out.println("Se ha agregado correctamente el contacto");
            System.out.println("Quieres añadir mas contactos? SI/NO" );
            Scanner sc = new Scanner(System.in);
            String pregunta = sc.nextLine();
            if (pregunta.equalsIgnoreCase("no")){
                break;
            }
        }
    }

    public void mostrarContacto(){
        while (true){
            System.out.println("Introduce el nombre del contacto a buscar: ");
            String nombre = sc.nextLine();

            for (Contacto cont: contactos) {
                if (nombre.equalsIgnoreCase(cont.nombre)){
                    System.out.println("Contacto: " + cont);
                    break;
                }else System.out.println("No se ha podido encontrar al contacto");
            }
        break;
        }
    }

    public void eliminarContacto(){
        while (true){
            System.out.println("Introduce el nombre del contacto a eliminar: ");
            String nombre = sc.nextLine();

            for (Contacto cont: contactos) {
                if (nombre.equalsIgnoreCase(cont.nombre)){
                    contactos.remove(cont);
                    System.out.println("Se ha eliminado a: " + cont);
                    break;
                }else System.out.println("No se ha podido encontrar al contacto");
            }
        break;
        }


    }


}

package org.example.primera_evaluacion.unidad1.Ejercicio103;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Realiza un programa en Java que gestione la compra de los productos de un supermercado.
 *
 * El programa solicitará el nombre del producto y su precio en bucle.
 *
 * Después de de introducir estos datos, preguntará si deseamos continuar introduciendo más productos. Las posibles respuestas serán SI para seguir en el bucle y NO para salir.
 *
 * Al terminar, mostrará el importe total de la compra y cuántos productos hemos comprado.
 */
public class Ejercicio103 {
    static Scanner sc = new Scanner(System.in);
    public static void pedirDatosProductoYCalcularPrecioTotal(){
        String nombre = "";
        double precio = 0.0;
        int cont = 1;
        List<Producto> productos = new ArrayList<>();
        while (true){
            sc = new Scanner(System.in);

            try {
                System.out.println("Introduce el nombre del producto:");
                nombre = sc.nextLine();
                System.out.println("Introduce el precio del producto:");
                precio = sc.nextDouble();
                Producto producto = new Producto(nombre,precio);
                productos.add(producto);

                //Preguntamos si quiere continuar añadiendo productos
                System.out.println("¿Quiere añadir más productos? SI/NO");
                sc = new Scanner(System.in);
                String continuar = sc.nextLine();
                if (continuar.equalsIgnoreCase("no")){
                    double precioTotal = 0;
                    for (Producto prod :productos ) {
                        precioTotal += prod.getPrecio();
                    }
                    System.out.println("El precio total es: " + precioTotal + "€" + " por " + cont + " productos");
                    break;
                }else if (continuar.equalsIgnoreCase("si")){
                    cont++;
                    System.out.println("Producto " + cont);
                }else System.out.println("La opcion marcada no es correcta");
            }catch (InputMismatchException | NumberFormatException ex){
                System.out.println("El dato introducido debe ser un numero");
            }
        }
    }



}

package org.example.Ejercicio104_Ejercicio105;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_Piscina {

    public static int calcularAforoPiscina(){
        double longPis = 0;
        double anchPis = 0;
        double longPar = 0;
        double anchPar = 0;
        double supPis = 0;
        double supPar = 0;
        while (true){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Introduce la longitud de la piscina");
                longPis = sc.nextDouble();
                System.out.println("Introduce la anchura de la piscina");
                anchPis = sc.nextDouble();
                Piscina piscina = new Piscina(longPis,anchPis);
                supPis = piscina.getLongitud() * piscina.getAnchura();

                System.out.println("Introduce la longitud de la parcela");
                longPar = sc.nextDouble();
                System.out.println("Introduce la anchura de la parcela");
                anchPar = sc.nextDouble();
                Parcela parcela = new Parcela(longPar,anchPar);
                supPar = parcela.getLongitud() * parcela.getAnchura();

                if (supPis > supPar){
                    //supPar = (int) Math.round(supPar);
                   supPar = (int) Math.round(supPar);
                    return  (int)supPar / 2;

                }else{
                    //supPis = (int)Math.round(supPis);
                    supPis = (int) Math.round(supPis);
                    return (int)supPis / 2;
                }
            }catch (InputMismatchException | NumberFormatException ex){
                System.out.println("Tienes que introducir un número, los decimal se separan por ','");
            }
        }
        }

    public static void reservarPorFranja(){
        int aforoTotal = calcularAforoPiscina();
        String[][] reservasPorFranja = new String[6][aforoTotal];

        while (true){
            try {
                Scanner sc = new Scanner(System.in);
                int franja = 0;
                System.out.println("Introduce un numero de franja");
                System.out.println("Franja1 → 08:00h -10:00h\n" +
                        "\n" +
                        "Franja2 → 10:00h- 12:00h\n" +
                        "\n" +
                        "Franja3 → 12:00h -14:00h\n" +
                        "\n" +
                        "Franja4 → 14:00h- 16:00h\n" +
                        "\n" +
                        "Franja5 → 16:00h -18:00h\n" +
                        "\n" +
                        "Franja6 → 18:00h- 20:00h");
                franja = sc.nextInt();
                if (franja < 1 || franja > 6){
                    System.out.println("Solo se permiten numeros del [1-6]");
                }else {
                    //Comprobamos si hay parcelas disponibles en esa franja
                    int plazasDisponibles = 0;
                    for (int x = 0; x < reservasPorFranja[franja].length; x++){
                        if (reservasPorFranja[franja][x] == null){
                            plazasDisponibles++;
                        }
                    }
                    if (plazasDisponibles > 0){
                        System.out.println("Hay " + plazasDisponibles + " plazas disponibles para esta franja horaria");
                        sc = new Scanner(System.in);
                        System.out.println("Introduzca su DNI, debe ser en este formato: [12345678A]");
                        String dni = sc.nextLine();

                        //Comprobamos si es un DNI válido
                        if (comprobarDni(dni)){
                            if (!comprobarSiDniEstaRegistrado(dni, reservasPorFranja)) {
                                for (int y = 0; y < reservasPorFranja[franja].length; y++) {
                                    if (reservasPorFranja[franja][y] == null) {
                                        //En caso de que sea válido lo metemos en la primera posicion libre del array
                                        reservasPorFranja[franja][y] = dni;
                                        System.out.println("Se ha reservado correctamente" + "\n");
                                        break;
                                        //En caso de que ya este registrado, avisamos de que no se puede reservar y break

                                    } else if (reservasPorFranja[franja][y].length() == 9) {

                                    }

                                }
                            }
                        }
                    }else {
                        System.out.println("No hay plazas disponibles en la franja: " + franja);
                    }

                }
                }catch (InputMismatchException | NumberFormatException ex){
                System.out.println("Solo se permiten numeros enteros");
            }
        }
    }

    private static boolean comprobarSiDniEstaRegistrado(String dni,String[][] reservasPorFranja) {
        boolean isRegistrado = false;
        for (int x = 0; x < reservasPorFranja.length; x++){
            for (int j = 0; j < reservasPorFranja[j].length; j++){
                System.out.println(reservasPorFranja[0][j]);
                //Comprobamos si el dni ya esta registrado
                if (reservasPorFranja[x][j] != null && reservasPorFranja[x][j].equals(dni)){
                    System.out.println("No se puede reservar 2 veces en el mismo dia");
                    isRegistrado = true;
                    break;
                }if (isRegistrado){
                    break;
                }else isRegistrado = false;
            }
        }
    return isRegistrado;
    }

    public static boolean comprobarDni(String dni){
        boolean comprobar = false;
        String letraMayus = "";
        do {
            try {
                if (dni.length() != 9 || !Character.isLetter(dni.charAt(8))){
                    System.out.println("No es un DNI válido");
                }
                letraMayus = dni.substring(8).toUpperCase();
                if (comprobarNumerosDni(dni) && comprobarLetraDni(dni).equals(letraMayus)){
                    System.out.println("El DNI es válido");
                    return true;
                }else {
                    System.out.println("El DNI no es válido");
                    return false;
                }
            }catch (StringIndexOutOfBoundsException ex){
                System.out.println("La longitud del DNI debe ser 9 caracteres con este formato [12345678A]");
                return false;
            }
        }while(true);

    }

    private static boolean comprobarNumerosDni(String dni) {
        int x,i = 0;
        String[] unoAlNueve = {"0","1","2","3","4","5","6","7","8","9"};
        String miDni = "";
        String numero = "";
        for (x = 0; x < dni.length() -1; x++){
            numero = dni.substring(x, x+1);
            for (i = 0; i < unoAlNueve.length; i++){
                if (numero.equals(unoAlNueve[i])){
                    miDni += unoAlNueve[i];
                }
            }
        }

        return miDni.length() == 8;
    }

    private static String comprobarLetraDni(String dni){
        int dniNumero = Integer.parseInt(dni.substring(0,8));
        int calculo = 0;
        String letra = "";
        String[] diccionarioLetras = {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        calculo = dniNumero % 23;
        letra = diccionarioLetras[calculo];
        return letra;
    }
}

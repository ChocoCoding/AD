package org.example.primera_evaluacion.unidad2.ejercicio220.piscina;

import org.example.primera_evaluacion.unidad2.ejercicio220.config.Config;

import java.io.File;
import java.util.HashMap;

public class App {
    static final String PISCINA_CONFIG = "piscina.config";
    static String ruta = ".\\files\\ejercicio220\\"+PISCINA_CONFIG;

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        map.put("start","true");
        map.put("persistencia","true");
        map.put("max_franjas","4");

        Config.crearConfigFile(map,ruta);
        System.out.println(Config.leerConfig(ruta,"persistencia"));

        Piscina piscina = new Piscina(5.5,2.5,2.2,3.5);
        Piscina piscina1 = new Piscina(3.5,1.5,5.2,3.5);
        Piscina piscina2 = new Piscina(4.5,8.5,1.2,9.5);
        Piscina.write(piscina,".\\files\\ejercicio220\\piscina.txt");
        Piscina.write(piscina1,".\\files\\ejercicio220\\piscina.txt");
        Piscina.write(piscina2,".\\files\\ejercicio220\\piscina.txt");
        Piscina.read(".\\files\\ejercicio220\\piscina.txt");
    }
}

package org.example.primera_evaluacion.unidad2.ejercicio211;

import java.io.*;

////A continuación, crea una clase SerializarPersona, que tenga los siguientes métodos:
////
////public void escribirPersonaEnFichero(Persona persona, File fichero): escribe la información de la persona en el fichero.
////public Persona leerPersonaDeFichero(File fichero): devuelve un objeto Persona con los datos
// leídos del fichero.
////NOTA: debes usar las clases ObjectInputStream y ObjectOutputStream.
////

public class SerializarPersona {

    public void escribirPersonaEnFichero(Persona persona, File fichero) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(fichero, true);

            if (fichero.length() == 0) { // Si no hay nada usamos la clase que añade la cabecera
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(persona);
                oos.close();

            }else { // Si hay algo en el fichero, usamos la clase que no añade cabecera
                AppendingObjectOutputStream aoos = new AppendingObjectOutputStream(fos);
                aoos.writeObject(persona);
                aoos.close();
            }
            fos.close();


    }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Persona leerPersonaDeFichero(File fichero) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(fichero);
        ObjectInputStream ios = new ObjectInputStream(fis);

        Persona persona = null;
        while(fis.available() != 0) {
            persona = (Persona) ios.readObject();
            System.out.println(persona);
        }
        return persona;
    }


}

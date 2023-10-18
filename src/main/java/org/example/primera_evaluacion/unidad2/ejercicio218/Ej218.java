package org.example.primera_evaluacion.unidad2.ejercicio218;


import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Ej218 {
    static File file = new File(".\\files\\ejercicio218\\alumnos.dat");
    public static void main(String[] args) throws TransformerException, IOException {
        introducirDatosEnElArchivo();
        convertirDatosParaDOM();
        visualizarDOM();
    }

    public static void convertirDatosParaDOM() throws TransformerException {
        Document document = null;
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            String apellido = "";
            int edad = 0;
            double nota = 0.0;
            int pos = 0;

            //Creamos factoria a través de newInstance()
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            document = null;
            try {
                DocumentBuilder builder = dbf.newDocumentBuilder();
                DOMImplementation implementation = builder.getDOMImplementation();
                //creamos el documento
                document = implementation.createDocument(null, "Alumnos", null);

                // Versión de XML con la que vamos a trabajar
                document.setXmlVersion("1.0");

                for (; ; ) {
                    apellido = raf.readUTF();
                    edad = raf.readInt();
                    nota = raf.readDouble();

                    //Nodo empleado
                    Element raiz = document.createElement("Alumno");
                    document.getDocumentElement().appendChild(raiz);

                    // Creamos el nodo hijo de apellido
                    Element eleApe = document.createElement("apellido");
                    // Se le da el valor
                    Text text = document.createTextNode(apellido);
                    // Pegamos el elemento hijo a la raiz
                    raiz.appendChild(eleApe);
                    // Pegamos el valor del nodo
                    eleApe.appendChild(text);

                    // Creamos el nodo hijo de edad
                    Element eleEdad = document.createElement("edad");
                    // Se le da el valor
                    Text textEdad = document.createTextNode(Integer.toString(edad));
                    // Pegamos el elemento hijo a la raiz
                    raiz.appendChild(eleEdad);
                    // Pegamos el valor del nodo
                    eleEdad.appendChild(textEdad);

                    // Creamos el nodo de nota
                    Element eleNota = document.createElement("nota");
                    // Se le da el valor
                    Text textNota = document.createTextNode(Double.toString(nota));
                    // Pegamos el elemento hijo a la raiz
                    raiz.appendChild(eleNota);
                    // Pegamos el valor del nodo
                    eleNota.appendChild(textNota);

                }

            } catch (ParserConfigurationException e) {
                throw new RuntimeException(e);
            }
        } catch (EOFException eof) {
            System.out.println("Fin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Creación del source, result y transformer para almacenar el contenido
        Source source = new DOMSource(document);
        Result result = new StreamResult(new java.io.File(".\\files\\ejercicio218\\alumnos.xml"));
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source,result);
        Result console = new StreamResult(System.out);
        transformer.transform(source,console);
    }

    public static void introducirDatosEnElArchivo(){
        String[] apellidos = {"FERNANDEZ","LOPEZ","GOMEZ","CHEN","SERRANO","CASILLAS", "ALONSO"};
        int[] edades = {17, 20, 18, 17, 19, 21, 20};
        double[] notas = {7.5, 4.2, 6.5, 8.0, 3.2, 9.2, 9.9};

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.seek(raf.length());
            for (int x = 0; x < apellidos.length; x++) {
                raf.writeUTF(apellidos[x]);
                raf.writeInt(edades[x]);
                raf.writeDouble(notas[x]);
            }
        }catch (EOFException eof ){
            System.out.println("Fin del archivo");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void visualizarDOM() throws IOException{

        // Creación de la factoria
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(".\\files\\ejercicio218\\alumnos.xml"));
            document.getDocumentElement().normalize();

            System.out.println("Elemento raiz: "+ document.getDocumentElement().getNodeName());
            //crea una lista con todos los nodos empleado
            NodeList empleados = document.getElementsByTagName("alumno");
            //recorrer la lista
            for(int i=0;i<empleados.getLength();i++) {
                //obtener un nodo
                Node emple = empleados.item(i);

                //tipo de nodo
                if(emple.getNodeType()==Node.ELEMENT_NODE) {

                    //obtener los elementos del nodo
                    Element elemento = (Element)emple;
                    System.out.println("Apellido: "+ getNodo("apellido",elemento));
                    System.out.println("Edad: "+ getNodo("edad",elemento));
                    System.out.println("Nota: "+ getNodo("nota",elemento));
                    System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getNodo(String etiqueta, Element elemen) {
        NodeList nodo = elemen.getElementsByTagName(etiqueta).item(0).getChildNodes();
        Node valornodo = (Node) nodo.item(0);

        //devuelve el valor del nodo
        return valornodo.getNodeValue();
    }
    }


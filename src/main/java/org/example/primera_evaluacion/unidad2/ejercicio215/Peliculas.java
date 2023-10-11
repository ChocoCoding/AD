package org.example.primera_evaluacion.unidad2.ejercicio215;

import org.xml.sax.SAXException;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Peliculas {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(".\\files\\ejercicio215\\peliculas.xml"));

        Element root = doc.getDocumentElement();
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("pelicula");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nElemento actual :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE){

                Element eElement = (Element) nNode;

                System.out.println("PELÍCULA #" + eElement.getAttribute("id"));
                System.out.println("titulo : "+ eElement.getElementsByTagName("titulo").item(0).getTextContent());
                System.out.println("año :"+ eElement.getElementsByTagName("ano").item(0).getTextContent());
                System.out.println("precio : "+ eElement.getElementsByTagName("precio").item(0).getTextContent());
            }
        }
    }
}

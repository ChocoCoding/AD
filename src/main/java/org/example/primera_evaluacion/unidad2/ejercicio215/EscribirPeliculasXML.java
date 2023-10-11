package org.example.primera_evaluacion.unidad2.ejercicio215;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class EscribirPeliculasXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            DOMImplementation implementation = docBuilder.getDOMImplementation();
            Document doc = docBuilder.newDocument();

            //Elemento raíz
            Element rootElement = doc.getDocumentElement();

            //Primer elemento
            Element elemento1 = doc.createElement("elemento1");
            rootElement.appendChild(elemento1);

            //Se agrega un atributo al nodo elemento y su valor
            Attr attr = doc.createAttribute("id");
            attr.setValue("valor del atributo");
            elemento1.setAttributeNode(attr);

            Element elemento2 = doc.createElement("elemento2");
            elemento2.setTextContent("Contenido del elemento 2");
            rootElement.appendChild(elemento2);

            //Se escribe el contenido del XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/ruta/prueba.xml"));
            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}

package parser;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;

public class ParserXML{
    static File fXmlFile;
    static DocumentBuilderFactory dbFactory;
    static DocumentBuilder dBuilder;
    static Document doc;

    public static NodeList getNodeListByTag(String xmlName, String tagName) {
        try {
            fXmlFile = new File(xmlName);
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName(tagName);
            return nList;
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
            System.out.println("PArserConfigExcep");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static void updateXML(String xmlName) {
        try {
            doc.getDocumentElement().normalize();
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(xmlName));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
            
            System.out.println("XML-ul modificat cu succes");
        } catch (TransformerException te1) {
            te1.printStackTrace();
            System.out.println("transformer exception");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
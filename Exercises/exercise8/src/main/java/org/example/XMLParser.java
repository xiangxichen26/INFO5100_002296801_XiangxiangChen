package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {

    public static void parseXMLFromFile(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("Book");
        System.out.println("Parsing XML from file:");
        printXmlData(nList);
    }

    private static void printXmlData(NodeList nList) {
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Title : " + element.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Published Year : " + element.getElementsByTagName("publishedYear").item(0).getTextContent());
                System.out.println("Number of Pages : " + element.getElementsByTagName("numberOfPages").item(0).getTextContent());
                NodeList authors = element.getElementsByTagName("author");
                System.out.print("Authors : ");
                for (int i = 0; i < authors.getLength(); i++) {
                    System.out.print(authors.item(i).getTextContent() + (i < authors.getLength() - 1 ? ", " : "\n"));
                }
            }
        }
    }
}

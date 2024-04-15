package org.example;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class XMLParser {

    public static void parseXMLFromFile(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("Book");
        System.out.println("Original XML:");
        printXmlData(nList);

        // add a new book
        addNewBook(document);

        saveDocumentToFile(document, filePath);

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("\nnew XML file:");
        printXmlDocument(document);
        printXmlData(document.getElementsByTagName("Book"));
    }

    private static void addNewBook(Document document) {
        NodeList books = document.getElementsByTagName("BookShelf");
        if (books.getLength() > 0) {
            Node bookShelf = books.item(0);

            Element newBook = document.createElement("Book");
            Element title = document.createElement("title");
            title.setTextContent("The Hobbit");
            Element publishedYear = document.createElement("publishedYear");
            publishedYear.setTextContent("1937");
            Element numberOfPages = document.createElement("numberOfPages");
            numberOfPages.setTextContent("310");
            Element authors = document.createElement("authors");
            Element author = document.createElement("author");
            author.setTextContent("J. R. R. Tolkien");
            authors.appendChild(author);

            newBook.appendChild(title);
            newBook.appendChild(publishedYear);
            newBook.appendChild(numberOfPages);
            newBook.appendChild(authors);
            bookShelf.appendChild(newBook);
        }
    }

    private static void saveDocumentToFile(Document doc, String filename) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filename));
        transformer.transform(source, result);
    }

    private static void printXmlDocument(Document document) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);
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

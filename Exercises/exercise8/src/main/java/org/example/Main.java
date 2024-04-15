package org.example;

public class Main {
    public static void main(String[] args) {
        String xmlFilePath = "src/main/java/org/example/books.xml";
        String jsonFilePath = "src/main/java/org/example/books.json";

        try {
            XMLParser.parseXMLFromFile(xmlFilePath);
            JsonParser.parseJSONFromFile(jsonFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

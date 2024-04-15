package org.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonParser {

    public static void parseJSONFromFile(String filePath) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            // Parse the JSON file
            Object obj = parser.parse(reader);

            // Convert object to JSONObject
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray) jsonObject.get("BookShelf");

            System.out.println("Parsing JSON from file:");
            printJsonData(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the JSON file.");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error parsing the JSON data.");
        }
    }

    private static void printJsonData(JSONArray jsonArray) {
        for (Object obj : jsonArray) {
            JSONObject book = (JSONObject) obj;
            System.out.println("Title : " + book.get("title"));
            System.out.println("Published Year : " + book.get("publishedYear"));
            System.out.println("Number of Pages : " + book.get("numberOfPages"));
            JSONArray authors = (JSONArray) book.get("authors");
            System.out.print("Authors : ");
            for (int i = 0; i < authors.size(); i++) {
                System.out.print(authors.get(i) + (i < authors.size() - 1 ? ", " : "\n"));
            }
        }
    }
}

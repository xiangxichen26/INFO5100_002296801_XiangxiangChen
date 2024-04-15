package org.example;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
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

            System.out.println("Original JSON:");
            printJsonData(jsonArray);

            // Add a new book entry
            addNewBook(jsonArray);

            // Write the modified JSON back to file 
            writeJsonToFile(jsonObject, filePath);

            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("\nnew JSON file:");
            printJsonData(jsonArray);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading the JSON file.");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error parsing the JSON data.");
        }
    }

    private static void addNewBook(JSONArray jsonArray) {
        JSONObject newBook = new JSONObject();
        newBook.put("title", "The Hobbit");
        newBook.put("publishedYear", 1937);
        newBook.put("numberOfPages", 310);
        JSONArray authors = new JSONArray();
        authors.add("J.R.R. Tolkien");
        newBook.put("authors", authors);

        jsonArray.add(newBook);
    }

    private static void writeJsonToFile(JSONObject jsonObject, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonObject.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
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

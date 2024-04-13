import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException, ParseException {
        // XML Parsing and Modification
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File("books.xml"));
        doc.getDocumentElement().normalize();

        // Adding new Book entry
        Node bookShelf = doc.getElementsByTagName("BookShelf").item(0);
        Element newBook = doc.createElement("Book");
        Element title = doc.createElement("title");
        title.appendChild(doc.createTextNode("Brave New World"));
        Element year = doc.createElement("publishedYear");
        year.appendChild(doc.createTextNode("1932"));
        Element pages = doc.createElement("numberOfPages");
        pages.appendChild(doc.createTextNode("311"));
        Element authors = doc.createElement("authors");
        Element author = doc.createElement("author");
        author.appendChild(doc.createTextNode("Aldous Huxley"));
        authors.appendChild(author);

        newBook.appendChild(title);
        newBook.appendChild(year);
        newBook.appendChild(pages);
        newBook.appendChild(authors);
        bookShelf.appendChild(newBook);

        // Reprint XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult console = new StreamResult(System.out);
        transformer.transform(source, console);

        // JSON Parsing and Modification
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("books.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray bookShelfJson = (JSONArray) jsonObject.get("BookShelf");

        JSONObject newBookJson = new JSONObject();
        newBookJson.put("title", "Brave New World");
        newBookJson.put("publishedYear", 1932);
        newBookJson.put("numberOfPages", 311);
        JSONArray authorsJson = new JSONArray();
        authorsJson.add("Aldous Huxley");
        newBookJson.put("authors", authorsJson);

        bookShelfJson.add(newBookJson);

        // Reprint JSON
        System.out.println(JSONValue.toJSONString(jsonObject));
    }
}

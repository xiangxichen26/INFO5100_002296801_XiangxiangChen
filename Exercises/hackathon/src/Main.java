import com.github.javafaker.Faker;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Library library = new Library("NEU Library");

        //use java faker to populate some books into the library
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++) {
            boolean flag = i / 2 != 0;
            library.addBook(new Book(faker.book().title(), faker.book().author(), faker.book().genre(), faker.code().isbn10(),flag));
        }

        Scanner sc = new Scanner(System.in);
        boolean exitCode = false;
        while (!exitCode) {
            System.out.println("Welcome to NEU Library, here is the book list");
            // print the book list
            library.printBookList();
            // search book by the title
            System.out.println("Please enter the title of the book you want to search");
            String searchTitle = sc.nextLine();
            System.out.println(searchTitle);
            System.out.println("Search Result:");
            library.searchBookByTitle(searchTitle);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // search book by the author
            System.out.println("Please enter the author of the book you want to search");
            String searchAuthor = sc.nextLine();
            System.out.println("Search Result:");
            library.searchBookByAuthor(searchAuthor);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // search book by ISBN
            System.out.println("Please enter the ISBN of the book you want to search");
            String searchISBN = sc.nextLine();
            System.out.println("Search Result:");
            library.searchBookByISBN(searchISBN);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // checking out a book
            System.out.println("Please enter the ISBN of the book you want to checkout");
            String checkOutISBN = sc.nextLine();
            library.checkOutBook(checkOutISBN);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // search available books
            System.out.println("Print the available books");
            library.searchAvailableBook();
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // returning a book
            System.out.println("Please enter the ISBN of the book you want to return");
            String returnISBN = sc.nextLine();
            library.returnBook(returnISBN);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // remove a book
            System.out.println("Please enter the ISBN of the book you want to remove");
            String removeISBN = sc.nextLine();
            library.removeBook(removeISBN);
            System.out.println("------------------------------------------------------------------------------------------------------------");

            // print the book list
            library.printBookList();

            exitCode = true;
            sc.close();

        }
    }
}

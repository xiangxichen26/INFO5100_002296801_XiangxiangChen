import java.util.ArrayList;

public class Library {

    String name;

    ArrayList<Book> bookCollection = new ArrayList<>();

    public Library(String name){
        this.name = name;
    }

    public void addBook(Book book){
        bookCollection.add(book);
    }

    public void removeBook(String ISBN){
        boolean flag = false;
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                flag = true;
                bookCollection.remove(book);
                System.out.println("Remove Successfully");
            }
        }
        if (!flag) {
            System.out.println("Book doesn't exist");
        }
    }

    public void searchBookByTitle(String title){
        boolean flag =false;
        for (Book book : bookCollection) {
            if (book.getTitle().equals(title)) {
                book.displayInfo();
                flag = true;
            }
        }
        if(!flag){
            System.out.println("No data");
        }
    }

    public ArrayList<Book> searchBookByAuthor(String author){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
                book.displayInfo();
            }
        }
        if(result.isEmpty() ){
            System.out.println("No data");
        }
        return result;
    }

    public ArrayList<Book> searchBookByGenre(String genre){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book.getGenre().equals(genre)) {
                result.add(book);
                book.displayInfo();
            }
        }
        if(result.isEmpty() ){
            System.out.println("No data");
        }
        return result;
    }

    public void searchBookByISBN(String ISBN){
        boolean flag = false;
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                book.displayInfo();
                flag = true;
            }
        }
        if(!flag){
            System.out.println("No data");
        }
    }

    public ArrayList<Book> searchAvailableBook(){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : bookCollection) {
            if (book.getAvailability()) {
                result.add(book);
                book.displayInfo();
            }
        }
        if(result.isEmpty() ){
            System.out.println("No data");
        }
        return result;
    }

    public void checkOutBook(String ISBN){
        boolean flag = false;
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                flag = true;
                if(book.getAvailability()){
                    book.setAvailability(false);
                    System.out.println("Checkout Successfully");
                }else {
                    System.out.println("Book is unavailable");
                }
            }
        }
        if (!flag) {
            System.out.println("Book doesn't exist");
        }
    }

    public void returnBook(String ISBN){
        boolean flag = false;
        for (Book book : bookCollection) {
            if (book.getISBN().equals(ISBN)) {
                flag = true;
                book.setAvailability(true);
                System.out.println("Return Successfully");
            }
        }
        if (!flag) {
            System.out.println("Book doesn't exist");
        }
    }

    public void printBookList(){
        for (Book book : bookCollection) {
            book.displayInfo();
            System.out.println("------------------------------------------------------------------------");
        }
    }

}


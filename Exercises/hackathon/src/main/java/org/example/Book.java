package org.example;

public class Book {
    String title;
    String author;
    String genre;
    String ISBN;
    Boolean availability;

    public Book(String title, String author, String genre, String ISBN){
        this.title = title;
        this.author = author;
        this.genre =  genre;
        this.ISBN = ISBN;
        this.availability = true;
    }

    public Book(String title, String author, String genre, String ISBN, Boolean availability){
        this.title = title;
        this.author = author;
        this.genre =  genre;
        this.ISBN = ISBN;
        this.availability = availability;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public String getISBN(){
        return ISBN;
    }

    public Boolean getAvailability(){
        return availability;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    public void setAvailability(Boolean availability){
        this.availability = availability;
    }

    public void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Genre: " + genre);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
    }

}




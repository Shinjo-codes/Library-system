package org.example;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int availableCopies;

    //Constructors to initialize the attributes above
    public Book(String title, String author, String ISBN, int availableCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.availableCopies = availableCopies;
    }

    //Getters and Setters that provides access to the attributes
    public String getTitle() {

        return title;
    }

    public String getAuthor() {

        return author;
    }

    public String getISBN() {

        return ISBN;
    }

    public int getAvailableCopies() {

        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {

        this.availableCopies = availableCopies;
    }

    //Method to implement borrowCopy by members.
    //If the number of available copies of a book is positive, the available copies is reduced when a book is borrowed, hence, the decremental symbol
    public boolean borrowCopy() {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        } else {
            return false;
        }
    }

    //Method to implement copy of books returned by members.
    //If a particular book is returned, the number of available copies for that book is increased, hence, the incremental symbol
    public void returnCopy() {

        availableCopies++;
    }

    //Method to display the information of available books to return the string representation of book title, ISBN, and available copies
    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + ISBN + ") - Available copies: " + availableCopies;
    }
}
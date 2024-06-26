package org.example;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    //Constructors to initialize the attributes above.
    //Here, "borrowedBooks" is initialized as an empty list where the names of members who borrowed books will be entered.
    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }
//Getters provide access to the attributes
    //Getters returns the value of the attributes respectively.
    public String getName() {

        return name;
    }

    public String getMemberId() {

        return memberId;
    }

    public List<Book> getBorrowedBooks() {

        return borrowedBooks;
    }
//This method allows a member to borrow a book if the book is available and then adds the book to the members' list of borrowedBooks
    //If the book is not available, the methods prints that the book is currently unavailable

    public void borrowBook(Book book) {
        if (book.getAvailableCopies() > 0) { //if available copies of the book is positive, that is, greater than 0
            book.borrowCopy();
            borrowedBooks.add(book);
        } else {
            System.out.println(book + " is currently unavailable.");
        }
    }
//This method allows a member to return a book and removes the book from the members' list of borrowed books
    //If the book is not in the members' list of borrowed books, the method prints that the book was not borrowed by the member
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.returnCopy();
        } else {
            System.out.println( book + " was not borrowed by the member.");
        }
    }

    //Method to display the information of a member by returning a string representing the name and memberID of the member.
    @Override
    public String toString() {

        return "Member: "
                + name
                + " (ID: " + memberId + ")";
    }
}


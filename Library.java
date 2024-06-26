package org.example;

import java.util.*;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private HashMap<Book, Queue<Member>> waitingList; //A hashmap maps two attributes of an object together.
    //In this context, line 12 is a hashmap which maps each book to a queue of members in the library waiting to borrow that book.

    //Constructors to initialize the attributes (books, members, and waitingList) above
    //Both books and members are initialized as empty lists where the books and members registered with the library can be stored.
    //Waiting list is initialized as an empty hashmap where a book will be mapped with the members waiting to borrow the book.

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
        waitingList = new HashMap<>();
    }
//The addBook method simply adds a new book to the list of books in the library and then
// creates a priority queue (of members who would borrow the book) for the book in the waitingList.
    //When a book is added using the addBook method, a priority queue is initialized for that book.
// The priority queue orders members alphabetically by their names.
    public void addBook(Book book) {
        books.add(book);
        waitingList.put(book, new PriorityQueue<>((m1, m2) -> m1.getName().compareTo(m2.getName())));
    }
//The registerMember method simply adds a new member to the list of members in the library.
    public void registerMember(Member member) {

        members.add(member);
    }
//The borrowBook method enables members to borrow books from the library.
    //It runs through the library and looks for the book by ISBN
    //If the book is not unavailable, it means the book is available (i.e. available copies > 0)..
    //and the member.borrowBook(book) method enables the member to borrow the book.
    //Or else, the member is added to a waiting list for the book if the book is not available and the member is prompted
    //that he has been added to the waiting list for the book. Or else, "book not found" is printed if the book is not found in the library.
    public boolean borrowBook(String ISBN, Member member) {
        Book book = findBookByISBN(ISBN);
        if (book != null) {
            if (book.getAvailableCopies() > 0) {
                member.borrowBook(book);
            } else {
                waitingList.get(book).add(member);
                System.out.println(member.getName() + " has been added to the waiting list for " + book.getTitle());
            }
        } else {
            System.out.println("Book not found.");
        }

        return true;
    }
//This method enables a member to return a book they had borrowed.
    //When a member returns a book, the system looks up the book using the ISBN..
    //If the book exits in the system (i.e. 'book will not be null'), the member returns the book..
    //Then the waiting list for that book is checked. If the waiting list for the book is not empty, line 61 accesses
    //the priority queue for that book and then the first person on the queue is removed and returned (i.e. the next person
    //who should get the book)
    //The next member now borrows the book in line 66 and 67 prints out that the book has been borrowed by the next member.
    //If the book is not found, line 71 prints that the book wasn't found

    public void returnBook(String ISBN, Member member) {
        Book book = findBookByISBN(ISBN);
        if (book != null) {
            member.returnBook(book);
            if (!waitingList.get(book).isEmpty()) {
                Member nextMember = waitingList.get(book).poll();
                borrowBook(ISBN, nextMember);
                System.out.println(nextMember.getName() + " has been borrowed " + book.getTitle() + " from the waiting list.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }
//This displayAvailableBooks method uses a for each loop to print out the details for each Book object in the books list
    //within the Book class
    public void displayAvailableBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private Book findBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Additional feature: Search for books by title
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Additional feature: Search for books by author
    public List<Book> searchBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Member> getMember() {
        return members;
    }
}


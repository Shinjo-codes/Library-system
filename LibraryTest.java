package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private Book book1;
    private Book book2;
    private Member member1;
    private Member member2;

    @BeforeEach
    void Setup(){
        library = new Library();
        book1 = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 2);
        book2 = new Book("How to use Springboot in Java", "Ajayi Tobi", "123456789", 4);
        member1 = new Member("Muhammad Junior", "M092");
        member2 = new Member("Matthew Urie", "M742");
    }

    @Test
    void returnGetterValues(){
        assertEquals("Bob Ojo", book1.getAuthor() );
        assertEquals("Daring Hibiscus", book1.getTitle() );
        assertEquals("8374ygtf", book1.getISBN() );
        assertEquals(2, book1.getAvailableCopies() );
    }
    @Test
    void testAddBook(){
        library.addBook(book1);
        library.addBook(book2);
        List <Book> books = library.getBooks();
        assertEquals(2, books.size());
        assertTrue(books.contains(book1));
        assertTrue(books.contains(book2));
    }

    @Test
    void testAddMembers(){
        library.registerMember(member1);
        library.registerMember(member2);
        List <Member> membersList = library.getMember();
        assertEquals(2, membersList.size());
        assertTrue(membersList.contains(member1));
        assertTrue(membersList.contains(member2));
    }

    @Test
    void testBorrowBook() {
    library.borrowBook("8374ygtf", member1);
    member1.borrowBook(book1);
        assertEquals(1, book1.getAvailableCopies());
    }

    @Test
    void testReturnBook() {
        library.returnBook("123456789", member2);
        member2.returnBook(book2);
        //assertEquals([ ], member2.getBorrowedBooks());
        assertEquals(4, book2.getAvailableCopies());
    }

    @Test
    void testDisplayBook() {
        library.displayAvailableBooks();
    }
    }

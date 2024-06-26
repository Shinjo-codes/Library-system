package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
private Book book;
//private Library library;

@BeforeEach
void Setup(){
    book = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
}

@Test
 void returnBookTitle(){
Book bookTitle = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
assertEquals("Daring Hibiscus", bookTitle.getTitle());
}

@Test
    void returnBookAuthor() {
    Book bookAuthor = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
    assertEquals("Bob Ojo", bookAuthor.getAuthor());
}

    @Test
    void returnISBN() {
        Book bookISBN = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
        assertEquals("8374ygtf", bookISBN.getISBN());
    }

    @Test
    void returnAvailableCopies() {
        Book bookCopy = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
        assertEquals(8, bookCopy.getAvailableCopies());
    }

    @Test
    void returnNotAvailableCopies() {
        Book bookCopy = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
        assertNotEquals(4, bookCopy.getAvailableCopies());
    }
    @Test
    void testBorrowCopies() {
    assertTrue(book.borrowCopy());
    assertEquals(7, book.getAvailableCopies());
    }

    @Test
    void testReturnCopies() {
        book.returnCopy();
        assertEquals(9, book.getAvailableCopies());
    }

    @Test
    void testDisplayBook() {
    Book displayBook = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
    displayBook.toString();
    }





}
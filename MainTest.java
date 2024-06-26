package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Library library;
    private Member member1;
    private Member member2;
    private Member member3;
    private Book book1;
    private Book book2;
    private Book book3;

@BeforeEach
    void Setup() {
    library = new Library();
    book1 = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 2);
    book2 = new Book("How to use Springboot in Java", "Ajayi Tobi", "123456789", 4);
    book3 = new Book("How to build a school system in Java", "Shina Ojo", "1234567TY", 3);
    member1 = new Member("Muhammad Junior", "M092");
    member2 = new Member("Matthew Urie", "M742");
    member3 = new Member("Abigail Momoh", "M419");


    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    List<Book> books = library.getBooks();
    assertEquals(3, books.size());
    assertTrue(books.contains(book1));
    assertTrue(books.contains(book2));
    assertTrue(books.contains(book3));

    library.registerMember(member1);
    library.registerMember(member2);
    library.registerMember(member3);

    List<Member> membersList = library.getMember();
    assertEquals(3, membersList.size());
    assertTrue(membersList.contains(member1));
    assertTrue(membersList.contains(member2));
    assertTrue(membersList.contains(member3));
}

    @Test
     void testLibrarySystem(){

    //for borrowing books

        boolean borrowBook1 = library.borrowBook("123456789", member1);
        boolean borrowBook2 = library.borrowBook("8374ygtf", member2);
        boolean borrowBook3 = library.borrowBook("1234567TY", member3);

        assertTrue(borrowBook1);
        assertTrue(borrowBook2);
        assertTrue(borrowBook3);

        assertEquals(1, book1.getAvailableCopies());
        assertEquals(3, book2.getAvailableCopies());
        assertEquals(2, book3.getAvailableCopies());

        //for returning books
        library.returnBook("123456789", member1);
        assertEquals(4, book2.getAvailableCopies());

    }

}
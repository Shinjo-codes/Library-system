package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
    private Member member;
    private Book book1;
    private Book book2;

    @BeforeEach
    void Setup() {
        member = new Member("Muhammad Junior", "M092");
        book1 = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 1);
        book2 = new Book("How to use Springboot in Java", "Ajayi Tobi", "123456789", 4);
    }

    @Test
    void returnMemberId() {
        Member memberId = new Member("Muhammad Junior", "M092");
        assertEquals("M092", memberId.getMemberId());
    }

    @Test
    void returnMemberName() {
        Member memberName = new Member("Muhammad Junior", "M092");
        assertEquals("Muhammad Junior", memberName.getName());
    }

    @Test
    void returnBorrowedBooks() {
        Book members1 = new Book("Daring Hibiscus", "Bob Ojo", "8374ygtf", 8);
        assertEquals(book1, book1);
    }

    @Test
    void testBorrowBook() {
        member.borrowBook(book1);
        assertFalse(book1.borrowCopy());

    }

    @Test
    void testBorrowBook1() {
        member.borrowBook(book2);
        assertTrue(book2.borrowCopy());

    }
    @Test
    void testBorrowBookUnavailable() {
        member.borrowBook(book1);
        member.borrowBook(book1);
        assertFalse(book1.borrowCopy());

    }

    @Test
    void testReturnBook() {
        member.borrowBook(book1);
        member.borrowBook(book2);
        member.returnBook(book2);
        assertFalse(member.getBorrowedBooks().contains(book2));
        assertTrue(member.getBorrowedBooks().contains(book1));

    }
    @Test
    void testNotBorrowed() {
        member.returnBook(book1);
        assertFalse(member.getBorrowedBooks().contains(book1));

    }

    @Test
    void testToString() {
        Member displayMemberDetails = new Member("Muhammad Junior", "M092");
        displayMemberDetails.toString();

    }
}
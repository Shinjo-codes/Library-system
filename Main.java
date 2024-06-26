package org.example;


public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample books with unique ISBN
        Book book1 = new Book("How to use Springboot in Java", "Ajayi Tobi", "123456789", 3);
        Book book2 = new Book("Ultimate Guide to Becoming a Java Developer", "Olusola Alao", "987654321", 2);
        Book book3 = new Book("Tech Lords", "Manan Suy", "2781979", 4);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Registering sample members with unique memberId
        Member member1 = new Member("Ojo Shina", "M001");
        Member member2 = new Member("Mayowa Swift", "M002");
        Member member3 = new Member("Janet Agu", "M921");
        library.registerMember(member1);
        library.registerMember(member2);
        library.registerMember(member3);

        // Simulating borrowing books
        library.borrowBook("123456789", member1); // Shina borrows "How to use SpringBoot in Java"
        library.borrowBook("987654321", member2); // Mayowa borrows "Ultimate Guide to Becoming a Java Developer"
        library.borrowBook("123456789", member2); // Mayowa borrows "How to use SpringBoot in Java"

        // Display available books
        System.out.println("Available books:");
        library.displayAvailableBooks();

        // Shina returns "How to use SpringBoot in Java"
        library.returnBook("123456789", member1);

        // Display available books again
        System.out.println("Available books after return:");
        library.displayAvailableBooks();

        // Search for books by title
        System.out.println("Search for books titled 'How to use SpringBoot in Java':");
        for (Book book : library.searchBooksByTitle("How to use SpringBoot in Java")) {
            System.out.println(book);
        }

        // Search for books by author
        System.out.println("Search for books by Olusola Alao:");
        for (Book book : library.searchBooksByAuthor("Olusola Alao")) {
            System.out.println(book);
        }
    }
}

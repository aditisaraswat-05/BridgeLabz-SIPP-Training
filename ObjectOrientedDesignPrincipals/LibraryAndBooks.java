package ObjectOrientedDesignPrincipals;

import java.util.ArrayList;
import java.util.List;

// Book class (can exist independently)
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class (aggregates books)
class Library {
    String name;
    List<Book> books; // Aggregation: Library has a list of books

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void displayLibrary() {
        System.out.println("Library: " + name);
        System.out.println("Books in Library:");
        for (Book book : books) {
            book.displayBook();
        }
        System.out.println();
    }
}

// Main class to test
public class LibraryAndBooks {
    public static void main(String[] args) {
        // Create book objects (independent of any library)
        Book b1 = new Book("Java Programming", "Herbert Schildt");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Effective Java", "Joshua Bloch");

        // Create two libraries
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Community Library");

        // Add books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // Same book can be in multiple libraries
        lib2.addBook(b3);

        // Display libraries and their books
        lib1.displayLibrary();
        lib2.displayLibrary();
    }
}

// Problem 1: Library and Books (Aggregation)
// Description: Create a Library class that contains multiple Book objects.
// Model the relationship such that a library can have many books, but a book
// can exist independently (outside of a specific library).
// Tasks:
// Define a Library class with an ArrayList of Book objects.
// Define a Book class with attributes such as title and author.
// Demonstrate the aggregation relationship by creating books and adding them to
// different libraries.
// Goal: Understand aggregation by modeling a real-world relationship where the
// Library aggregates Book objects.

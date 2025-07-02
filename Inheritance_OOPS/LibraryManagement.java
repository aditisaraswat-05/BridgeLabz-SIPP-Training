package Inheritance_OOPS;

// Superclass
class Book {
    String title;
    int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String name;
    String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear); // Call to Book constructor
        this.name = name;
        this.bio = bio;
    }

    // Override displayInfo() to include author details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Show book details
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class to run the code
public class LibraryManagement {
    public static void main(String[] args) {
        Author bookWithAuthor = new Author(
                "Wings of Fire", 1999, "A.P.J. Abdul Kalam", "Former President of India and renowned scientist.");

        System.out.println("=== Book and Author Details ===");
        bookWithAuthor.displayInfo();
    }
}

// Sample Problem 1: Library Management with Books and Authors
// Description: Model a Book system where Book is the superclass, and Author is
// a subclass.
// Tasks:
// Define a superclass Book with attributes like title and publicationYear.
// Define a subclass Author with additional attributes like name and bio.
// Create a method displayInfo() to show details of the book and its author.
// Goal: Practice single inheritance by extending the base class and adding more
// specific details in the subclass.

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
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass
class Author extends Book {
    String authorName;
    String authorBio;

    public Author(String title, int publicationYear, String authorName, String authorBio) {
        super(title, publicationYear); // Call to Book constructor
        this.authorName = authorName;
        this.authorBio = authorBio;
    }

    // Overriding displayInfo to include author details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display book details
        System.out.println("Author Name: " + authorName);
        System.out.println("Author Bio: " + authorBio);
    }
}

// Main class
public class SmartHomeDevice {
    public static void main(String[] args) {
        Author book1 = new Author(
                "The Discovery of India",
                1946,
                "Jawaharlal Nehru",
                "First Prime Minister of India, a writer and visionary leader.");

        System.out.println("=== Book and Author Details ===");
        book1.displayInfo();
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

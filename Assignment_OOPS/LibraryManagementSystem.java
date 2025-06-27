package Assignment_OOPS;

class Book {
    // Static variable shared across all instances
    static String libraryName = "City Central Library";

    // Static method to display the library name
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final variable - cannot be changed once initialized

    // Constructor using 'this' keyword
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Method to display book details (with instanceof check)
    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Book Title : " + title);
            System.out.println("Author     : " + author);
            System.out.println("ISBN       : " + isbn);
        } else {
            System.out.println("Object is not a Book.");
        }
    }
}

// Main class to test the program
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Display library name using static method
        Book.displayLibraryName();

        // Creating Book objects
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "ISBN123456");
        Book book2 = new Book("1984", "George Orwell", "ISBN789101");

        // Display book details
        System.out.println("\nBook 1 Details:");
        book1.displayDetails();

        System.out.println("\nBook 2 Details:");
        book2.displayDetails();

        // Test instanceof with unrelated object
        Object obj = new String("Not a Book");
        if (obj instanceof Book) {
            ((Book) obj).displayDetails();
        } else {
            System.out.println("\nObject is not a Book.");
        }
    }
}

// Sample Program 2: Library Management System
// Create a Book class to manage library books with the following features:
// Static:
// ○ A static variable libraryName shared across all books.
// ○ A static method displayLibraryName() to print the library name.
// This:
// ○ Use this to initialize title, author, and isbn in the constructor.
// Final:
// ○ Use a final variable isbn to ensure the unique identifier of a book cannot
// be changed.
// Instanceof:
// ○ Verify if an object is an instance of the Book class before displaying its
// details.

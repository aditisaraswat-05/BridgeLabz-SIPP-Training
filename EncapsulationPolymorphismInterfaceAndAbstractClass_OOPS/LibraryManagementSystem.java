package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// Reservable interface
interface Reservable {
    void reserveItem(String borrowerName);

    boolean checkAvailability();
}

// Abstract class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower; // Encapsulated sensitive data
    private boolean isAvailable;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.borrower = "";
    }

    // Getters and Setters (Encapsulation)
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    protected String getBorrower() {
        return borrower;
    }

    protected void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Reserved by " + borrower));
    }
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println(borrowerName + " reserved the book \"" + getTitle() + "\".");
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7; // 1 week
    }

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println(borrowerName + " reserved the magazine \"" + getTitle() + "\".");
        } else {
            System.out.println("Magazine is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    public void reserveItem(String borrowerName) {
        if (checkAvailability()) {
            setBorrower(borrowerName);
            setAvailable(false);
            System.out.println(borrowerName + " reserved the DVD \"" + getTitle() + "\".");
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Main class
public class LibraryManagementSystem {
    public static void displayAllItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println("\n--- Library Item Details ---");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
        }
    }

    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        LibraryItem book1 = new Book("B101", "Java Programming", "James Gosling");
        LibraryItem mag1 = new Magazine("M201", "Science Monthly", "Editor Group");
        LibraryItem dvd1 = new DVD("D301", "Inception", "Christopher Nolan");

        items.add(book1);
        items.add(mag1);
        items.add(dvd1);

        // Reserve some items
        ((Reservable) book1).reserveItem("Aditi");
        ((Reservable) dvd1).reserveItem("Ravi");

        // Polymorphic processing
        displayAllItems(items);
    }
}

// Library Management System
// Description: Develop a library management system:
// Use an abstract class LibraryItem with fields like itemId, title, and author.
// Add an abstract method getLoanDuration() and a concrete method
// getItemDetails().
// Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with
// specific logic.
// Implement an interface Reservable with methods reserveItem() and
// checkAvailability().
// Apply encapsulation to secure details like the borrower’s personal data.
// Use polymorphism to allow a general LibraryItem reference to manage all
// items, regardless of type.

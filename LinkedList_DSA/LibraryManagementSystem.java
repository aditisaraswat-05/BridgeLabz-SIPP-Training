package LinkedList_DSA;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next, prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    // Add at beginning
    public void addAtBeginning(Book newBook) {
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    public void addAtEnd(Book newBook) {
        if (head == null) {
            addAtBeginning(newBook);
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at position (1-based)
    public void addAtPosition(Book newBook, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newBook);
            return;
        }

        Book temp = head;
        for (int i = 1; i < position - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        if (temp.next == null) {
            addAtEnd(newBook);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
    }

    // Remove by Book ID
    public void removeById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book ID not found.");
            return;
        }

        if (temp == head && temp == tail) {
            head = tail = null;
        } else if (temp == head) {
            head = head.next;
            head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }

        System.out.println("Book removed.");
    }

    // Search by title or author
    public void search(String keyword, boolean searchByTitle) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if ((searchByTitle && temp.title.equalsIgnoreCase(keyword)) ||
                    (!searchByTitle && temp.author.equalsIgnoreCase(keyword))) {
                System.out.println("Found: " + temp.title + " | " + temp.author + " | " +
                        temp.genre + " | ID: " + temp.bookId + " | Available: " + temp.isAvailable);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // Update availability
    public void updateAvailability(int bookId, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = status;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display all books (forward)
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\n--- Books in Library (Forward) ---");
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre +
                    " | ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    // Display all books (reverse)
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("\n--- Books in Library (Reverse) ---");
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.author + " | " + temp.genre +
                    " | ID: " + temp.bookId + " | Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display All (Forward)");
            System.out.println("9. Display All (Reverse)");
            System.out.println("10. Count Total Books");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Is Available? (true/false): ");
                    boolean available = sc.nextBoolean();

                    Book newBook = new Book(title, author, genre, id, available);

                    if (choice == 1)
                        library.addAtBeginning(newBook);
                    else if (choice == 2)
                        library.addAtEnd(newBook);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        library.addAtPosition(newBook, pos);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    library.removeById(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Book Title: ");
                    library.search(sc.nextLine(), true);
                    break;

                case 6:
                    System.out.print("Enter Author Name: ");
                    library.search(sc.nextLine(), false);
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Availability (true/false): ");
                    boolean status = sc.nextBoolean();
                    library.updateAvailability(id, status);
                    break;

                case 8:
                    library.displayForward();
                    break;

                case 9:
                    library.displayReverse();
                    break;

                case 10:
                    library.countBooks();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        sc.close();
    }
}

// 5. Doubly Linked List: Library Management System
// Problem Statement: Design a library management system using a doubly linked
// list. Each node represents a book and contains the following attributes: Book
// Title, Author, Genre, Book ID, and Availability Status. Implement the
// following functionalities:
// Add a new book at the beginning, end, or at a specific position.
// Remove a book by Book ID.
// Search for a book by Book Title or Author.
// Update a book’s Availability Status.
// Display all books in forward and reverse order.
// Count the total number of books in the library.
// Hint:
// Use a doubly linked list with two pointers (next and prev) in each node to
// facilitate traversal in both directions.
// Ensure that when removing a book, both the next and prev pointers are
// correctly updated.
// Displaying in reverse order will require traversal from the last node using
// prev pointers.

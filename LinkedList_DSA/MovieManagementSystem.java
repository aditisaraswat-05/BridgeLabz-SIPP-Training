package LinkedList_DSA;

import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    float rating;
    Movie next, prev;

    public Movie(String title, String director, int year, float rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

class MovieDoublyLinkedList {
    private Movie head, tail;

    // Add at beginning
    public void addAtBeginning(Movie newMovie) {
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    public void addAtEnd(Movie newMovie) {
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (1-based)
    public void addAtPosition(Movie newMovie, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newMovie);
            return;
        }

        Movie temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(newMovie);
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove by title
    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director or rating
    public void search(String keyword, boolean searchByDirector) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if ((searchByDirector && temp.director.equalsIgnoreCase(keyword)) ||
                    (!searchByDirector && String.valueOf(temp.rating).equals(keyword))) {
                System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found with that " + (searchByDirector ? "director." : "rating."));
        }
    }

    // Update rating by title
    public void updateRating(String title, float newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("\n--- Movie List (Forward) ---");
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("\n--- Movie List (Reverse) ---");
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " | " + temp.director + " | " + temp.year + " | " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n--- Movie Management Menu ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Movie Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();
                    System.out.print("Enter Year of Release: ");
                    int year = sc.nextInt();
                    System.out.print("Enter Rating: ");
                    float rating = sc.nextFloat();
                    Movie newMovie = new Movie(title, director, year, rating);

                    if (choice == 1)
                        movieList.addAtBeginning(newMovie);
                    else if (choice == 2)
                        movieList.addAtEnd(newMovie);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        movieList.addAtPosition(newMovie, pos);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter title to remove: ");
                    String titleToRemove = sc.nextLine();
                    movieList.removeByTitle(titleToRemove);
                    break;

                case 5:
                    System.out.print("Enter director name: ");
                    String directorSearch = sc.nextLine();
                    movieList.search(directorSearch, true);
                    break;

                case 6:
                    System.out.print("Enter rating to search: ");
                    String ratingSearch = sc.nextLine();
                    movieList.search(ratingSearch, false);
                    break;

                case 7:
                    System.out.print("Enter movie title: ");
                    String titleToUpdate = sc.nextLine();
                    System.out.print("Enter new rating: ");
                    float newRating = sc.nextFloat();
                    movieList.updateRating(titleToUpdate, newRating);
                    break;

                case 8:
                    movieList.displayForward();
                    break;

                case 9:
                    movieList.displayReverse();
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

// 2. Doubly Linked List: Movie Management System
// Problem Statement: Implement a movie management system using a doubly linked
// list. Each node will represent a movie and contain Movie Title, Director,
// Year of Release, and Rating. Implement the following functionalities:
// Add a movie record at the beginning, end, or at a specific position.
// Remove a movie record by Movie Title.
// Search for a movie record by Director or Rating.
// Display all movie records in both forward and reverse order.
// Update a movie's Rating based on the Movie Title.
// Hint:
// Use a doubly linked list where each node has two pointers: one pointing to
// the next node and the other to the previous node.
// Maintain pointers to both the head and tail for easier insertion and deletion
// at both ends.
// For reverse display, start from the tail and traverse backward using the prev
// pointers.

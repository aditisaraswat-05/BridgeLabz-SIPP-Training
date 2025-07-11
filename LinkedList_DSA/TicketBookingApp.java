package LinkedList_DSA;

import java.util.*;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;

    // Add a new ticket reservation at the end
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);

        if (head == null) {
            head = newTicket;
            newTicket.next = head;
        } else {
            Ticket temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }

        System.out.println("Ticket booked successfully for " + customerName + "!");
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to cancel.");
            return;
        }

        Ticket curr = head;
        Ticket prev = null;

        do {
            if (curr.ticketID == ticketID) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    Ticket last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Ticket ID " + ticketID + " has been cancelled.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Ticket ID not found.");
    }

    // Display all booked tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No booked tickets.");
            return;
        }

        Ticket temp = head;
        System.out.println("\n--- Booked Tickets ---");
        do {
            System.out.println("Ticket ID: " + temp.ticketID +
                    ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by customer or movie name
    public void searchTicket(String key) {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }

        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(key) || temp.movieName.equalsIgnoreCase(key)) {
                System.out.println("Ticket Found → ID: " + temp.ticketID +
                        ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber +
                        ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }

    // Count total booked tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total Tickets Booked: " + count);
    }
}

public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        int ticketCounter = 1;

        while (true) {
            System.out.println("\n--- Online Ticket Reservation ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Booked Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Booking Time: ");
                    String time = sc.nextLine();

                    system.addTicket(ticketCounter++, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int id = sc.nextInt();
                    system.removeTicket(id);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer or Movie Name to search: ");
                    String key = sc.nextLine();
                    system.searchTicket(key);
                    break;

                case 5:
                    system.countTickets();
                    break;

                case 6:
                    System.out.println("Thank you for using the system.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

// 9. Circular Linked List: Online Ticket Reservation System
// Problem Statement: Design an online ticket reservation system using a
// circular linked list, where each node represents a booked ticket. Each node
// will store the following information: Ticket ID, Customer Name, Movie Name,
// Seat Number, and Booking Time. Implement the following functionalities:
// Add a new ticket reservation at the end of the circular list.
// Remove a ticket by Ticket ID.
// Display the current tickets in the list.
// Search for a ticket by Customer Name or Movie Name.
// Calculate the total number of booked tickets.

// Hint:
// Use a circular linked list to represent the ticket reservations, with the
// last node’s next pointer pointing to the first node.
// When removing a ticket, update the circular pointers accordingly.
// For displaying all tickets, traverse the list starting from the first node,
// looping back after reaching the last node.

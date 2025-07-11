package LinkedList_DSA;

import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryList {
    private Item head;

    // Add at beginning
    public void addAtBeginning(Item newItem) {
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(Item newItem) {
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newItem;
    }

    // Add at specific position
    public void addAtPosition(Item newItem, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newItem);
            return;
        }

        Item temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(newItem);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove by Item ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Item removed.");
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID or Name
    public void search(String keyword, boolean searchById) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if ((searchById && String.valueOf(temp.id).equals(keyword)) ||
                    (!searchById && temp.name.equalsIgnoreCase(keyword))) {
                System.out.println("Found: " + temp.name + " | ID: " + temp.id +
                        " | Qty: " + temp.quantity + " | Price: " + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Calculate total value
    public void totalInventoryValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Display all items
    public void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n--- Inventory List ---");
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.name + " | ID: " + temp.id +
                    " | Qty: " + temp.quantity + " | Price: ₹" + temp.price);
            temp = temp.next;
        }
    }

    // Sort by Name or Price (Merge Sort)
    public void sort(boolean sortByName, boolean ascending) {
        head = mergeSort(head, sortByName, ascending);
        System.out.println("Inventory sorted.");
    }

    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(nextToMiddle, sortByName, ascending);

        return sortedMerge(left, right, sortByName, ascending);
    }

    private Item sortedMerge(Item a, Item b, boolean sortByName, boolean ascending) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        int cmp;
        if (sortByName)
            cmp = a.name.compareToIgnoreCase(b.name);
        else
            cmp = Double.compare(a.price, b.price);

        if (!ascending)
            cmp *= -1;

        Item result;
        if (cmp <= 0) {
            result = a;
            result.next = sortedMerge(a.next, b, sortByName, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, sortByName, ascending);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null)
            return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryMangementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryList inventory = new InventoryList();
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Total Inventory Value");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    Item item = new Item(name, id, qty, price);

                    if (choice == 1)
                        inventory.addAtBeginning(item);
                    else if (choice == 2)
                        inventory.addAtEnd(item);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(item, pos);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    inventory.removeById(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(id, newQty);
                    break;

                case 6:
                    System.out.print("Enter Item ID to search: ");
                    inventory.search(sc.next(), true);
                    break;

                case 7:
                    System.out.print("Enter Item Name to search: ");
                    inventory.search(sc.nextLine(), false);
                    break;

                case 8:
                    inventory.displayAll();
                    break;

                case 9:
                    inventory.totalInventoryValue();
                    break;

                case 10:
                case 11: {
                    boolean byName = choice == 10;
                    System.out.print("1. Ascending  2. Descending: ");
                    int sortChoice = sc.nextInt();
                    inventory.sort(byName, sortChoice == 1);
                    break;
                }

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

// 4. Singly Linked List: Inventory Management System
// Problem Statement: Design an inventory management system using a singly
// linked list where each node stores information about an item such as Item
// Name, Item ID, Quantity, and Price. Implement the following functionalities:
// Add an item at the beginning, end, or at a specific position.
// Remove an item based on Item ID.
// Update the quantity of an item by Item ID.
// Search for an item based on Item ID or Item Name.
// Calculate and display the total value of inventory (Sum of Price * Quantity
// for each item).
// Sort the inventory based on Item Name or Price in ascending or descending
// order.
// Hint:
// Use a singly linked list where each node represents an item in the inventory.
// Implement sorting using an appropriate algorithm (e.g., merge sort) on the
// linked list.
// For total value calculation, traverse through the list and sum up Quantity *
// Price for each item.

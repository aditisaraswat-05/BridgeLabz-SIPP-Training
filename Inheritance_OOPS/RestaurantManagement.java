package Inheritance_OOPS;

// Superclass
class Person {
    String name;
    int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties(); // Abstract method to be implemented by all workers
}

// Chef class: inherits from Person and implements Worker
class Chef extends Person implements Worker {

    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef Duties: Prepares meals, manages the kitchen.");
    }
}

// Waiter class: inherits from Person and implements Worker
class Waiter extends Person implements Worker {

    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter Duties: Takes orders and serves food to customers.");
    }
}

// Main class
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Ravi", 101);
        Waiter waiter = new Waiter("Anita", 201);

        System.out.println("=== Chef Info ===");
        chef.displayInfo();
        chef.performDuties();

        System.out.println("\n=== Waiter Info ===");
        waiter.displayInfo();
        waiter.performDuties();
    }
}

// Sample Problem 1: Restaurant Management System with Hybrid Inheritance
// Description: Model a restaurant system where Person is the superclass and
// Chef and Waiter are subclasses. Both Chef and Waiter should implement a
// Worker interface that requires a performDuties() method.
// Tasks:
// Define a superclass Person with attributes like name and id.
// Create an interface Worker with a method performDuties().
// Define subclasses Chef and Waiter that inherit from Person and implement the
// Worker interface, each providing a unique implementation of performDuties().
// Goal: Practice hybrid inheritance by combining inheritance and interfaces,
// giving multiple behaviors to the same objects.
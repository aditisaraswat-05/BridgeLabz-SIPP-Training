package Assigment_OOPS;

// Employee.java
class Employee {
    // Static variable shared by all employees
    static String companyName = "TechVision Pvt. Ltd.";

    // Static counter to count total employees
    static int totalEmployees = 0;

    // Instance variables
    private String name;
    private final String id; // Final: cannot be changed after assignment
    private String designation;

    // Constructor using 'this' to initialize values
    public Employee(String name, String id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++; // Increments every time a new employee is created
    }

    // Static method to show total employees
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details using instanceof
    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("Employee Name   : " + name);
            System.out.println("Employee ID     : " + id);
            System.out.println("Designation     : " + designation);
            System.out.println("Company Name    : " + companyName);
        } else {
            System.out.println("Object is not an instance of Employee.");
        }
    }
}

// Main class with main() method
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating employee objects
        Employee emp1 = new Employee("Anjali", "E101", "Software Engineer");
        Employee emp2 = new Employee("Rahul", "E102", "Project Manager");

        // Displaying employee details
        System.out.println("\nEmployee 1 Details:");
        emp1.displayDetails();

        System.out.println("\nEmployee 2 Details:");
        emp2.displayDetails();

        // Showing total number of employees
        System.out.println();
        Employee.displayTotalEmployees();

        // instanceof test with a non-employee object
        Object test = new String("Not an employee");
        if (test instanceof Employee) {
            ((Employee) test).displayDetails();
        } else {
            System.out.println("\nObject is not an instance of Employee.");
        }
    }
}

// Sample Program 3: Employee Management System
// Design an Employee class with the following features:
// Static:
// ○ A static variable companyName shared by all employees.
// ○ A static method displayTotalEmployees() to show the total number of
// employees.
// This:
// ○ Use this to initialize name, id, and designation in the constructor.
// Final:
// ○ Use a final variable id for the employee ID, which cannot be modified after
// assignment.
// Instanceof
// ○ Check if a given object is an instance of the Employee class before
// printing the employee details.

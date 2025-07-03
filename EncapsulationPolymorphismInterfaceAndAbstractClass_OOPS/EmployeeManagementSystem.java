package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// Interface for department operations
interface Department {
    void assignDepartment(String deptName);

    String getDepartmentDetails();
}

// Abstract base class for all employees
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Encapsulation - Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Department: " + department);
        System.out.println("Calculated Salary: " + calculateSalary());
    }

    // Interface methods for Department
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    public String getDepartmentDetails() {
        return department;
    }
}

// Full-time employee subclass
class FullTimeEmployee extends Employee {
    private double bonus;

    public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

// Part-time employee subclass
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0); // baseSalary not used directly
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

// Main class to test the system
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Alice", 50000, 10000);
        emp1.assignDepartment("HR");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Bob", 500, 40);
        emp2.assignDepartment("Support");

        employees.add(emp1);
        employees.add(emp2);

        // Polymorphism: using Employee reference
        for (Employee emp : employees) {
            System.out.println("\n--- Employee Details ---");
            emp.displayDetails();
        }
    }
}

// 1. Employee Management System
// Description: Build an employee management system with the following
// requirements:
// Use an abstract class Employee with fields like employeeId, name, and
// baseSalary.
// Provide an abstract method calculateSalary() and a concrete method
// displayDetails().
// Create two subclasses: FullTimeEmployee and PartTimeEmployee, implementing
// calculateSalary() based on work hours or fixed salary.
// Use encapsulation to restrict direct access to fields and provide getter and
// setter methods.
// Create an interface Department with methods like assignDepartment() and
// getDepartmentDetails().
// Ensure polymorphism by processing a list of employees and displaying their
// details using the Employee reference.
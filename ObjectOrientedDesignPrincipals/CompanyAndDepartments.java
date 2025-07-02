package ObjectOrientedDesignPrincipals;

import java.util.*;

// Employee class (tightly bound to Department)
class Employee {
    String name;
    String designation;

    Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    void displayEmployee() {
        System.out.println("   - " + name + " (" + designation + ")");
    }
}

// Department class (composed within Company)
class Department {
    String deptName;
    List<Employee> employees;

    Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    void addEmployee(String name, String designation) {
        employees.add(new Employee(name, designation));
    }

    void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }
}

// Company class (composes departments and employees)
class Company {
    String companyName;
    List<Department> departments;

    Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    void addDepartment(Department dept) {
        departments.add(dept);
    }

    void displayCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department dept : departments) {
            dept.displayDepartment();
            System.out.println();
        }
    }

    void deleteCompany() {
        System.out.println("\nDeleting company and all associated departments and employees...");
        departments.clear(); // All departments (and their employees) are removed
        System.out.println("Company " + companyName + " deleted.\n");
    }
}

// Main class
public class CompanyAndDepartments {
    public static void main(String[] args) {
        // Create company
        Company myCompany = new Company("TechNova Pvt Ltd");

        // Create departments
        Department dev = new Department("Development");
        dev.addEmployee("Alice", "Software Engineer");
        dev.addEmployee("Bob", "Senior Developer");

        Department hr = new Department("Human Resources");
        hr.addEmployee("Charlie", "HR Manager");

        // Add departments to company
        myCompany.addDepartment(dev);
        myCompany.addDepartment(hr);

        // Display structure
        myCompany.displayCompanyStructure();

        // Delete company (and all contained departments/employees)
        myCompany.deleteCompany();

        // Try displaying again
        myCompany.displayCompanyStructure(); // Should show nothing
    }
}

// Problem 3: Company and Departments (Composition)
// Description: A Company has several Department objects, and each department
// contains Employee objects. Model this using composition, where deleting a
// company should also delete all departments and employees.
// Tasks:
// Define a Company class that contains multiple Department objects.
// Define an Employee class within each Department.
// Show the composition relationship by ensuring that when a Company object is
// deleted, all associated Department and Employee objects are also removed.
// Goal: Understand composition by implementing a relationship where Department
// and Employee objects cannot exist without a Company.
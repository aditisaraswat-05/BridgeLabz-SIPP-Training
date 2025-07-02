package Inheritance_OOPS;

// Superclass
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass - Teacher
class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass - Student
class Student extends Person {
    String grade;

    public Student(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass - Staff
class Staff extends Person {
    String department;

    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    public void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

// Main class to run the program
public class SchoolSystemWithDiffRoles {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Sharma", 40, "Mathematics");
        Student student = new Student("Aditi", 16, "10th Grade");
        Staff staff = new Staff("Mrs. Verma", 35, "Administration");

        System.out.println("=== Teacher Info ===");
        teacher.displayRole();

        System.out.println("\n=== Student Info ===");
        student.displayRole();

        System.out.println("\n=== Staff Info ===");
        staff.displayRole();
    }
}

// Sample Problem 2: School System with Different Roles
// Description: Create a hierarchy for a school system where Person is the
// superclass, and Teacher, Student, and Staff are subclasses.
// Tasks:
// Define a superclass Person with common attributes like name and age.
// Define subclasses Teacher, Student, and Staff with specific attributes (e.g.,
// subject for Teacher and grade for Student).
// Each subclass should have a method like displayRole() that describes the
// role.
// Goal: Demonstrate hierarchical inheritance by modeling different roles in a
// school, each with shared and unique characteristics.
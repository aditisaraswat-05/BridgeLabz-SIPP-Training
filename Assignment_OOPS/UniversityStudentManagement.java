package Assignment_OOPS;

public class UniversityStudentManagement {

    // Inner class: Student
    static class Student {
        // Static variable shared across all students
        static String universityName = "Global Tech University";

        // Static variable to count total students
        static int totalStudents = 0;

        // Static method to display total students
        static void displayTotalStudents() {
            System.out.println("Total Enrolled Students: " + totalStudents);
        }

        // Instance variables
        private String name;
        private final String rollNumber; // final: cannot be changed once assigned
        private char grade;

        // Constructor using 'this' keyword
        public Student(String name, String rollNumber, char grade) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            totalStudents++;
        }

        // Method to display student details using instanceof
        public void displayDetails() {
            if (this instanceof Student) {
                System.out.println("Student Name    : " + name);
                System.out.println("Roll Number     : " + rollNumber);
                System.out.println("Grade           : " + grade);
                System.out.println("University Name : " + universityName);
            } else {
                System.out.println("Not a valid Student object.");
            }
        }

        // Method to update grade (with instanceof check)
        public void updateGrade(char newGrade) {
            if (this instanceof Student) {
                System.out.println("Updating grade for " + name + " from " + grade + " to " + newGrade);
                this.grade = newGrade;
            } else {
                System.out.println("Cannot update grade: not a Student.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating Student objects
        Student s1 = new Student("Ravi Sharma", "STU101", 'A');
        Student s2 = new Student("Neha Gupta", "STU102", 'B');

        // Display student details
        System.out.println("\nStudent 1 Details:");
        s1.displayDetails();

        System.out.println("\nStudent 2 Details:");
        s2.displayDetails();

        // Update grade of a student
        System.out.println();
        s2.updateGrade('A');

        // Show details again
        System.out.println("\nStudent 2 Details (After Grade Update):");
        s2.displayDetails();

        // Display total students
        System.out.println();
        Student.displayTotalStudents();

        // Test with object not being a Student
        Object fakeStudent = new String("Not a student object");
        if (fakeStudent instanceof Student) {
            ((Student) fakeStudent).displayDetails();
        } else {
            System.out.println("\nObject is not an instance of Student.");
        }
    }
}

// Sample Program 5: University Student Management
// Create a Student class to manage student data with the following features:
// Static:
// ○ A static variable universityName shared across all students.
// ○ A static method displayTotalStudents() to show the number of students
// enrolled.
// This:
// ○ Use this in the constructor to initialize name, rollNumber, and grade.
// Final:
// ○ Use a final variable rollNumber for each student that cannot be changed.
// Instanceof:
// ○ Check if a given object is an instance of the Student class before
// performing operations like displaying or updating grades.
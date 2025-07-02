package ObjectOrientedDesignPrincipals;

import java.util.*;

// Professor class
class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Professor: " + name);
    }
}

// Student class
class Student {
    String name;
    List<Course> enrolledCourses;

    Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this); // Add student to the course
    }

    void displayCourses() {
        System.out.println("Student: " + name);
        System.out.println("Enrolled Courses:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.courseName);
        }
        System.out.println();
    }
}

// Course class
class Course {
    String courseName;
    Professor professor;
    List<Student> students;

    Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    void assignProfessor(Professor prof) {
        this.professor = prof;
    }

    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            professor.display();
        } else {
            System.out.println("Professor: Not Assigned");
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
        System.out.println();
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        // Create professors
        Professor prof1 = new Professor("Dr. Mehta");
        Professor prof2 = new Professor("Dr. Roy");

        // Create courses
        Course javaCourse = new Course("Java Programming");
        Course dbmsCourse = new Course("Database Systems");

        // Assign professors to courses
        javaCourse.assignProfessor(prof1);
        dbmsCourse.assignProfessor(prof2);

        // Create students
        Student s1 = new Student("Aditi");
        Student s2 = new Student("Rahul");

        // Students enroll in courses
        s1.enrollCourse(javaCourse);
        s1.enrollCourse(dbmsCourse);

        s2.enrollCourse(javaCourse);

        // Display data
        s1.displayCourses();
        s2.displayCourses();

        javaCourse.displayCourseDetails();
        dbmsCourse.displayCourseDetails();
    }
}

// Problem 5: University Management System
// Description: Model a university system with Student, Professor, and Course
// classes. Students enroll in courses, and professors teach courses. Ensure
// students and professors can communicate through methods like enrollCourse()
// and assignProfessor().
// Goal: Use association and aggregation to create a university system that
// emphasizes relationships and interactions among students, professors, and
// courses.

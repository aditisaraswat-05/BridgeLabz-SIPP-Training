package Java_Generics;

import java.util.*;

// Abstract class for course type
abstract class CourseType {
    private String title;

    public CourseType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract String getEvaluationMethod();
}

// Exam-based course
class ExamCourse extends CourseType {
    public ExamCourse(String title) {
        super(title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Exam-Based Evaluation";
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title) {
        super(title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Assignment-Based Evaluation";
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    public ResearchCourse(String title) {
        super(title);
    }

    @Override
    public String getEvaluationMethod() {
        return "Research-Based Evaluation";
    }
}

// Generic class for managing courses
class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }
}

// Utility class to display any course type
class CourseUtils {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println("Course: " + c.getTitle());
            System.out.println("Evaluation: " + c.getEvaluationMethod());
            System.out.println();
        }
    }
}

// Main class to test the system
public class UniversityCourseMangementySystem {
    public static void main(String[] args) {
        Course<ExamCourse> examDept = new Course<>();
        examDept.addCourse(new ExamCourse("Mathematics"));
        examDept.addCourse(new ExamCourse("Physics"));

        Course<AssignmentCourse> assignmentDept = new Course<>();
        assignmentDept.addCourse(new AssignmentCourse("Creative Writing"));
        assignmentDept.addCourse(new AssignmentCourse("History"));

        Course<ResearchCourse> researchDept = new Course<>();
        researchDept.addCourse(new ResearchCourse("AI Research"));
        researchDept.addCourse(new ResearchCourse("Quantum Computing"));

        System.out.println("=== Exam-Based Courses ===");
        CourseUtils.displayCourses(examDept.getCourses());

        System.out.println("=== Assignment-Based Courses ===");
        CourseUtils.displayCourses(assignmentDept.getCourses());

        System.out.println("=== Research-Based Courses ===");
        CourseUtils.displayCourses(researchDept.getCourses());
    }
}

// 3. Multi-Level University Course Management System
// Concepts: Generic Classes, Wildcards, Bounded Type Parameters
// Problem Statement:
// Develop a university course management system where different departments
// offer courses with different evaluation types (e.g., Exam-Based,
// Assignment-Based, Research-Based).
// Hints:
// Create an abstract class CourseType (e.g., ExamCourse, AssignmentCourse,
// ResearchCourse).
// Implement a generic class Course<T extends CourseType> to manage different
// courses.
// Use wildcards (List<? extends CourseType>) to handle any type of course
// dynamically.

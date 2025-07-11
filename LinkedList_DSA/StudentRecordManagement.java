package LinkedList_DSA;

import java.util.Scanner;

class Student {
    int rollNo;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    // Add at beginning
    public void addAtBeginning(Student newStudent) {
        newStudent.next = head;
        head = newStudent;
    }

    // Add at end
    public void addAtEnd(Student newStudent) {
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add at specific position (1-based)
    public void addAtPosition(Student newStudent, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newStudent);
            return;
        }

        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            addAtEnd(newStudent);
            return;
        }

        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete by roll number
    public void deleteByRollNumber(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next;
            System.out.println("Record deleted.");
            return;
        }

        Student temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Roll number not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Record deleted.");
    }

    // Search by roll number
    public void searchByRollNumber(int rollNo) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: " + temp.rollNo + " " + temp.name + " " + temp.age + " " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll number not found.");
    }

    // Update grade by roll number
    public void updateGrade(int rollNo, char newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll number not found.");
    }

    // Display all records
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNo + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: "
                    + temp.grade);
            temp = temp.next;
        }
    }
}

public class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;

        do {
            System.out.println("\n--- Student Record Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display All");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3: {
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Grade: ");
                    char grade = sc.next().charAt(0);
                    Student newStudent = new Student(roll, name, age, grade);

                    if (choice == 1)
                        list.addAtBeginning(newStudent);
                    else if (choice == 2)
                        list.addAtEnd(newStudent);
                    else {
                        System.out.print("Enter position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(newStudent, pos);
                    }
                    break;
                }

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int rollToDelete = sc.nextInt();
                    list.deleteByRollNumber(rollToDelete);
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    int rollToSearch = sc.nextInt();
                    list.searchByRollNumber(rollToSearch);
                    break;

                case 6:
                    System.out.print("Enter Roll No to update: ");
                    int rollToUpdate = sc.nextInt();
                    System.out.print("Enter new grade: ");
                    char newGrade = sc.next().charAt(0);
                    list.updateGrade(rollToUpdate, newGrade);
                    break;

                case 7:
                    list.displayAll();
                    break;

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

// 1. Singly Linked List: Student Record Management
// Problem Statement: Create a program to manage student records using a singly
// linked list. Each node will store information about a student, including
// their Roll Number, Name, Age, and Grade. Implement the following operations:
// Add a new student record at the beginning, end, or at a specific position.
// Delete a student record by Roll Number.
// Search for a student record by Roll Number.
// Display all student records.
// Update a student's grade based on their Roll Number.
// Hint:
// Use a singly linked list where each node contains student information and a
// pointer to the next node.
// The head of the list will represent the first student, and the last node’s
// next pointer will be null.
// Update the next pointers when inserting or deleting nodes.
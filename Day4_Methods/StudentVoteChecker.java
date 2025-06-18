package Day4_Methods;

import java.util.Scanner;

public class StudentVoteChecker {

    // Method to check voting eligibility
    public boolean canStudentVote(int age) {
        if (age < 0) {
            // Negative age not valid, can't vote
            return false;
        } else if (age >= 18) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10];

        System.out.println("Enter the ages of 10 students:");

        // Take user input for ages
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        System.out.println("\nVoting eligibility results:");

        // Check and display voting eligibility
        for (int i = 0; i < ages.length; i++) {
            boolean canVote = checker.canStudentVote(ages[i]);
            if (canVote) {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") can vote.");
            } else {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") cannot vote.");
            }
        }

        scanner.close();
    }
}

// CP - Write a program to take user input for the age of all 10 students in a
// class and check whether the student can vote depending on his/her age is
// greater or
// equal to 18.
// Hint =>
// 1. Create a class
// public class StudentVoteChecker,
// and define a method
// public boolean canStudentVote(int age)
// which takes in age as a parameter and returns true or false.
// 2. Inside the method firstly validate the age for a negative number, if a
// negative return is false cannot vote. For valid age check for age is 18 or
// above return
// true; else return false;
// 3. In the main function, define an array of 10 integer elements, loop through
// the array by take user input for the student's age, call canStudentVote(),
// and
// display the result

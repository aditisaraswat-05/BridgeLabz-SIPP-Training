package Day4_Strings;

import java.util.Scanner;
import java.util.Random;

public class VotingEligibility {

    // Method to generate random 2-digit ages for n students
    public static int[] generateRandomAges(int n) {
        int[] ages = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            // Random age between 10 and 99 (2-digit)
            ages[i] = rand.nextInt(90) + 10; // 10 to 99 inclusive
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D array of age and eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            result[i][0] = String.valueOf(age);
            if (age < 0) {
                result[i][1] = "false"; // negative age, cannot vote
            } else {
                result[i][1] = (age >= 18) ? "true" : "false";
            }
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("\nAge\tCan Vote?");
        System.out.println("-----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int STUDENT_COUNT = 10;
        int[] ages = new int[STUDENT_COUNT];

        // Take user input for ages
        System.out.println("Enter the ages of " + STUDENT_COUNT + " students:");
        for (int i = 0; i < STUDENT_COUNT; i++) {
            System.out.print("Age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();
        }

        // Alternatively, to generate random ages, uncomment:
        // ages = generateRandomAges(STUDENT_COUNT);

        String[][] eligibilityData = checkVotingEligibility(ages);

        displayResult(eligibilityData);

        scanner.close();
    }
}

// CP - Write a program to take user input for the age of all 10 students in a
// class and check whether the student can vote depending on his/her age is
// greater or
// equal to 18.
// Hint =>
// 1. Create a method to define the random 2-digit age of several students
// provided as method parameters and return a 1D array of ages of n students
// 2. Create a method that takes an array of ages as a parameter and returns a
// 2D String array of age and a boolean true or false to indicate can and cannot
// vote. Inside the method firstly validate the age for a negative number, if a
// negative cannot vote. The valid age check for age is 18 or above to set true
// to
// indicate can vote.
// 3. Create a method to display the 2D array in a tabular format.
// 4. Finally, the main function takes user inputs, calls the user-defined
// methods, and displays the result.

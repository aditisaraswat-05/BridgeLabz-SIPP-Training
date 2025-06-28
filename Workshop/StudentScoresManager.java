package Workshop;

import java.util.Scanner;

public class StudentScoresManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter number of students: ");
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.print("Number must be greater than 0.Try again: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input.Enter a valid integer: ");
            }
        }

        int[] scores = new int[n];
        int sum = 0;

        // Input scores with validation
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                try {
                    int score = Integer.parseInt(sc.nextLine());
                    if (score < 0) {
                        System.out.println("Score cannot be negative. Try again.");
                        continue;
                    }
                    scores[i] = score;
                    sum += score;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        }

        // Calculate average
        double average = (double) sum / n;
        System.out.println("\nAverage Score: " + average);

        // Find highest and lowest
        int highest = scores[0], lowest = scores[0];
        for (int i = 1; i < n; i++) {
            if (scores[i] > highest)
                highest = scores[i];
            if (scores[i] < lowest)
                lowest = scores[i];
        }
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        // Display scores above average
        System.out.println("\nScores above average:");
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (scores[i] > average) {
                System.out.println("Student " + (i + 1) + ": " + scores[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student scored above average.");
        }

        sc.close();
    }
}

// Scenario: Develop a program to manage student Test scores. The program
// should:
// store the scores of n students in an array
// calculate and display the average score
// Find and display the highest and lowest score
// identify and display the scores above the average.
// Handle invalid input like negative scores or non-numeric input
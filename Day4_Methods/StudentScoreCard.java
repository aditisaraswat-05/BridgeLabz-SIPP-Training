package Day4_Methods;

import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Generate random 2‑digit scores for Physics, Chemistry, Math

        int[][] scores = generateRandomScores(n); // [n][3] (PCM)

        // Calculate total, average, percentage (rounded to 2 d.p.)

        double[][] stats = calculateStats(scores); // [n][3] (total, avg, %)

        printScoreCard(scores, stats);
        sc.close();
    }

    // Generates a 2‑D array with random 2‑digit marks (0‑99)
    private static int[][] generateRandomScores(int n) {
        int[][] arr = new int[n][3];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = rand.nextInt(100); // 0‑99 inclusive
            }
        }
        return arr;
    }

    // Returns [n][3] array → {total, average, percentage}
    // Values are rounded to 2 decimal places with Math.round()

    private static double[][] calculateStats(int[][] marks) {
        int n = marks.length;
        double[][] out = new double[n][3];

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = total / 300.0 * 100;

            // round to 2 digits
            average = Math.round(average * 100) / 100.0;
            percentage = Math.round(percentage * 100) / 100.0;

            out[i][0] = total;
            out[i][1] = average;
            out[i][2] = percentage;
        }
        return out;
    }
    // Prints the table using \t for neat columns

    private static void printScoreCard(int[][] marks, double[][] stats) {
        System.out.println("\nS.No\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%d\t%d\t%d\t\t%d\t%d\t%.2f\t%.2f%%\n",
                    (i + 1),
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    (int) stats[i][0],
                    stats[i][1],
                    stats[i][2]);
        }
    }
}

// CP - Create a program to take input marks of students in 3 subjects: physics,
// chemistry, and maths. Compute the total, average, and the percentage score
// Hint =>
// 1. Take input for the number of students
// 2. Write a method to generate random 2-digit scores for Physics, Chemistry,
// and Math (PCM) for the students and return the scores. This method returns a
// 2D array with PCM scores for all students
// 3. Write a Method to calculate the total, average, and percentages for each
// student and return a 2D array with the corresponding values. Please ensure to
// round off the values to 2 Digits using the Math.round() method.
// 4. Finally, write a Method to display the scorecard of all students with
// their scores, total, average, and percentage in a tabular format using "\t".
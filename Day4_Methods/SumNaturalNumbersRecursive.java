package Day4_Methods;

import java.util.Scanner;

public class SumNaturalNumbersRecursive {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number (positive integer): ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input! Please enter a positive integer.");
            return;
        }

        // Calculate sum using recursion
        int sumRecursive = sumRecursion(n);

        // Calculate sum using formula
        int sumFormula = sumFormula(n);

        // Compare and print results
        System.out.println("Sum using recursion: " + sumRecursive);
        System.out.println("Sum using formula:   " + sumFormula);

        if (sumRecursive == sumFormula) {
            System.out.println("Both results are equal. The calculation is correct!");
        } else {
            System.out.println("Results differ! There might be an error.");
        }

        scanner.close();
    }

    // Recursive method to find sum of n natural numbers
    public static int sumRecursion(int n) {
        if (n == 1) {
            return 1; // Base case
        }
        return n + sumRecursion(n - 1); // Recursive step
    }

    // Method to find sum of n natural numbers using formula
    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
}

// CP - Write a program to find the sum of n natural numbers using the recursive
// method and compare the result with the formulae n(n+1)/2* and show that the
// result from both computations is correct.
// Hint =>
// 1. Take the user input number and check whether it's a Natural number
// 2. Write a Method to find the sum of n natural numbers using recursion
// 3. Write a Method to find the sum of n natural numbers using the formulae
// n(n+1)/2
// Compare the two results and print the result
package Built_In_Functions;

import java.util.Scanner;

public class FibonacciGenerator {

    // Function to generate and print Fibonacci sequence
    public static void printFibonacci(int terms) {
        int first = 0, second = 1;

        System.out.print("Fibonacci Sequence: ");

        for (int i = 1; i <= terms; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println(); // For newline after sequence
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        // Call function to print Fibonacci sequence
        printFibonacci(n);

        scanner.close();
    }
}

// Fibonacci Sequence Generator:
// ○ Write a program that generates the Fibonacci sequence up to a specified
// number
// of terms entered by the user.
// ○ Organize the code by creating a function that calculates and prints the
// Fibonacci
// sequence.
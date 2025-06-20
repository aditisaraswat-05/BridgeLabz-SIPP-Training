package Built_In_Functions;

import java.util.Scanner;

public class FactorialRecursive {

    // Function to get user input
    public static int getInput(Scanner scanner) {
        System.out.print("Enter a non-negative number: ");
        return scanner.nextInt();
    }

    // Recursive function to calculate factorial
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Base case
        } else {
            return n * factorial(n - 1); // Recursive case
        }
    }

    // Function to display the result
    public static void displayResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = getInput(scanner);
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long result = factorial(number);
            displayResult(number, result);
        }

        scanner.close();
    }
}

// Factorial Using Recursion:
// ○ Write a program that calculates the factorial of a number using a recursive
// function.
// ○ Include modular code to separate input, calculation, and output processes.
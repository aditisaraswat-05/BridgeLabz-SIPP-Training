package Built_In_Functions;

import java.util.Scanner;

public class GCDandLCM {

    // Function to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Function to calculate LCM using formula: (a * b) / GCD
    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    // Function to take user input
    public static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Function to display results
    public static void displayResults(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        int num1 = getInput(scanner, "Enter first number: ");
        int num2 = getInput(scanner, "Enter second number: ");

        // Calculate GCD and LCM
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2);

        // Display results
        displayResults(num1, num2, gcd, lcm);

        scanner.close();
    }
}

// GCD and LCM Calculator:
// ○ Create a program that calculates the Greatest Common Divisor (GCD) and
// Least
// Common Multiple (LCM) of two numbers using functions.
// ○ Use separate functions for GCD and LCM calculations, showcasing how modular
// code works.
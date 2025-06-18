package Day4_Methods;

import java.util.Scanner;

public class DivisionCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dividend (number): ");
        int number = scanner.nextInt();

        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Check for division by zero
        if (divisor == 0) {
            System.out.println("Error: Division by zero is not allowed.");
        } else {
            // Call method
            int[] result = findRemainderAndQuotient(number, divisor);

            // Print result
            System.out.println("Quotient = " + result[1]);
            System.out.println("Remainder = " + result[0]);
        }

        scanner.close();
    }

    // Method to find remainder and quotient
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[] { remainder, quotient };
    }
}

// CP - Write a program to take 2 numbers and print their quotient and reminder
// Hint =>
// 1. Take user input as integer
// 2. Use the division operator (/) for the quotient and moduli operator (%) for
// remainder
// 3. Write Method to find the remainder and the quotient of a number
// public static int[] findRemainderAndQuotient(int number, int divisor)

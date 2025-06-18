package Day4_Methods;

import java.util.Scanner;

public class NumberAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\n--- Analysis ---");

        // Loop through array and analyze each number
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.print("Number " + num + ": ");

            if (isPositive(num)) {
                System.out.print("Positive, ");
                if (isEven(num)) {
                    System.out.println("Even");
                } else {
                    System.out.println("Odd");
                }
            } else {
                System.out.println("Negative");
            }
        }

        // Compare first and last element
        int compareResult = compare(numbers[0], numbers[4]);
        System.out.print("\nComparison of first and last element (" + numbers[0] + " vs " + numbers[4] + "): ");

        if (compareResult == 1) {
            System.out.println("First is greater than Last");
        } else if (compareResult == 0) {
            System.out.println("First is equal to Last");
        } else {
            System.out.println("First is less than Last");
        }

        scanner.close();
    }

    // Method 1: Check if number is positive
    public static boolean isPositive(int number) {
        return number >= 0;
    }

    // Method 2: Check if number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Method 3: Compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
}

// CP - Write a program to take user input for 5 numbers and check whether a
// number is positive or negative. Further, for positive numbers, check if the
// number is
// even or odd. Finally, compare the first and last elements of the array and
// display if they are equal, greater, or less
// Hint =>
// 1. Write a Method to check whether the number is positive or negative
// 2. Write a Method to check whether the number is even or odd
// 3. Write a Method to compare two numbers and return 1 if number1 > number2 or
// 0 if both are equal or -1 if number1 < number2
// 4. In the main program, Loop through the array using the length, call the
// method isPositive(), and if positive, callthe method isEven() and print
// accordingly
// 5. If the number is negative, print negative.
// 6. Finally, compare the first and last element of the array by calling the
// method compare() and display if they are equal, greater, or less
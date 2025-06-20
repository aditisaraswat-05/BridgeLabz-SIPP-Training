package Built_In_Functions;

import java.util.Scanner;

public class MaxOfThree {

    // Function to take integer input from the user
    public static int getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    // Function to find the maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take 3 integer inputs using getInput() method
        int num1 = getInput(scanner, "Enter the first number: ");
        int num2 = getInput(scanner, "Enter the second number: ");
        int num3 = getInput(scanner, "Enter the third number: ");

        // Find and display the maximum
        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + max);

        scanner.close();
    }
}

// Maximum of Three Numbers:
// ○ Write a program that takes three integer inputs from the user and finds the
// maximum of the three numbers.
// ○ Ensure your program follows best practices for organizing code into modular
// functions, such as separate functions for taking input and calculating the
// maximum value.
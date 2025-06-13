package Day2;

import java.util.Scanner;

public class q15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input
        System.out.print("Enter the first number (number1): ");
        int number1 = input.nextInt();

        System.out.print("Enter the second number (number2): ");
        int number2 = input.nextInt();

        // Swapping using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Output
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        input.close();
    }
}

// CP - Create a program to swap two numbers
// Hint =>
// 1. Create a variable number1 and take user input.
// 2. Create a variable number2 and take user input.
// 3. Swap number1 and number2 and print the swapped output
// I/P => number1, number2
// O/P => The swapped numbers are ___ and ___
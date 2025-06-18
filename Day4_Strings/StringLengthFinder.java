package Day4_Strings;

import java.util.Scanner;

public class StringLengthFinder {

    // Method to find string length using charAt() and exception handling
    public static int getStringLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Will throw exception when out of bounds
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input using next()
        System.out.print("Enter a string (no spaces): ");
        String input = scanner.next();

        // Call both methods
        int manualLength = getStringLength(input);
        int builtInLength = input.length();

        System.out.println("\nManual length (without using length()): " + manualLength);
        System.out.println("Built-in length (using length()): " + builtInLength);

        scanner.close();
    }
}

// CP - Write a program to find and return the length of a string without using
// the length() method
// Hint =>
// 1. Take user input using the Scanner next() method
// 2. Create a method to find and return a string's length without using the
// built-in length() method. The logic for this is to use the infinite loop to
// count each
// character till the charAt() method throws a runtime exception, handles the
// exception, and then return the count
// 3. The main function calls the user-defined method as well as the built-in
// length() method and displays the result

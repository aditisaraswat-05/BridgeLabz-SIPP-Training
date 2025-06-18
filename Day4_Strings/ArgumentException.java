package Day4_Strings;

import java.util.Scanner;

public class ArgumentException {
    // Method to generate the exception without handling it
    public static void generateException(String input) {
        System.out.println("Generating IllegalArgumentException...");
        // This will throw IllegalArgumentException if start > end
        String sub = input.substring(5, 2); // invalid range: start > end
        System.out.println("Substring: " + sub); // won't be reached if exception occurs
    }

    // Method to handle the exception using try-catch
    public static void handleException(String input) {
        System.out.println("Handling IllegalArgumentException...");
        try {
            String sub = input.substring(5, 2); // same invalid range
            System.out.println("Substring: " + sub);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e);
        } catch (RuntimeException e) {
            // catches any other unchecked exceptions
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // Call the method that generates the exception
        try {
            generateException(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println();

        // Call the method that handles the exception
        handleException(userInput);

        scanner.close();
    }
}

// CP - Write a program to demonstrate IllegalArgumentException
// Hint =>
// 1. Define a variable of type String and take user input to assign a value
// 2. Write a Method to generate the Exception. Here, use the subString() and
// set the start index to be greater than the end index. This will generate a
// runtime
// exception and abruptly stop the program.
// 3. Write the Method to demonstrate IllegalArgumentException. Here, use the
// subString() and set the start index to be greater than the end index. This
// will
// generate a runtime exception. Use the try-catch block to handle the
// IllegalArgumentException and the generic runtime exception
// 4. From the main Firstly call the method to generate the Exception then call
// the method to handle the RuntimeException

package Day4_Strings;

import java.util.Scanner;
import java.util.Scanner;

public class StringIndexOutOfBoundsException {
    // Method that generates the exception (no try-catch)
    public static void generateException(String input) {
        System.out.println("Generating exception...");
        // This will throw StringIndexOutOfBoundsException if input.length() <= 10
        char ch = input.charAt(10); // deliberately accessing out of bounds
        System.out.println("Character at index 10: " + ch); // Won't execute if exception occurs
    }

    // Method that handles the exception using try-catch
    public static void handleException(String input) {
        System.out.println("Handling exception...");
        try {
            char ch = input.charAt(10); // same out of bounds access
            System.out.println("Character at index 10: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e);
            System.out.println("String length is: " + input.length() + ". Index 10 is out of bounds.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input
        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        // 1. Call the method that generates the exception
        try {
            generateException(userInput);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println();

        // 2. Call the method that handles the exception
        handleException(userInput);

        scanner.close();
    }
}

// CP - Write a program to demonstrate StringIndexOutOfBoundsException
// Hint =>
// 1. Define a variable of type String and take user input to assign a value
// 2. Write a Method to generate the Exception. Access the index using charAt()
// beyond the length of the String. This will generate a runtime exception and
// abruptly stop the program.
// 3. Write the Method to demonstrate StringIndexOutOfBoundsException. Access
// the index using charAt() beyond the length of the String. Then, write try
// catch block for Exception while accessing the String method
// 4. From the main Firstly call the method to generate the Exception then call
// the method to handle the RuntimeException
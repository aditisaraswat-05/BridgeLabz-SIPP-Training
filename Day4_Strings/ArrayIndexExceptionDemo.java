package Day4_Strings;

import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    // Method that generates the exception without handling it
    public static void generateException(String[] names) {
        System.out.println("Generating ArrayIndexOutOfBoundsException...");
        // Intentionally accessing an invalid index (e.g., index 5 in a smaller array)
        System.out.println("Accessing index 5: " + names[5]); // May crash if names.length <= 5
    }

    // Method that handles the exception using try-catch
    public static void handleException(String[] names) {
        System.out.println("Handling ArrayIndexOutOfBoundsException...");
        try {
            System.out.println("Accessing index 5: " + names[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e);
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Define array of names and take input from user
        System.out.print("Enter the number of names: ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        // 2. Call the method to generate the exception
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught in main: " + e);
        }

        System.out.println();

        // 3. Call the method to handle the exception
        handleException(names);

        scanner.close();
    }
}

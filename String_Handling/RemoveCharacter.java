package String_Handling;

import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Input the character to remove
        System.out.print("Enter the character to remove: ");
        char toRemove = scanner.next().charAt(0);

        String result = "";

        // Build the result string without the specified character
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != toRemove) {
                result += input.charAt(i);
            }
        }

        System.out.println("Modified String: " + result);

        scanner.close();
    }
}

// Remove a Specific Character from a String
// Problem:
// Write a Java program to remove all occurrences of a specific character from a
// string.
// Example Input:
// String: "Hello World"
// Character to Remove: 'l'

// Expected Output:
// Modified String: "Heo Word"

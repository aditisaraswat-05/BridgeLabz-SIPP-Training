package String_Handling;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // To store characters-empty string
        String result = "";

        // Loop through the string
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            // Add character only if it's not already in result
            if (result.indexOf(current) == -1) {
                result += current;
            }
        }

        System.out.println("String after removing duplicates: " + result);

        scanner.close();
    }
}

// Problem:
// Write a Java program to remove all duplicate characters from a given string
// and return
// the modified string.

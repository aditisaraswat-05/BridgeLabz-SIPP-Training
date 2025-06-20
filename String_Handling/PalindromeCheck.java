package String_Handling;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert input to lowercase to make it case-insensitive
        input = input.toLowerCase();

        // Reverse the string manually
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        // Check if input and reversed are the same
        if (input.equals(reversed)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}

// Problem:
// Write a Java program to check if a given string is a palindrome (a string
// that reads the
// same forward and backward).
package Built_In_Functions;

import java.util.Scanner;

public class PalindromeChecker {

    // Function to get input from the user
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a word or phrase: ");
        return scanner.nextLine().replaceAll("\\s+", "").toLowerCase(); // Remove spaces and make lowercase
    }

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    // Function to display the result
    public static void displayResult(String original, boolean result) {
        if (result) {
            System.out.println("\"" + original + "\" is a palindrome.");
        } else {
            System.out.println("\"" + original + "\" is NOT a palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String originalInput = getInput(scanner); // cleaned input
        boolean result = isPalindrome(originalInput);
        displayResult(originalInput, result);

        scanner.close();
    }
}

// Palindrome Checker:
// ○ Write a program that checks if a given string is a palindrome (a word,
// phrase, or
// sequence that reads the same backward as forward).
// ○ Break the program into functions for input, checking the palindrome
// condition,
// and displaying the result.

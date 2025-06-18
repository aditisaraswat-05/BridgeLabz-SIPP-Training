package Day4_Strings;

import java.util.Scanner;

public class VowelConsonantCounter {

    // 1. Method to classify a character
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // 2. Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String input) {
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String type = checkCharType(ch);

            if (type.equals("Vowel")) {
                vowels++;
            } else if (type.equals("Consonant")) {
                consonants++;
            }
        }

        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call method to count
        int[] counts = countVowelsAndConsonants(input);

        // Display result
        System.out.println("\nTotal Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);

        scanner.close();
    }
}

// CP - Write a program to find vowels and consonants in a string and display
// the count of Vowels and Consonants in the string
// Hint =>
// 1. Create a method to check if the character is a vowel or consonant and
// return the result. The logic used here is as follows:
// a. Convert the character to lowercase if it is an uppercase letter using the
// ASCII values of the characters
// b. Check if the character is a vowel or consonant and return Vowel,
// Consonant, or Not a Letter
// 2. Create a method to find vowels and consonants in a string using the
// charAt() method and finally return the count of vowels and consonants in an
// array
// 3. Finally, the main function takes user inputs, calls the user-defined
// methods, and displays the result
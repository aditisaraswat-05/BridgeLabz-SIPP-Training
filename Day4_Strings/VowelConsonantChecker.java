package Day4_Strings;

import java.util.Scanner;

public class VowelConsonantChecker {

    // Method to check character type: Vowel, Consonant, or Not a Letter
    public static String checkCharType(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }

        // Check if it's a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check if vowel
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to find vowels and consonants in a string and return a 2D array [char,
    // type]
    public static String[][] findCharTypes(String input) {
        int length = input.length();
        String[][] result = new String[length][2];

        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharType(ch);
        }

        return result;
    }

    // Method to display 2D array in tabular format
    public static void displayCharTypes(String[][] data) {
        System.out.println("\nCharacter\tType");
        System.out.println("--------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call method to get character types
        String[][] charTypes = findCharTypes(input);

        // Display results
        displayCharTypes(charTypes);

        scanner.close();
    }
}

// CP - Write a program to find vowels and consonants in a string and display
// the character type - Vowel, Consonant, or Not a Letter
// Hint =>
// 1. Create a method to check if the character is a vowel or consonant and
// return the result. The logic used here is as follows:
// a. Convert the character to lowercase if it is an uppercase letter using the
// ASCII values of the characters
// b. Check if the character is a vowel or consonant and return Vowel,
// Consonant, or Not a Letter
// 2. Create a Method to find vowels and consonants in a string using the
// charAt() method and return the character and vowel or consonant in a 2D array
// 3. Create a Method to Display the 2D Array of Strings in a Tabular Format
// 4. Finally, the main function takes user inputs, calls the user-defined
// methods, and displays the result.

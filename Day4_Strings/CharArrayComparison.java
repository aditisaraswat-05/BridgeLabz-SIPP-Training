package Day4_Strings;

import java.util.Scanner;

public class CharArrayComparison {

    // Method to return characters without using toCharArray()
    public static char[] getCharactersManually(String input) {
        char[] chars = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            chars[i] = input.charAt(i);
        }
        return chars;
    }

    // Method to compare two char arrays
    public static boolean compareCharArrays(char[] array1, char[] array2) {
        if (array1.length != array2.length) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.next();

        // Call user-defined method
        char[] manualChars = getCharactersManually(userInput);

        // Use built-in toCharArray() method
        char[] builtInChars = userInput.toCharArray();

        // Compare the two arrays
        boolean areEqual = compareCharArrays(manualChars, builtInChars);

        System.out.println("\nCharacters from user-defined method:");
        for (char c : manualChars) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nCharacters from built-in toCharArray():");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nAre both character arrays equal? " + areEqual);

        scanner.close();
    }
}

// CP - Write a program to return all the characters in a string using the
// user-defined method, compare the result with the String built-in
// toCharArray() method,
// and display the result
// Hint =>
// 1. Take user input using the Scanner next() method to take the text into a
// String variable
// 2. Write a method to return the characters in a string without using the
// toCharArray()
// 3. Write a method to compare two string arrays and return a boolean result
// 4. In the main method, call the user-defined methods and the String builtin
// toCharArray() method, compare the 2 arrays, and finally display the result
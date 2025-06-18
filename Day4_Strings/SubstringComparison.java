package Day4_Strings;

import java.util.Scanner;

public class SubstringComparison {

    // Method to create a substring manually using charAt()
    public static String manualSubstring(String input, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < input.length(); i++) {
            result.append(input.charAt(i));
        }
        return result.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the string and indices
        System.out.print("Enter the original string: ");
        String input = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        // Create substring manually
        String manualSub = manualSubstring(input, start, end);

        // Create substring using built-in method
        String builtInSub = "";
        if (start >= 0 && end <= input.length() && start <= end) {
            builtInSub = input.substring(start, end);
        }

        // Compare both substrings
        boolean areEqual = compareStrings(manualSub, builtInSub);

        System.out.println("\nManual substring using charAt(): " + manualSub);
        System.out.println("Built-in substring(): " + builtInSub);
        System.out.println("Are both substrings equal? " + areEqual);

        scanner.close();
    }
}
// CP - Write a program to create a substring from a String using the charAt()
// method. Also, use the String built-in method substring() to find the
// substring of the
// text. Finally, compare the two strings and display the results
// Hint =>
// 1. Take user input using the Scanner next() method to take the String
// variable and also the start and the end index to get the substring from the
// given text
// 2. Write a method to create a substring from a string using the charAt()
// method with the string, start, and end index as the parameters
// 3. Write a method to compare two strings using the charAt() method and return
// a boolean result
// 4. Use the String built-in method substring() to get the substring and
// compare the two strings. Finally, display the result

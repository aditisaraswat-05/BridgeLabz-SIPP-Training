package Day4_Strings;

import java.util.Scanner;

public class ManualTrim {

    // 1. Method to find the start and end index (excluding leading and trailing
    // spaces)
    public static int[] getTrimIndices(String input) {
        int start = 0;
        int end = input.length() - 1;

        // Trim leading spaces
        while (start <= end && input.charAt(start) == ' ') {
            start++;
        }

        // Trim trailing spaces
        while (end >= start && input.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    // 2. Method to create a substring manually using charAt()
    public static String manualSubstring(String input, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i <= end; i++) {
            result.append(input.charAt(i));
        }
        return result.toString();
    }

    // 3. Method to compare two strings using charAt()
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

    // 4. Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take input
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = scanner.nextLine();

        // Get trimmed indices
        int[] indices = getTrimIndices(input);
        int start = indices[0];
        int end = indices[1];

        // Use custom method to trim string
        String manuallyTrimmed = manualSubstring(input, start, end);

        // Use built-in trim()
        String builtInTrimmed = input.trim();

        // Compare both trimmed versions
        boolean isEqual = compareStrings(manuallyTrimmed, builtInTrimmed);

        // Display results
        System.out.println("\nManual Trim Result: [" + manuallyTrimmed + "]");
        System.out.println("Built-in Trim Result: [" + builtInTrimmed + "]");
        System.out.println("Are both trimmed strings equal? " + isEqual);

        scanner.close();
    }
}

// CP - Write a program to trim the leading and trailing spaces from a string
// using the charAt() method
// Hint =>
// 1. Create a method to trim the leading and trailing spaces from a string
// using the charAt() method. Inside the method, run a couple of loops to trim
// leading
// and trailing spaces and determine the starting and ending points with no
// spaces. Return the start point and end point in an array
// 2. Write a method to create a substring from a string using the charAt()
// method with the string, start, and end index as the parameters
// 3. Write a method to compare two strings using the charAt() method and return
// a boolean result
// 4. The main function calls the user-defined trim and substring methods to get
// the text after trimming the leading and trailing spaces. Post that use the
// String
// built-in method trim() to trim spaces and compare the two strings. Finally
// display, the result
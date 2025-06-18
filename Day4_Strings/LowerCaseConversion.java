package Day4_Strings;

import java.util.Scanner;

public class LowerCaseConversion {

    // Method to convert uppercase characters to lowercase manually using charAt()
    public static String toLowerCaseManually(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            // If uppercase (ASCII 65 to 90), convert to lowercase by adding 32
            if (ch >= 'A' && ch <= 'Z') {
                result.append((char) (ch + 32));
            } else {
                result.append(ch); // Leave lowercase and other characters unchanged
            }
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

        // Take full-line input
        System.out.print("Enter a line of text: ");
        String inputText = scanner.nextLine();

        // Get lowercase using manual and built-in method
        String manualLower = toLowerCaseManually(inputText);
        String builtInLower = inputText.toLowerCase();

        // Compare both lowercase results
        boolean areEqual = compareStrings(manualLower, builtInLower);

        System.out.println("\nManual lowercase conversion: " + manualLower);
        System.out.println("Built-in toLowerCase() result: " + builtInLower);
        System.out.println("Are both results equal? " + areEqual);

        scanner.close();
    }
}

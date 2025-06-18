package Day4_Strings;

import java.util.Scanner;

public class StringComparison2 {

    // Method to compare two strings using charAt()
    public static boolean compareUsingCharAt(String str1, String str2) {
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

        // 1. Take user input for two strings
        System.out.print("Enter first string: ");
        String str1 = scanner.next();

        System.out.print("Enter second string: ");
        String str2 = scanner.next();

        // 2. Compare using charAt()
        boolean resultCharAt = compareUsingCharAt(str1, str2);

        // 3. Compare using built-in equals() method
        boolean resultEquals = str1.equals(str2);

        // 4. Display results
        System.out.println("\nResult using charAt(): " + resultCharAt);
        System.out.println("Result using equals(): " + resultEquals);

        // 5. Check if both results are the same
        if (resultCharAt == resultEquals) {
            System.out.println("Both comparison methods give the same result.");
        } else {
            System.out.println("Mismatch between charAt() and equals() method results.");
        }

        scanner.close();
    }
}

// CP - Write a program to compare two strings using the charAt() method and
// check the result with the built-in String equals() method
// Hint =>
// 1. Take user input using the Scanner next() method for 2 String variables
// 2. Write a method to compare two strings using the charAt() method and return
// a boolean result
// 3. Use the String Built-In method to check if the results are the same and
// display the result
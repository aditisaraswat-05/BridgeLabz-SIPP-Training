package String_Handling;

import java.util.Scanner;

public class LexicographicalCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        int i = 0;
        int minLength = Math.min(str1.length(), str2.length());
        boolean areEqual = true;

        // Compare character by character
        while (i < minLength) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 != ch2) {
                areEqual = false;
                if (ch1 < ch2) {
                    System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
                } else {
                    System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
                }
                break;
            }
            i++;
        }

        // If all characters are same in prefix, compare length
        if (areEqual) {
            if (str1.length() == str2.length()) {
                System.out.println("Both strings are equal.");
            } else if (str1.length() < str2.length()) {
                System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
            } else {
                System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
            }
        }

        scanner.close();
    }
}

// Problem:
// Write a Java program to compare two strings lexicographically (dictionary
// order) without
// using built-in compare methods.
// Example Input:

// String 1: "apple"
// String 2: "banana"

// Expected Output:
// "apple" comes before "banana" in lexicographical order
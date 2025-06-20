package String_Handling;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine().toLowerCase().replaceAll("\\s", "");

        // Convert to char arrays
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        // Sort the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare the sorted arrays
        if (Arrays.equals(arr1, arr2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are NOT anagrams.");
        }

        scanner.close();
    }
}

// Write a Java program that accepts two strings from the user and checks if the
// two
// strings are anagrams of each other (i.e., whether they contain the same
// characters in any
// order).
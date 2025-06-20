package String_Handling;

import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        int[] freq = new int[256]; // ASCII characters range

        // Count frequency of each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            freq[ch]++;
        }

        // Find the character with the highest frequency
        int max = 0;
        char mostFrequent = ' ';

        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                mostFrequent = (char) i;
            }
        }

        System.out.println("Most Frequent Character: '" + mostFrequent + "'");

        scanner.close();
    }
}

// Problem:
// Write a Java program to find the most frequent character in a string.
// Example Input:
// String: "success"

// Expected Output:
// Most Frequent Character: 's'
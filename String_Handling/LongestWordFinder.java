package String_Handling;

import java.util.Scanner;

public class LongestWordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Split sentence into words using space
        String[] words = sentence.split(" ");

        String longestWord = "";
        int maxLength = 0;

        // Loop through all words
        for (String word : words) {
            // Check if current word is longer
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWord = word;
            }
        }

        System.out.println("The longest word is: " + longestWord);

        scanner.close();
    }
}

// Write a Java program that takes a sentence as input and returns the longest
// word in the
// sentence.
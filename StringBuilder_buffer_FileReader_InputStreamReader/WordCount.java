package StringBuilder_buffer_FileReader_InputStreamReader;

import java.io.*;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        System.out.print("Enter word to count: ");
        String wordToFind = sc.nextLine();

        int count = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equalsIgnoreCase(wordToFind)) {
                        count++;
                    }
                }
            }

            br.close();
            System.out.println("The word \"" + wordToFind + "\" appears " + count + " times.");

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        sc.close();
    }
}

// FileReader Problem 2: Count the Occurrence of a Word in a File Using
// FileReader
// Problem:
// Write a program that uses FileReader and BufferedReader to read a file and
// count how many times a specific word appears in the file.
// Approach:
// Create a FileReader to read from the file and wrap it in a BufferedReader.
// Initialize a counter variable to keep track of word occurrences.
// For each line in the file, split it into words and check if the target word
// exists.
// Increment the counter each time the word is found.
// Print the final count.

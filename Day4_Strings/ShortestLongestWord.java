package Day4_Strings;

import java.util.Scanner;

public class ShortestLongestWord {

    // 2. Method to split text into words using charAt()
    public static String[] splitWords(String input) {
        String[] words = new String[100]; // Assume max 100 words
        int wordCount = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < getLength(input); i++) {
            char ch = input.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else {
                if (word.length() > 0) {
                    words[wordCount++] = word.toString();
                    word = new StringBuilder();
                }
            }
        }

        // Add the last word if any
        if (word.length() > 0) {
            words[wordCount++] = word.toString();
        }

        // Copy to exact-sized array
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }
        return result;
    }

    // 3. Method to find string length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    // 4. Method to return a 2D array of [word, length]
    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    // 5. Method to find shortest and longest words
    public static int[] findShortestAndLongest(String[][] wordData) {
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < wordData.length; i++) {
            int len = Integer.parseInt(wordData[i][1]);
            int minLen = Integer.parseInt(wordData[minIndex][1]);
            int maxLen = Integer.parseInt(wordData[maxIndex][1]);

            if (len < minLen)
                minIndex = i;
            if (len > maxLen)
                maxIndex = i;
        }

        return new int[] { minIndex, maxIndex };
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Take input
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        // Process
        String[] words = splitWords(input);
        String[][] wordLengths = getWordLengthArray(words);
        int[] result = findShortestAndLongest(wordLengths);

        // Output
        System.out.println("\nWords and their lengths:");
        for (int i = 0; i < wordLengths.length; i++) {
            System.out.println(wordLengths[i][0] + " -> " + wordLengths[i][1]);
        }

        System.out.println("\nShortest word: " + wordLengths[result[0]][0]);
        System.out.println("Longest word: " + wordLengths[result[1]][0]);

        scanner.close();
    }
}
// CP - Write a program to split the text into words and find the shortest and
// longest strings in a given text
// Hint =>
// 1. Take user input using the Scanner nextLine() method
// 2. Create a Method to split the text into words using the charAt() method
// without using the String built-in split() method and return the words.
// 3. Create a method to find and return a string's length without using the
// length() method.
// 4. Create a method to take the word array and return a 2D String array of the
// word and its corresponding length. Use the String built-in function
// String.valueOf() to generate the String value for the number
// 5. Create a Method that takes the 2D array of words and the corresponding
// length as parameters, find the shortest and longest string, and return them
// in a
// 1D int array.
// 6. The main function calls the user-defined methods and displays the
// result..............java code
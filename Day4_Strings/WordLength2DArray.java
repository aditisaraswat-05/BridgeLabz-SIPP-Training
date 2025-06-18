package Day4_Strings;

import java.util.Scanner;

public class WordLength2DArray {

    // Method to split string into words using charAt()
    public static String[] splitTextToWords(String input) {
        String[] words = new String[100]; // assuming max 100 words
        int wordCount = 0;
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < getLength(input); i++) {
            char ch = input.charAt(i);
            if (ch != ' ') {
                currentWord.append(ch);
            } else if (currentWord.length() > 0) {
                words[wordCount++] = currentWord.toString();
                currentWord.setLength(0); // reset builder
            }
        }

        // Add the last word if there is one
        if (currentWord.length() > 0) {
            words[wordCount++] = currentWord.toString();
        }

        // Trim array to actual size
        String[] result = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            result[i] = words[i];
        }

        return result;
    }

    // Method to get string length without using length()
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // will throw exception when out of bounds
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // end of string
        }
        return count;
    }

    // Method to create 2D array of word and its length as String
    public static String[][] generateWordLengthArray(String[] words) {
        String[][] wordInfo = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            wordInfo[i][0] = words[i];
            wordInfo[i][1] = String.valueOf(getLength(words[i]));
        }

        return wordInfo;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take full line input
        System.out.print("Enter a line of text: ");
        String input = scanner.nextLine();

        // Get words
        String[] words = splitTextToWords(input);

        // Get 2D array of word and its length
        String[][] wordLengthData = generateWordLengthArray(words);

        // Display in tabular format
        System.out.println("\nWord\tLength");
        System.out.println("--------------");
        for (int i = 0; i < wordLengthData.length; i++) {
            String word = wordLengthData[i][0];
            int length = Integer.parseInt(wordLengthData[i][1]); // Convert to integer
            System.out.println(word + "\t" + length);
        }

        scanner.close();
    }
}

// CP - Write a program to split the text into words and return the words along
// with their lengths in a 2D array
// Hint =>
// 1. Take user input using the Scanner nextLine() method
// 2. Create a Method to split the text into words using the charAt() method
// without using the String built-in split() method and return the words.
// 3. Create a method to find and return a string's length without using the
// length() method.
// 4. Create a method to take the word array and return a 2D String array of the
// word and its corresponding length. Use the String built-in function
// String.valueOf() to generate the String value for the number
// 5. The main function calls the user-defined method and displays the result in
// a tabular format. During the display, make sure to convert the length value
// from
// String to Integer and then display
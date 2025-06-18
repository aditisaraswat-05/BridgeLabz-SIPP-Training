package Day4_Strings;

import java.util.Scanner;

public class ManualSplitCompare {

    // 2. Method to get string length without using length()
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

    // 3. Method to split text manually using charAt()
    public static String[] customSplit(String text) {
        int len = getLength(text);
        int spaceCount = 0;

        // Count words (spaces + 1)
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaceIndexes = new int[spaceCount + 2]; // +2 for start and end
        spaceIndexes[0] = -1; // Start before first character
        int index = 1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        spaceIndexes[index] = len; // End of string

        // Extract words
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            StringBuilder word = new StringBuilder();
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word.append(text.charAt(j));
            }
            words[i] = word.toString();
        }

        return words;
    }

    // 4. Method to compare two string arrays
    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }

    // 5. Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String[] manualSplit = customSplit(input);
        String[] builtInSplit = input.split(" ");

        // Compare results
        boolean areEqual = compareArrays(manualSplit, builtInSplit);

        // Output
        System.out.println("\nManual Split:");
        for (String word : manualSplit) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split:");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both splits equal? " + (areEqual ? "Yes ✅" : "No ❌"));

        scanner.close();
    }
}

// CP - Write a program to split the text into words, compare the result with
// the split() method, and display the result
// Hint =>
// 1. Take user input using the Scanner nextLine() method
// 2. Create a Method to find the length of the String without using the
// built-in length() method.
// 3. Create a Method to split the text into words using the charAt() method
// without using the String built-in split() method and return the words. Use
// the
// following logic
// a. Firstly, count the number of words in the text and create an array to
// store the indexes of the spaces for each word in a 1D array
// b. Then, create an array to store the words and use the indexes to extract
// the words
// 4. Create a method to compare the two String arrays and return a boolean
// 5. The main function calls the user-defined method and the built-in split()
// method. Call the user-defined method to compare the two string arrays and
// display
// the result
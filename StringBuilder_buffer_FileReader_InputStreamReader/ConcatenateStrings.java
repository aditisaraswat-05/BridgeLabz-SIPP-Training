package StringBuilder_buffer_FileReader_InputStreamReader;

public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] words = { "Hello", " ", "this", " ", "is", " ", "Java." };

        // StringBuffer for holding result
        StringBuffer result = new StringBuffer();

        // Append each word to the buffer
        for (String word : words) {
            result.append(word);
        }

        System.out.println("Final String: " + result.toString());
    }
}

// StringBuffer Problem 1: Concatenate Strings Efficiently Using StringBuffer
// Problem:
// You are given an array of strings. Write a program that uses StringBuffer to
// concatenate all the strings in the array efficiently.
// Approach:
// Create a new StringBuffer object.
// Iterate through each string in the array and append it to the StringBuffer.
// Return the concatenated string after the loop finishes.
// Using StringBuffer ensures efficient string concatenation due to its mutable
// nature.

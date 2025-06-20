package String_Handling;

import java.util.Scanner;

public class WordReplacer {

    // Method to replace all occurrences of a word in a sentence
    public static String replaceWord(String sentence, String oldWord, String newWord) {
        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(oldWord)) {
                result += newWord;
            } else {
                result += words[i];
            }

            if (i != words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input sentence and words
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        System.out.print("Enter the word to replace: ");
        String oldWord = scanner.nextLine();

        System.out.print("Enter the new word: ");
        String newWord = scanner.nextLine();

        // Call the method
        String modifiedSentence = replaceWord(sentence, oldWord, newWord);

        System.out.println("Modified Sentence: " + modifiedSentence);

        scanner.close();
    }
}

// Write a replace method in Java that replaces a given word with another word
// in a
// sentence:
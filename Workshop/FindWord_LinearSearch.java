package Workshop;

import java.util.Scanner;

public class FindWord_LinearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the paragraph:");
        String text = input.nextLine();

        System.out.print("Enter the word which you want to find: ");
        String wordToFind = input.next();

        String[] allWords = text.split(" ");

        boolean isFound = false;

        for (int i = 0; i < allWords.length; i++) {
            String currentWord = allWords[i].replaceAll("[^a-zA-Z]", "");

            if (currentWord.equalsIgnoreCase(wordToFind)) {
                System.out.println("Found at word position: " + (i + 1));
                isFound = true;
                break;
            }
        }

        if (!isFound) {
            System.out.println("Word not found.");
        }

        input.close();
    }
}

// Take a paragraph from user and find the word in it using linear search
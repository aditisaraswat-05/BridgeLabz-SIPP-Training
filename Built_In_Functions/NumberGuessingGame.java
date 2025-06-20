package Built_In_Functions;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    // Function to generate random guess between min and max
    public static int generateGuess(int min, int max) {
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    // Function to get user feedback: high, low, or correct
    public static String getFeedback(Scanner scanner, int guess) {
        System.out.print("Is your number " + guess + "? (Enter: high / low / correct): ");
        return scanner.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I (the computer) will try to guess it!");

        int min = 1;
        int max = 100;
        int attempts = 0;
        boolean found = false;

        while (!found && min <= max) {
            int guess = generateGuess(min, max);
            attempts++;

            String feedback = getFeedback(scanner, guess);

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number in " + attempts + " attempts!");
                found = true;
            } else if (feedback.equals("high")) {
                max = guess - 1; // guess was too high
            } else if (feedback.equals("low")) {
                min = guess + 1; // guess was too low
            } else {
                System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
                attempts--; // don't count invalid input
            }
        }

        if (!found) {
            System.out.println("Hmm, something went wrong! Are you sure you gave correct feedback?");
        }

        scanner.close();
    }
}

// 1. Number Guessing Game:
// ○ Write a Java program where the user thinks of a number between 1 and 100,
// and
// the computer tries to guess the number by generating random guesses.
// ○ The user provides feedback by indicating whether the guess is high, low, or
// correct. The program should be modular, with different functions for
// generating
// guesses, receiving user feedback, and determining the next guess.
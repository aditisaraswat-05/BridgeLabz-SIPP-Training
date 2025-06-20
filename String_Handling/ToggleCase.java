package String_Handling;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String toggled = "";

        // Loop through each character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Check if uppercase
            if (Character.isUpperCase(ch)) {
                toggled += Character.toLowerCase(ch);
            }
            // Check if lowercase
            else if (Character.isLowerCase(ch)) {
                toggled += Character.toUpperCase(ch);
            }
            // If not a letter, keep as it is
            else {
                toggled += ch;
            }
        }

        System.out.println("Toggled string: " + toggled);

        scanner.close();
    }
}
// Write a Java program to toggle the case of each character in a given string.
// Convert
// uppercase letters to lowercase and vice versa.
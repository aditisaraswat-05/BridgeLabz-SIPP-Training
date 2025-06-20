package String_Handling;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Initialize an empty string for reversed result
        String reversed = "";

        // Loop through the string from end to start
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }
        System.out.println("Reversed string: " + reversed);

        sc.close();
    }
}

// Write a Java program to reverse a given string without using any built-in
// reverse Functions.

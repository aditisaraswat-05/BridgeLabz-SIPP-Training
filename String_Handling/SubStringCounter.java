package String_Handling;

import java.util.Scanner;

public class SubStringCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the main string: ");
        String mainString = sc.nextLine();

        // Input the substring to search
        System.out.print("Enter the substring to count: ");
        String subString = sc.nextLine();

        int count = 0;
        int index = 0;

        // Loop to find all occurrences
        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length(); // move index forward
        }

        System.out.println("The substring \"" + subString + "\" occurs " + count + " time(s).");

        sc.close();
    }
}

// Problem:
// Write a Java program to count how many times a given substring occurs in a
// string.
package Day4_Methods;

import java.util.Scanner;

public class FriendsAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] friends = { "Amar", "Akbar", "Anthony" };
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Take input for ages and heights
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();

            System.out.print("Enter height of " + friends[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        // Find youngest friend
        int youngestIndex = findYoungest(ages);

        // Find tallest friend
        int tallestIndex = findTallest(heights);

        System.out.println("\nYoungest friend: " + friends[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + friends[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");

        scanner.close();
    }

    // Method to find the index of youngest friend based on age array
    public static int findYoungest(int[] ages) {
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }

    // Method to find the index of tallest friend based on heights array
    public static int findTallest(double[] heights) {
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
}

// CP - Create a program to find the youngest friends among 3 Amar, Akbar and
// Anthony based on their ages and tallest among the friends based on their
// heights
// and display it
// Hint =>
// 1. Take user input for the age and height of the 3 friends and store it in
// two arrays each to store the values for the age and height of the 3 friends
// 2. Write a Method to find the youngest of the 3 friends
// 3. Write a Method to find the tallest of the 3 friends

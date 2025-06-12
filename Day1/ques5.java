package Day1;

import java.util.Scanner;

public class ques5 {
    public static void main(String[] args) {
        double heightCm, totalInches, feet, inches;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your height in centimeters: ");
        heightCm = input.nextDouble();

        // Convert cm to total inches
        totalInches = heightCm / 2.54;

        // Convert inches to feet and remaining inches
        feet = Math.floor(totalInches / 12); // only whole feet
        inches = totalInches % 12; // remainder in inches

        System.out.printf("Your Height in cm is %.2f while in feet is %.0f and inches is %.2f\n",
                heightCm, feet, inches);

        input.close();
    }
}

// CP - Write a program that takes your height in centimeters and converts it
// into feet and inches
// Hint => 1 foot = 12 inches and 1 inch = 2.54 cm
// I/P => height
// O/P => Your Height in cm is ___ while in feet is ___ and inches is ___
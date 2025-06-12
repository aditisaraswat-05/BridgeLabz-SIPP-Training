package Day1;

import java.util.Scanner;

public class ques3 {
    public static void main(String[] args) {
        double km;
        double miles;
        // user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        km = input.nextInt();

        // Convert km to miles (1 mile = 1.6 km => miles = km / 1.6)
        miles = km / 1.6;

        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");

        input.close();
    }
}

// CP - Create a program to convert distance in kilometers to miles.
// Hint =>
// Create a variable km and assign type as double as in double km;
// Create Scanner Object to take user input from Standard Input that is the
// Keyboard as in Scanner
// input = new Scanner(System.in);
// Use Scanner Object to take user input for km as in km = input.nextInt();
// Use 1 mile = 1.6 km formulae to calculate miles and show the output
// I/P => km
// O/P => The total miles is ___ mile for the given ___ km
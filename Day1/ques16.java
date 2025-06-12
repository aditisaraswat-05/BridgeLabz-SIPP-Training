package Day1;

import java.util.Scanner;

public class ques16 {

    public static void main(String[] args) {

        double pounds, kilograms;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        pounds = sc.nextDouble();

        // Convert pounds to kilograms
        kilograms = pounds * 0.4536;
        System.out.println("The weight of the person in pounds is " + pounds +
                " and in kilograms is " + kilograms);

        sc.close();
    }
}

// CP - Create a program to convert weight from pounds to kilograms.
// Hint => 1 pound = 2.2 kg
// I/P => weight
// O/P => The weight of the person in pounds is ___ and in kg is ___

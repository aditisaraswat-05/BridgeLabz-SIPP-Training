package Day4_Methods;

import java.util.Scanner;

public class SimpleInterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time in years: ");
        double time = scanner.nextDouble();

        // Calculate simple interest
        double interest = calculateSimpleInterest(principal, rate, time);

        System.out.println("The Simple Interest is " + interest +
                " for Principal " + principal +
                ", Rate of Interest " + rate +
                " and Time " + time);

        scanner.close();
    }

    // Method to calculate Simple Interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}

// CP - Write a program to input the Principal, Rate, and Time values and
// calculate Simple Interest.
// Hint =>
// 1. Simple Interest = Principal * Rate * Time / 100
// 2. Take user input for principal, rate, time
// 3. Write a method to calculate the simple interest, given principle, rate,
// and time as parameters
// 4. Output “The Simple Interest is ___ for Principal ___, Rate of Interest ___
// and Time ___”
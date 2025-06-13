package Day2;

import java.util.Scanner;

public class q18 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input principal, rate, and time
        System.out.print("Enter the Principal amount: ");
        double principal = input.nextDouble();

        System.out.print("Enter the Rate of Interest: ");
        double rate = input.nextDouble();

        System.out.print("Enter the Time (in years): ");
        double time = input.nextDouble();

        // Calculate simple interest
        double simpleInterest = (principal * rate * time) / 100;

        // Output the result
        System.out.println("The Simple Interest is INR " + simpleInterest +
                " for Principal INR " + principal + ", Rate of Interest " +
                rate + "% and Time " + time + " years.");

        input.close();
    }
}

// CP - Write a program to input the Principal, Rate, and Time values and
// calculate Simple Interest.
// Hint => Simple Interest = Principal * Rate * Time / 100
// I/P => principal, rate, time
// O/P => The Simple Interest is ___ for Principal ___, Rate of Interest ___ and
// Time ___
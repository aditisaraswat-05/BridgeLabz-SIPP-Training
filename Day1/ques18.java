package Day1;

import java.util.Scanner;

public class ques18 {

    public static void main(String[] args) {

        double principal, rate, time, simpleInterest;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Principal amount (INR): ");
        principal = input.nextDouble();

        System.out.print("Enter Rate of Interest (%): ");
        rate = input.nextDouble();

        System.out.print("Enter Time (in years): ");
        time = input.nextDouble();

        // Calculate Simple Interest
        simpleInterest = (principal * rate * time) / 100;

        System.out.println("The Simple Interest is INR " + simpleInterest +
                " for Principal INR " + principal +
                ", Rate of Interest " + rate + "% and Time " + time + " years.");

        input.close();
    }
}

// CP - Write a program to input the Principal, Rate, and Time values and
// calculate Simple Interest.
// Hint => Simple Interest = Principal * Rate * Time / 100
// I/P => principal, rate, time
// O/P => The Simple Interest is ___ for Principal ___, Rate of Interest ___ and
// Time ___
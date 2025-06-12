package Day1;

import java.util.Scanner;

public class ques10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int a = sc.nextInt();
        System.out.println("Enter the second number");
        int b = sc.nextInt();
        int quotient, remainder;

        quotient = a / b;
        remainder = a % b;

        System.out.println("The Quotient is " + quotient +
                " and Remainder is " + remainder +
                " of two numbers " + a + " and " + b);

        sc.close();
    }

}

// CP - Write a program to take two numbers and print their quotient and
// reminder
// Hint => Use division operator (/) for quotient and moduli operator (%) for
// reminder
// I/P => number1, number2
// O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___
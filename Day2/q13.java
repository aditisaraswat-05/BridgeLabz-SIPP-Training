package Day2;

import java.util.Scanner;

public class q13 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number (dividend): ");
        int number1 = input.nextInt();

        System.out.print("Enter second number (divisor): ");
        int number2 = input.nextInt();

        // Check for divide by zero
        if (number2 == 0) {
            System.out.println("Division by zero is not allowed.");
        } else {
            // Calculate quotient and remainder
            int quotient = number1 / number2;
            int remainder = number1 % number2;

            System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder +
                    " of two numbers " + number1 + " and " + number2);
        }

        input.close();
    }
}

// CP - Write a program to take two numbers and print their quotient and
// reminder
// Hint => Use division operator (/) for quotient and moduli operator (%) for
// reminder
// I/P => number1, number2
// O/P => The Quotient is ___ and Reminder is ___ of two number ___ and ___

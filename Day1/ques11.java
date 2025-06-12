package Day1;

import java.util.Scanner;

public class ques11 {

    public static void main(String[] args) {

        double number1, number2;
        double sum, difference, product, quotient;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        number2 = input.nextDouble();

        // Perform operations
        sum = number1 + number2;
        difference = number1 - number2;
        product = number1 * number2;
        quotient = number1 / number2;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers "
                + number1 + " and " + number2 + " is:");
        System.out.println("Addition: " + sum);
        System.out.println("Subtraction: " + difference);
        System.out.println("Multiplication: " + product);
        System.out.println("Division: " + quotient);

        input.close();
    }
}

// CP - Write a program to create a basic calculator for addition, subtraction,
// multiplication, and division.
// The program should ask for two numbers (floating point) and perform all the
// operations
// Hint =>
// Create a variable number1 and number 2 and take user inputs.
// Perform Arithmetic Operations of addition, subtraction, multiplication and
// division and assign the
// result to a variable and finally print the result
// I/P => number1, number2
// O/P => The addition, subtraction, multiplication, and division value of 2
// numbers ___ and ___ is ___,
// ____, ____, and ___
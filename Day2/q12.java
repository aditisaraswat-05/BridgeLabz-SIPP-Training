package Day2;

import java.util.Scanner;

public class q12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = input.nextDouble();

        // Perform operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number2 != 0 ? number1 / number2 : Double.NaN; // Handle divide by zero

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers "
                + number1 + " and " + number2 + " is:");
        System.out.println("Addition: " + addition);
        System.out.println("Subtraction: " + subtraction);
        System.out.println("Multiplication: " + multiplication);
        System.out.println("Division: " + (number2 != 0 ? division : "Undefined (division by zero)"));

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

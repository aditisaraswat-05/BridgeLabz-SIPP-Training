package Day2;

import java.util.Scanner;

public class q20 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Input temperature in Fahrenheit
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        // Step 2: Convert to Celsius using formula
        double celsius = (fahrenheit - 32) * 5 / 9;

        // Step 3: Print the result
        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsius + " Celsius.");

        input.close();
    }
}

// CP - Write a TemperaturConversion program, given the temperature in
// Fahrenheit as input outputs the
// temperature in Celsius
// Hint =>
// 1. Create a fahrenheit variable and take the user's input
// 2. User the formulae to convert Fahrenheit to Celsius: (°F - 32) x 5/9 = °C
// and assign the result to
// celsiusResult and print the result
// I/P => fahrenheit
// O/P => The ____ fahrenheit is _____ celsius
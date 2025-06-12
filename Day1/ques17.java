package Day1;

import java.util.Scanner;

public class ques17 {

    public static void main(String[] args) {

        double fahrenheit, celsiusResult;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit: ");
        fahrenheit = input.nextDouble();

        // Convert to Celsius
        celsiusResult = (fahrenheit - 32) * 5 / 9;

        System.out.println("The " + fahrenheit + " Fahrenheit is " + celsiusResult + " Celsius");

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

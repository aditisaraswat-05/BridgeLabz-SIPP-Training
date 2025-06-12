package Day1;

import java.util.Scanner;

public class ques14 {

    public static void main(String[] args) {

        double celsius, fahrenheitResult;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        celsius = input.nextDouble();

        // Convert to Fahrenheit
        fahrenheitResult = (celsius * 9 / 5) + 32;

        System.out.println("The " + celsius + " Celsius is " + fahrenheitResult + " Fahrenheit");

        input.close();
    }
}

// CP - Write a TemperaturConversion program, given the temperature in Celsius
// as input outputs the
// temperature in Fahrenheit
// Hint =>
// 1. Create a Celsius variable and take the temperature as user input
// 2. Use the Formulae Celsius to Fahrenheit: (°C × 9/5) + 32 = °F and assign to
// farenheitResult and
// print the result
// I/P => celsius
// O/P => The ____ celsius is _____ fahrenheit

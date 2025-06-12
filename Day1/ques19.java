package Day1;

import java.util.Scanner;

public class ques19 {

    public static void main(String[] args) {

        int number1, number2, temp;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number1: ");
        number1 = input.nextInt();

        System.out.print("Enter number2: ");
        number2 = input.nextInt();

        // Swap the numbers using a temporary variable
        temp = number1;
        number1 = number2;
        number2 = temp;
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        input.close();
    }
}

// CP - Create a program to swap two numbers
// Hint =>
// 1. Create a variable number1 and take user input.
// 2. Create a variable number2 and take user input.
// 3. Swap number1 and number2 and print the swapped output
// I/P => number1, number2
// O/P => The swapped numbers are ___ and ___
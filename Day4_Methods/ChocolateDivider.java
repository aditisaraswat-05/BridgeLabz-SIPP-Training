package Day4_Methods;

import java.util.Scanner;

public class ChocolateDivider {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = scanner.nextInt();

        // Input validation
        if (numberOfChildren == 0) {
            System.out.println("Cannot divide by zero children.");
        } else {
            // Call the method
            int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

            System.out.println("Each child will get " + result[1] + " chocolates.");
            System.out.println("Remaining chocolates: " + result[0]);
        }

        scanner.close();
    }

    // Method to return remainder and quotient as an array
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int remainder = number % divisor;
        int quotient = number / divisor;
        return new int[] { remainder, quotient };
    }
}

// CP - Create a program to divide N number of chocolates among M children.
// Print the number of chocolates each child will get and also the remaining
// chocolates
// Hint =>
// 1. Get an integer value from the user for the numberOfchocolates and
// numberOfChildren.
// 2. Write the method to find the number of chocolates each child gets and the
// number of remaining chocolates
// public static int[] findRemainderAndQuotient(int number, int divisor)

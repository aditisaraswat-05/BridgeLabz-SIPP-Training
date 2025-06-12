package Day1;

import java.util.Scanner;

public class ques8 {
    public static void main(String[] args) {

        double a, b, c;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for a: ");
        a = input.nextDouble();

        System.out.print("Enter value for b: ");
        b = input.nextDouble();

        System.out.print("Enter value for c: ");
        c = input.nextDouble();

        double result1 = a + b * c;
        double result2 = a * b + c;
        double result3 = c + a / b;
        double result4 = a % b + c;

        System.out.println("\nThe results of Double Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        input.close();
    }
}

// CP - Write a DoubleOperation program by taking a, b, and c as input values
// and print the results of the
// following operations a + b *c, a * b + c, c + a / b, and a % b + c. Please
// also understand the Operator
// Precedence.
// Hint =>
// 1. Create variables a, b, and c of double data type.
// 2. Take user input for a, b, and c.
// 3. Compute 3 double operations and assign the result to a variable
// 4. Finally, print the result and try to understand operator precedence.
// I/P => fee, discountPrecent
// O/P => The results of Double Operations are ___, ___, and ___
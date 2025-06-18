package Day4_Methods;

import java.util.Scanner;

public class FactorAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input a number
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a number greater than 0.");
            return;
        }

        // Step 2: Find factors
        int[] factors = findFactors(number);

        // Step 3: Display factors
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }

        // Step 4: Calculate and display sum, product, and sum of squares
        int sum = sumOfFactors(factors);
        long product = productOfFactors(factors);
        int sumOfSquares = sumOfSquaresOfFactors(factors);

        System.out.println("\nSum of factors: " + sum);
        System.out.println("Product of factors: " + product);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        scanner.close();
    }

    // Method to find factors of a number and return as array
    public static int[] findFactors(int number) {
        // First loop to count factors
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }

        // Initialize array with count
        int[] factors = new int[count];

        // Second loop to store factors
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Method to calculate sum of factors
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate product of factors
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate sum of squares of factors
    public static int sumOfSquaresOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += (int) Math.pow(factor, 2);
        }
        return sum;
    }
}

// CP - Create a program to find the factors of a number taken as user input,
// store the factors in an array, and display the factors. Also, find the sum,
// sum of square
// of factors and product of the factors and display the results
// Hint =>
// 1. Take the input for a number
// 2. Write a static method to find the factors of the number and save them in
// an array and return the array.
// 3. To find factors and save to array will have two loops. The first loop is
// to find the count and initialize the array with the count. The second loop
// saves the
// factors into the array
// 4. Write a method to find the sum of the factors using factors array
// 5. Write a method to find the product of the factors using factors array
// 6. Write a method to find the sum of squares of the factors using Math.pow()
// method
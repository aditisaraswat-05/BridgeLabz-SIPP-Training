package Day4_Methods;

import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int n = sc.nextInt();

        // Input validation
        if (n <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
        } else {
            // Call method to find sum
            int sum = findSumOfNaturalNumbers(n);

            System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        }

        sc.close();
    }

    // Method to find sum of n natural numbers using a loop
    public static int findSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i; // Add i to sum in each iteration
        }
        return sum;

    }
}

// CP - Write a program to find the sum of n natural numbers using a loop
// Hint =>
// 1. Get integer input from the user.
// 2. Write a Method to find the sum of n natural numbers using a loop

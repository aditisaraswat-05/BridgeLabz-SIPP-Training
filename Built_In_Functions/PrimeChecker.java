package Built_In_Functions;

import java.util.Scanner;

public class PrimeChecker {

    // Function to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false; // 0 and 1 are not prime
        }

        // Check for factors from 2 to sqrt(number)
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // number is divisible → not prime
            }
        }

        return true; // number is prime
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it's prime: ");
        int num = scanner.nextInt();

        // Check using isPrime() function
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is NOT a prime number.");
        }

        scanner.close();
    }
}

// Prime Number Checker:
// ○ Create a program that checks whether a given number is a prime number. ○
// The program should use a separate function to perform the prime check and
// return the result.
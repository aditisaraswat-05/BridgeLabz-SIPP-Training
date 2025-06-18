package Day4_Methods;

public class NumberChecker {

    public static void main(String[] args) {
        int[] testNumbers = { 6, 12, 15, 145, 28, 18 };

        for (int num : testNumbers) {
            System.out.println("Number: " + num);
            System.out.println("Is Perfect? " + isPerfect(num));
            System.out.println("Is Abundant? " + isAbundant(num));
            System.out.println("Is Deficient? " + isDeficient(num));
            System.out.println("Is Strong? " + isStrong(num));
            System.out.println("-----------------------------");
        }
    }

    // Method to calculate sum of proper divisors
    private static int sumOfProperDivisors(int number) {
        int sum = 1; // 1 is always a proper divisor except for 1 itself (handled below)
        if (number == 1)
            return 0; // 1 has no proper divisors other than itself, excluded
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    // 1. Check if number is perfect
    public static boolean isPerfect(int number) {
        if (number <= 1)
            return false;
        return sumOfProperDivisors(number) == number;
    }

    // 2. Check if number is abundant
    public static boolean isAbundant(int number) {
        if (number <= 1)
            return false;
        return sumOfProperDivisors(number) > number;
    }

    // 3. Check if number is deficient
    public static boolean isDeficient(int number) {
        if (number <= 1)
            return true; // 1 and below considered deficient
        return sumOfProperDivisors(number) < number;
    }

    // Helper method: factorial of digit
    private static int factorial(int digit) {
        int fact = 1;
        for (int i = 2; i <= digit; i++) {
            fact *= i;
        }
        return fact;
    }

    // 4. Check if number is strong number
    public static boolean isStrong(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }
}

// CP - Extend or create a NumberChecker utility class and perform the following
// task. Call from main() method the different methods and display results. Make
// sure all are static methods
// Hint =>
// 1. Method to Check if a number is a perfect number. Perfect numbers are
// positive integers that are equal to the sum of their proper divisors
// 2. Method to find the number is an abundant number. A number is called an
// abundant number if the sum of its proper divisors is greater than the number
// itself
// 3. Method to find the number is a deficient number. A number is called a
// deficient number if the sum of its proper divisors is less than the number
// itself
// 4. Method to Check if a number is a strong number. A number is called a
// strong number if the sum of the factorial of its digits is equal to the
// number itself
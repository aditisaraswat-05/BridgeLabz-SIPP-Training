package Day4_Methods;

import java.util.Arrays;

public class NumberChecker3 {
    public static void main(String[] args) {
        int[] testNumbers = { 12321, 405, 123, 7001, 101, 0 };

        for (int number : testNumbers) {
            System.out.println("Number: " + number);

            int count = countDigits(number);
            System.out.println("Count of digits: " + count);

            int[] digits = getDigitsArray(number);
            System.out.println("Digits array: " + Arrays.toString(digits));

            int[] reversedDigits = reverseDigitsArray(digits);
            System.out.println("Reversed digits array: " + Arrays.toString(reversedDigits));

            boolean isPalindrome = isPalindrome(number);
            System.out.println("Is palindrome? " + isPalindrome);

            boolean isDuck = isDuckNumber(digits);
            System.out.println("Is duck number? " + isDuck);

            System.out.println("-----------------------------");
        }
    }

    // Method to count digits in number
    public static int countDigits(int number) {
        if (number == 0)
            return 1;
        int count = 0;
        int temp = Math.abs(number);
        while (temp > 0) {
            temp /= 10;
            count++;
        }
        return count;
    }

    // Method to get digits array
    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        int temp = Math.abs(number);

        for (int i = count - 1; i >= 0; i--) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        return digits;
    }

    // Method to reverse digits array
    public static int[] reverseDigitsArray(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

    // Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    // Method to check if a number is palindrome using digits
    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseDigitsArray(digits);
        return compareArrays(digits, reversed);
    }

    // Method to check if number is a duck number (has non-zero digit)
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit != 0) {
                return true;
            }
        }
        return false;
    }
}

// CP - Extend or create a NumberChecker utility class and perform the following
// task. Call from main() method the different methods and display results. Make
// sure all are static methods
// Hint =>
// 1. Method to find the count of digits in the number and a Method to store the
// digits of the number in a digits array
// 2. Method to reverse the digits array
// 3. Method to compare two arrays and check if they are equal
// 4. Method to check if a number is a palindrome using the Digits. A palindrome
// number is a number that remains the same when its digits are reversed.
// 5. Method to Check if a number is a duck number using the digits array. A
// duck number is a number that has a non-zero digit present in it

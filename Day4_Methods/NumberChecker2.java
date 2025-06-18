package Day4_Methods;

public class NumberChecker2 {
    public static void main(String[] args) {
        int[] testNumbers = { 7, 9, 153, 25, 49, 1, 19, 12 };

        for (int num : testNumbers) {
            System.out.println("Number: " + num);
            System.out.println("Is Prime? " + isPrime(num));
            System.out.println("Is Neon? " + isNeon(num));
            System.out.println("Is Spy? " + isSpy(num));
            System.out.println("Is Automorphic? " + isAutomorphic(num));
            System.out.println("Is Buzz? " + isBuzz(num));
            System.out.println("----------------------------");
        }
    }

    // 1. Check if number is prime
    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    // 2. Check if number is neon number
    public static boolean isNeon(int number) {
        int square = number * number;
        int sumDigits = 0;
        while (square > 0) {
            sumDigits += square % 10;
            square /= 10;
        }
        return sumDigits == number;
    }

    // 3. Check if number is spy number
    public static boolean isSpy(int number) {
        int sumDigits = 0;
        int productDigits = 1;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sumDigits += digit;
            productDigits *= digit;
            temp /= 10;
        }
        return sumDigits == productDigits;
    }

    // 4. Check if number is automorphic number
    public static boolean isAutomorphic(int number) {
        int square = number * number;
        String numberStr = String.valueOf(number);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(numberStr);
    }

    // 5. Check if number is buzz number
    public static boolean isBuzz(int number) {
        return (number % 7 == 0) || (number % 10 == 7);
    }
}

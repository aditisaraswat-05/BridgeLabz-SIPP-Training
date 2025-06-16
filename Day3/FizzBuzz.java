import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
            sc.close();
        }
    }
}

// CP - Write a program FizzBuzz, take a number as user input, and check for a
// positive integer. If positive
// integer, loop and print the number, but for multiples of 3 print "Fizz"
// instead of the number, for multiples of 5
// print "Buzz", and for multiples of both print "FizzBuzz".
// Hint =>
// 1. Take the user input number and check if it is a positive integer
// 2. Use while loop to display the output
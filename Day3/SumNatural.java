import java.util.Scanner;

public class SumNatural {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), sum = 0;
        for (int i = 1; i <= n; i++)
            sum += i;
        System.out.println("Sum: " + sum);
        sc.close();
    }
}

// CP - Write a program to find the sum of n natural numbers using for loop,
// compare the result with the
// formulae n*(n+1)/2 and show the result from both computations was correct.
// Hint =>
// 1. Take the user input number and check whether it's a Natural number
// 2. If it's a natural number Compute using formulae as well as compute using
// for loop
// 3. Compare the two results and print the result
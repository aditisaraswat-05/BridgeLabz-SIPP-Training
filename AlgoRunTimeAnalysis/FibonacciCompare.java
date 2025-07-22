package AlgoRunTimeAnalysis;

public class FibonacciCompare {

    // Recursive Fibonacci method
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci method
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Measure time for each method
    public static void measureTime(int n) {
        System.out.println("\nFibonacci of " + n);

        long start1 = System.currentTimeMillis();
        int rec = fibonacciRecursive(n);
        long end1 = System.currentTimeMillis();
        System.out.println("Recursive Result: " + rec + " | Time: " + (end1 - start1) + " ms");

        long start2 = System.currentTimeMillis();
        int itr = fibonacciIterative(n);
        long end2 = System.currentTimeMillis();
        System.out.println("Iterative Result: " + itr + " | Time: " + (end2 - start2) + " ms");
    }

    public static void main(String[] args) {
        measureTime(10);
        measureTime(30);

    }
}

// 5. Problem Statement: Recursive vs Iterative Fibonacci Computation
// Objective:
// Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
// Approach:
// Recursive:
// public static int fibonacciRecursive(int n) {
// if (n <= 1) return n;
// return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
// }

// Iterative:
// public static int fibonacciIterative(int n) {
// int a = 0, b = 1, sum;
// for (int i = 2; i <= n; i++) {
// sum = a + b;
// a = b;
// b = sum;
// }
// return b;
// }
// Expected Result:
// Recursive approach is infeasible for large values of N due to exponential
// growth.
// The iterative approach is significantly faster and memory-efficient.
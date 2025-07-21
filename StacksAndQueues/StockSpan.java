package StacksAndQueues;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {

    // Function to calculate span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and price at top is <=
            // current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, all previous prices were smaller
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push this element's index to stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input stock prices
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter stock prices for " + n + " days:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        // Calculate stock span
        int[] span = calculateSpan(prices);

        // result
        System.out.println("\nStock Span for each day:");
        for (int i = 0; i < n; i++) {
            System.out.println("Day " + (i + 1) + ": " + span[i]);
        }
    }
}

// Stock Span Problem
// Problem: For each day in a stock price array, calculate the span (number of
// consecutive days the price was less than or equal to the current day's
// price).
// Hint: Use a stack to keep track of indices of prices in descending order.

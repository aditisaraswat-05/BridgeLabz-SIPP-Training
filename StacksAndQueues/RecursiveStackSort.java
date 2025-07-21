package StacksAndQueues;

import java.util.Stack;

public class RecursiveStackSort {

    // Sorts the stack in ascending order using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            sortStack(stack);
            insertInSortedOrder(stack, top);
        }
    }

    // Inserts an element into a sorted stack
    public static void insertInSortedOrder(Stack<Integer> stack, int value) {
        // Base case: stack is empty or value >= top
        if (stack.isEmpty() || value >= stack.peek()) {
            stack.push(value);
            return;
        }

        // Pop and hold top, insert value, then push top back
        int temp = stack.pop();
        insertInSortedOrder(stack, value);
        stack.push(temp);
    }

    // Print stack from top to bottom
    public static void printStack(Stack<Integer> stack) {
        System.out.println("Stack (top to bottom):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Input unsorted elements
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        stack.push(40);

        System.out.println("Original Stack:");
        printStack(stack);

        // Sort the stack
        sortStack(stack);

        System.out.println("\nSorted Stack (ascending order):");
        printStack(stack);
    }
}

// Sort a Stack Using Recursion
// Problem: Given a stack, sort its elements in ascending order using recursion.
// Hint: Pop elements recursively, sort the remaining stack, and insert the
// popped element back at the correct position.

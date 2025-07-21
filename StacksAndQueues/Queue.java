package StacksAndQueues;

import java.util.Stack;

class QueueUsingStacks<T> {
    Stack<T> inStack = new Stack<>();
    Stack<T> outStack = new Stack<>();

    // Enqueue operation (O(1))
    public void enqueue(T data) {
        inStack.push(data);
        System.out.println("Enqueued: " + data);
    }

    // Dequeue operation (Amortized O(1))
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        if (outStack.isEmpty()) {
            // Transfer elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        T removed = outStack.pop();
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek front element
    public T peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return null;
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

public class Queue {
    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Peek: " + queue.peek()); // 10

        queue.dequeue(); // removes 10
        queue.dequeue(); // removes 20

        queue.enqueue(40);
        queue.enqueue(50);

        System.out.println("Peek: " + queue.peek()); // 30

        queue.dequeue(); // removes 30
        queue.dequeue(); // removes 40
        queue.dequeue(); // removes 50

        queue.dequeue(); // queue is empty
    }
}

// Implement a Queue Using Stacks
// Problem: Design a queue using two stacks such that enqueue and dequeue
// operations are performed efficiently.
// Hint: Use one stack for enqueue and another stack for dequeue. Transfer
// elements between stacks as needed.

package StacksAndQueues;

import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxInSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>(); // Stores indices

        for (int i = 0; i < nums.length; i++) {
            // Remove indices out of this window
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove all elements smaller than current from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element's index
            deque.offerLast(i);

            // Start adding max after first k elements
            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Input window size
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        // Get max in sliding windows
        List<Integer> result = maxInSlidingWindow(nums, k);

        // Output result
        System.out.println("\nMaximum in each sliding window:");
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}

// Sliding Window Maximum
// Problem: Given an array and a window size k, find the maximum element in each
// sliding window of size k.
// Hint: Use a deque (double-ended queue) to maintain indices of useful elements
// in each window.

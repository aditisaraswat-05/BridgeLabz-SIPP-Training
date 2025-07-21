package HashMap_HashFunction;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = findLongestSequence(arr);
        System.out.println("Length of longest consecutive sequence: " + result);
    }

    public static int findLongestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}

// Longest Consecutive Sequence
// Problem: Given an unsorted array, find the length of the longest consecutive
// elements sequence.
// Hint: Use a hash map to store elements and check for consecutive elements
// efficiently.

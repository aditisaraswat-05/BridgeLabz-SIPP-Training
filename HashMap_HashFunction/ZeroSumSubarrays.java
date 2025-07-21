package HashMap_HashFunction;

import java.util.*;

public class ZeroSumSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the method to find subarrays with zero sum
        findZeroSumSubarrays(arr);
    }

    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int sum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                List<Integer> list = map.get(sum);
                for (int start : list) {
                    System.out.println("Subarray found from index " + (start + 1) + " to " + i);
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }
}

// Find All Subarrays with Zero Sum
// Problem: Given an array, find all subarrays whose elements sum up to zero.
// Hint: Use a hash map to store the cumulative sum and its frequency. If a sum
// repeats, a zero-sum subarray exists.

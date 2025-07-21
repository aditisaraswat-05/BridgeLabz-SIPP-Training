package HashMap_HashFunction;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        // Call method to find two sum indices
        int[] result = findTwoSum(arr, target);

        if (result.length == 2) {
            System.out.println("Pair found at indices: " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
    }

    public static int[] findTwoSum(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int needed = target - arr[i];

            if (map.containsKey(needed)) {
                return new int[] { map.get(needed), i };
            }

            map.put(arr[i], i);
        }

        return new int[0];
    }
}

// Two Sum Problem
// Problem: Given an array and a target sum, find two indices such that their
// values add up to the target.
// Hint: Use a hash map to store the index of each element as you iterate. Check
// if target - current_element exists in the map.

package HashMap_HashFunction;

import java.util.*;

public class PairWithGivenSum {
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

        // Check if any pair adds up to target
        boolean found = hasPairWithSum(arr, target);

        if (found) {
            System.out.println("Yes, a pair with given sum exists.");
        } else {
            System.out.println("No such pair found.");
        }
    }

    public static boolean hasPairWithSum(int[] arr, int target) {

        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int needed = target - num;

            if (seen.contains(needed)) {
                return true;
            }

            seen.add(num);
        }

        // If no pair found
        return false;
    }
}

// Check for a Pair with Given Sum in an Array
// Problem: Given an array and a target sum, find if there exists a pair of
// elements whose sum is equal to the target.
// Hint: Store visited numbers in a hash map and check if target -
// current_number exists in the map.

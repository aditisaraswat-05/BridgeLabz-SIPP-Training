package AlgoRunTimeAnalysis;

import java.util.*;

public class SearchStructureComparison {

    // Linear Search in Array
    public static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 1_000_000;
        int target = size - 1; // Element to search
        int[] array = new int[size];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        System.out.println("Searching for: " + target);
        System.out.println("Dataset size: " + size);

        // Array Search
        long start1 = System.currentTimeMillis();
        boolean found1 = arraySearch(array, target);
        long end1 = System.currentTimeMillis();
        System.out.println("Array Search Found: " + found1 + " | Time: " + (end1 - start1) + " ms");

        // HashSet Search
        long start2 = System.currentTimeMillis();
        boolean found2 = hashSet.contains(target);
        long end2 = System.currentTimeMillis();
        System.out.println("HashSet Search Found: " + found2 + " | Time: " + (end2 - start2) + " ms");

        // TreeSet Search
        long start3 = System.currentTimeMillis();
        boolean found3 = treeSet.contains(target);
        long end3 = System.currentTimeMillis();
        System.out.println("TreeSet Search Found: " + found3 + " | Time: " + (end3 - start3) + " ms");
    }
}

// 6. Problem Statement: Comparing Different Data Structures for Searching
// Objective:
// Compare Array (O(N)), HashSet (O(1)), and TreeSet (O(log N)) for searching
// elements.
// Approach:
// Array: Linear search (O(N)).
// HashSet: Uses hashing (O(1) on average).
// TreeSet: Balanced BST (O(log N)).
// Expected Result:
// HashSet is fastest for lookups but requires extra memory.
// TreeSet maintains order but is slightly slower than HashSet.

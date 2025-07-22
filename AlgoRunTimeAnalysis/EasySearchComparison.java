package AlgoRunTimeAnalysis;

import java.util.Arrays;

public class EasySearchComparison {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    // Binary Search (sorted array)
    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void runTest(int size, int target) {
        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = i + 1;
        }

        // Measure Linear Search Time
        long startLinear = System.currentTimeMillis();
        linearSearch(data, target);
        long endLinear = System.currentTimeMillis();

        // Sort and Measure Binary Search Time
        Arrays.sort(data);
        long startBinary = System.currentTimeMillis();
        binarySearch(data, target);
        long endBinary = System.currentTimeMillis();

        System.out.println("Data Size: " + size);
        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ms");
        System.out.println("Binary Search Time: " + (endBinary - startBinary) + " ms");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        runTest(1000, 999);
        runTest(10000, 9999);
        runTest(1000000, 999999);
    }
}

// Problem Statement: Search a Target in a Large Dataset
// Objective:
// Compare the performance of Linear Search (O(N)) and Binary Search (O(log N))
// on different dataset sizes.
// Expected Result:
// Binary Search performs much better for large datasets, provided data is
// sorted.

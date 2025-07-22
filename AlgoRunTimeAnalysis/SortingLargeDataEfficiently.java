package AlgoRunTimeAnalysis;

import java.util.Arrays;
import java.util.Random;

public class SortingLargeDataEfficiently {

    // Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    // Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Run sort and print time
    public static void testSort(String name, int[] arr, String type) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        long start = System.currentTimeMillis();

        if (type.equals("bubble"))
            bubbleSort(copy);
        else if (type.equals("merge"))
            mergeSort(copy, 0, copy.length - 1);
        else if (type.equals("quick"))
            quickSort(copy, 0, copy.length - 1);

        long end = System.currentTimeMillis();
        System.out.println(name + " Sort Time: " + (end - start) + " ms");
    }

    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 1000000 };

        for (int size : sizes) {
            int[] data = new int[size];
            Random rand = new Random();

            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);
            }

            System.out.println("\nData Size: " + size);
            if (size <= 10000)
                testSort("Bubble", data, "bubble"); // Avoid for large size
            testSort("Merge", data, "merge");
            testSort("Quick", data, "quick");
        }
    }
}

// 2. Problem Statement: Sorting Large Data Efficiently
// Objective:
// Compare sorting algorithms Bubble Sort (O(N²)), Merge Sort (O(N log N)), and
// Quick Sort (O(N log N)).
// Approach:
// Bubble Sort: Repeated swapping (inefficient for large data).
// Merge Sort: Divide & Conquer approach (stable).
// Quick Sort: Partition-based approach (fast but unstable).
// Expected Result:
// Bubble Sort is impractical for large datasets.
// Merge Sort & Quick Sort perform well.

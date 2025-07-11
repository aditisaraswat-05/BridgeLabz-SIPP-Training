package SortingAlgorithm_DSA;

import java.util.Scanner;

public class QuickSortProductPrices {

    // Quick Sort function
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            // Find pivot position
            int pi = partition(arr, low, high);

            // Recursively sort left and right subarrays
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high]; // using last element as pivot
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        double[] prices = new double[n];

        System.out.println("Enter product prices:");
        for (int i = 0; i < n; i++) {
            System.out.print("Price of product " + (i + 1) + ": ");
            prices[i] = sc.nextDouble();
        }

        // Apply Quick Sort
        quickSort(prices, 0, prices.length - 1);

        // Display sorted prices
        System.out.println("\nSorted Product Prices (ascending order):");
        for (double price : prices) {
            System.out.print(price + " ");
        }
    }
}

// 4. Quick Sort - Sort Product Prices
// Problem Statement:
// An e-commerce company wants to display product prices in ascending order.
// Implement Quick Sort to sort the product prices.
// Hint:
// Pick a pivot element (first, last, or random).
// Partition the array such that elements smaller than the pivot are on the left
// and larger ones are on the right.
// Recursively apply Quick Sort on left and right partitions.

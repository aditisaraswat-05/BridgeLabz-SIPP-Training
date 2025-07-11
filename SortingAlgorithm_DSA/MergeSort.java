package SortingAlgorithm_DSA;

import java.util.Scanner;

public class MergeSort {

    // Merge Sort function
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Merge two sorted subarrays
    public static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = arr[mid + 1 + j];

        // Merge the temporary arrays

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k++] = leftArray[i++];
        }

        while (j < n2) {
            arr[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = sc.nextInt();

        double[] prices = new double[n];

        System.out.println("Enter the book prices:");
        for (int i = 0; i < n; i++) {
            System.out.print("Book " + (i + 1) + " price: ");
            prices[i] = sc.nextDouble();
        }

        // Sort using Merge Sort
        mergeSort(prices, 0, prices.length - 1);

        // Display sorted prices
        System.out.println("\nSorted Book Prices (ascending order):");
        for (double price : prices) {
            System.out.print(price + " ");
        }
    }
}

// 3. Merge Sort - Sort an Array of Book Prices
// Problem Statement:
// A bookstore maintains a list of book prices in an array. Implement Merge Sort
// to sort the prices in ascending order.
// Hint:
// Divide the array into two halves recursively.
// Sort both halves individually.
// Merge the sorted halves by comparing elements.

package SortingAlgorithm_DSA;

import java.util.Scanner;

public class HeapSortSalaries {

    // Heap Sort function
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Reheapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted at index i, n is size of heap
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2;// right = 2*i + 2

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of applicants
        System.out.print("Enter number of job applicants: ");
        int n = sc.nextInt();

        int[] salaries = new int[n];

        // Input salary demands
        System.out.println("Enter expected salary of each applicant:");
        for (int i = 0; i < n; i++) {
            System.out.print("Applicant " + (i + 1) + ": ");
            salaries[i] = sc.nextInt();
        }

        // Sort using Heap Sort
        heapSort(salaries);

        // Display sorted salaries
        System.out.println("\nSorted Salary Demands (ascending order):");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
}

// 6. Heap Sort - Sort Job Applicants by Salary
// Problem Statement:
// A company receives job applications with different expected salary demands.
// Implement Heap Sort to sort these salary demands in ascending order.
// Hint:
// Build a Max Heap from the array.
// Extract the largest element (root) and place it at the end.
// Reheapify the remaining elements and repeat until sorted.

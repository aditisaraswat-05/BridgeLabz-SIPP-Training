package SortingAlgorithm_DSA;

import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        int[] employeeIDs = new int[n];

        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            System.out.print("Employee " + (i + 1) + " ID: ");
            employeeIDs[i] = sc.nextInt();
        }

        // Insertion Sort
        insertionSort(employeeIDs);

        // Display sorted IDs
        System.out.println("\nSorted Employee IDs (ascending order):");
        for (int id : employeeIDs) {
            System.out.print(id + " ");
        }
    }

    // Insertion Sort function
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place the key at its correct position
            arr[j + 1] = key;
        }
    }
}

// 2. Insertion Sort - Sort Employee IDs
// Problem Statement:
// A company stores employee IDs in an unsorted array. Implement Insertion Sort
// to sort the employee IDs in ascending order.
// Hint:
// Divide the array into sorted and unsorted parts.
// Pick an element from the unsorted part and insert it into its correct
// position in the sorted part.
// Repeat for all elements.

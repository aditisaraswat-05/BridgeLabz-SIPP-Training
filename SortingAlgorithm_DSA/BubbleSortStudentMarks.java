package SortingAlgorithm_DSA;

import java.util.Scanner;

public class BubbleSortStudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] marks = new int[n];

        // Input the marks
        System.out.println("Enter the marks of students:");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        // Perform Bubble Sort
        bubbleSort(marks);

        // Display sorted marks
        System.out.println("\nSorted student marks (ascending order):");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }

    // Bubble Sort function
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Last i elements are already in place
            for (int j = 0; j < n - 1 - i; j++) {
                // Swap if the element is greater than the next
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no two elements were swapped in the inner loop, then break
            if (!swapped)
                break;
        }
    }
}

// 1. Bubble Sort - Sort Student Marks
// Problem Statement:
// A school maintains student marks in an array. Implement Bubble Sort to sort
// the student marks in ascending order.
// Hint:
// Traverse through the array multiple times.
// Compare adjacent elements and swap if needed.
// Repeat the process until no swaps are required.

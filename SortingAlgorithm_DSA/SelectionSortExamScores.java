package SortingAlgorithm_DSA;

import java.util.Scanner;

public class SelectionSortExamScores {

    // Selection Sort method
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            System.out.print("Score of Student " + (i + 1) + ": ");
            scores[i] = sc.nextInt();
        }

        // Sort using Selection Sort
        selectionSort(scores);

        // Display sorted scores
        System.out.println("\nSorted Exam Scores (ascending order):");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}

// 5. Selection Sort - Sort Exam Scores
// Problem Statement:
// A university needs to sort students’ exam scores in ascending order.
// Implement Selection Sort to achieve this.
// Hint:
// Find the minimum element in the array.
// Swap it with the first unsorted element.
// Repeat the process for the remaining elements.

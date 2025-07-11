package SortingAlgorithm_DSA;

import java.util.Scanner;

public class CountingSortStudentAges {

    // Counting Sort function
    public static void countingSort(int[] ages) {
        int min = 10;
        int max = 18;
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count the frequency of each age
        for (int age : ages) {
            count[age - min]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        // Copy sorted output back to original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];

        // Input student ages
        System.out.println("Enter the ages of students (between 10 and 18):");
        for (int i = 0; i < n; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            int age = sc.nextInt();
            if (age < 10 || age > 18) {
                System.out.println("Invalid age. Please enter between 10 and 18.");
                i--;
            } else {
                ages[i] = age;
            }
        }

        // Sort using Counting Sort
        countingSort(ages);

        // Display sorted ages
        System.out.println("\nSorted Student Ages (ascending order):");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

// 7. Counting Sort - Sort Student Ages
// Problem Statement:
// A school collects students’ ages (ranging from 10 to 18) and wants them
// sorted. Implement Counting Sort for this task.
// Hint:
// Create a count array to store the frequency of each age.
// Compute cumulative frequencies to determine positions.
// Place elements in their correct positions in the output array.

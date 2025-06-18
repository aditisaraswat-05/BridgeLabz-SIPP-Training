package Day4_Methods;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions
        System.out.print("Enter rows and columns for Matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();

        System.out.print("Enter rows and columns for Matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();

        // Create random matrices
        int[][] A = createRandomMatrix(rowsA, colsA);
        int[][] B = createRandomMatrix(rowsB, colsB);

        // Display matrices
        System.out.println("\nMatrix A:");
        printMatrix(A);

        System.out.println("\nMatrix B:");
        printMatrix(B);

        // Perform operations
        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nAddition (A + B):");
            printMatrix(addMatrices(A, B));

            System.out.println("\nSubtraction (A - B):");
            printMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition/Subtraction not possible: Dimension mismatch.");
        }

        if (colsA == rowsB) {
            System.out.println("\nMultiplication (A * B):");
            printMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication not possible: Columns of A ≠ Rows of B.");
        }

        sc.close();
    }

    // ───── Method to create a random matrix ─────
    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random rand = new Random();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // Random values 0–9
        return matrix;
    }

    // ───── Addition ─────
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    // ───── Subtraction ─────
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    // ───── Multiplication ─────
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length;
        int colsB = B[0].length;
        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < colsB; j++)
                for (int k = 0; k < colsA; k++)
                    result[i][j] += A[i][k] * B[k][j];

        return result;
    }

    // ───── Print matrix ─────
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
}

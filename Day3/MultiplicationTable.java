import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        // Step 2: Loop from 6 to 9 and print multiplication table
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + (number * i));
            sc.close();
        }
    }
}

// CP - Create a program to find the multiplication table of a number entered by
// the user from 6 to 9.
// Hint =>
// 1. Take integer input and store it in the variable number
// 2. Using a for loop, find the multiplication table of number from 6 to 9 and
// print it in the format number * i =
// ___

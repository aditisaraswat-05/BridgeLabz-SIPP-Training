import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get input and validate
        System.out.print("Enter a positive number less than 100: ");
        int number = sc.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Number must be positive and less than 100.");
            return;
        }

        // Step 2: Loop backwards from 100 to 1
        System.out.println("Multiples of " + number + " below 100:");
        for (int i = 100; i >= 1; i--) {
            // Step 3: Check if i is a multiple of the number
            if (i % number == 0) {
                // Step 4: Print the multiple
                System.out.println(i);
                sc.close();
            }
        }
    }
}

// CP - Create a program to find all the multiple of a number taken as user
// input below 100.
// Hint =>
// 1. Get the input value for a variable named number. Check the number is a
// positive integer and less than
// 100.
// 2. Use a for loop backwards: from i = 100 to i = 1.
// 3. Inside the loop, check if i perfectly divide the number.
// 4. If true, print the number and continue the loop.

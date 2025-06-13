package Day2;

import java.util.Scanner;

public class q17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Input number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();

        // Step 2: Calculate handshakes using combination formula
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

        // Step 3: Output the result
        System.out.println("The maximum number of possible handshakes among " +
                numberOfStudents + " students is: " + handshakes);

        input.close();
    }

}

// CP - Create a program to find the maximum number of handshakes among N number
// of students.
// Hint =>
// 1. Get integer input for the numberOfStudents variable.
// 2. Use the combination = (n * (n - 1)) / 2 formula to calculate the maximum
// number of possible
// handshakes.
// 3. Display the number of possible handshakes.
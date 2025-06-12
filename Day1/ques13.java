package Day1;

import java.util.Scanner;

public class ques13 {
    public static void main(String[] args) {
        double perimeter, side;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the perimeter of the square: ");
        perimeter = input.nextDouble();

        // Calculate the side
        side = perimeter / 4.0;
        System.out.println("The length of the side is " + side +
                " whose perimeter is " + perimeter);

        input.close();
    }
}

// CP - Write a program to find the side of the square whose parameter you read
// from the user
// Hint => The Perimeter of the Square is 4 times the side
// I/P => perimeter
// O/P => The length of the side is ___ whose perimeter is ____
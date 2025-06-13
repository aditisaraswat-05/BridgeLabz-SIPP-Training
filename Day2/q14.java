package Day2;

import java.util.Scanner;

public class q14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = input.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = input.nextInt();

        // Check for division by zero
        if (numberOfChildren == 0) {
            System.out.println("Chocolates cannot be divided among 0 children.");
        } else {
            // Calculate
            int chocolatesPerChild = numberOfChocolates / numberOfChildren;
            int remainingChocolates = numberOfChocolates % numberOfChildren;

            System.out.println("The number of chocolates each child gets is " + chocolatesPerChild +
                    " and the number of remaining chocolates is " + remainingChocolates);
        }

        input.close();
    }
}

// CP - Create a program to divide N number of chocolates among M children.
// Hint =>
// 1. Get an integer value from the user for the numberOfchocolates and
// numberOfChildren.
// 2. Find the number of chocolates each child gets and the number of remaining
// chocolates
// 3. Display the results
// I/P => numberOfchocolates, numberOfChildren
// O/P => The number of chocolates each child gets is ___ and the number of
// remaining chocolates is __
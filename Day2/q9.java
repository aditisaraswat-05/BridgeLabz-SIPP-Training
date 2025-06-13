package Day2;

import java.util.Scanner;

public class q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the unit price (INR): ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter the quantity: ");
        int quantity = sc.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalPrice +
                " if the quantity is " + quantity + " and the unit price is INR " + unitPrice);

        sc.close();
    }
}

// CP - Write a program to input the unit price of an item and the quantity to
// be bought. Then, calculate the
// total purchase price.
// Hint => NA
// I/P => unitPrice, quantity
// O/P => The total purchase price is INR ___ if the quantity ___ and the unit
// price is INR ___
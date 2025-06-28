package Workshop;

import java.util.Scanner;

public class CoffeeCounterChronicles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String coffeeType;
        int quantity;
        double price = 0, total, gst, finalAmount;

        while (true) {
            System.out.print("\nEnter coffee type (espresso, latte, cappuccino, mocha) or 'exit' to stop: ");
            coffeeType = sc.nextLine();

            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for visiting Ravi's Cafe!");
                break;
            }

            System.out.print("Enter quantity: ");
            quantity = sc.nextInt();
            sc.nextLine();

            switch (coffeeType.toLowerCase()) {
                case "espresso":
                    price = 100;
                    break;
                case "latte":
                    price = 120;
                    break;
                case "cappuccino":
                    price = 150;
                    break;
                case "mocha":
                    price = 180;
                    break;
                default:
                    System.out.println("Invalid coffee type!");
                    continue;
            }

            total = price * quantity;
            gst = total * 0.18;
            finalAmount = total + gst;

            System.out.println("Total (without GST): ₹" + total);
            System.out.println("GST (18%): ₹" + gst);
            System.out.println("Final Amount: ₹" + finalAmount);
        }

        sc.close();
    }
}

// Ravi runs a cafe. Each Customer Orders different Coffee types with
// quantities. Write a program that :
// 1- Ask for coffee type(switch)
// 2- Calculate total bills (Price*Quantity)
// 3- Adds GST using Arthematic Operators
// use while to continue for the next customer and break when "exit" is typed.
package Day2;

public class q2 {
    public static void main(String[] args) {
        int fee = 125000;
        int discountPercent = 10;

        int discountAmount = (fee * discountPercent) / 100;
        int finalFee = fee - discountAmount;

        System.out.println(
                "The discount amount is INR " + discountAmount + " and final discounted fee is INR " + finalFee);
    }
}

// CP - The University is charging the student a fee of INR 125000 for the
// course. The University is willing
// to offer a discount of 10%. Write a program to find the discounted amount and
// discounted price the
// student will pay for the course.
// Hint =>
// Create a variable named fee and assign 125000 to it.
// Create another variable discountPercent and assign 10 to it.
// Compute discount and assign it to the discount variable.
// Compute and print the fee you have to pay by subtracting the discount from
// the fee.
// O/P => The discount amount is INR ___ and final discounted fee is INR ___

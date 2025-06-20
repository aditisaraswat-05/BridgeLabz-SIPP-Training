package Built_In_Functions;

import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first date
        System.out.print("Enter the first date (YYYY-MM-DD): ");
        String firstInput = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstInput);

        // Input second date
        System.out.print("Enter the second date (YYYY-MM-DD): ");
        String secondInput = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondInput);

        // Compare dates
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is BEFORE the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is AFTER the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are EQUAL.");
        }

        scanner.close();
    }
}

// Date Comparison Write a program that:
// ➢ Takes two date inputs and compares them to check if the first date is
// before, after,
// or the same as the second date.
// Hint: Use isBefore(), isAfter(), and isEqual() methods from the LocalDate

// class.

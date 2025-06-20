package Built_In_Functions;

import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input date from user
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String input = scanner.nextLine();

        // Parse string to LocalDate
        LocalDate date = LocalDate.parse(input);

        // Add 7 days, 1 month, 2 years
        LocalDate updatedDate = date.plusDays(7).plusMonths(1).plusYears(2);
        System.out.println("After adding 7 days, 1 month, and 2 years: " + updatedDate);

        // Subtract 3 weeks
        LocalDate finalDate = updatedDate.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + finalDate);

        scanner.close();
    }
}

// Date Arithmetic Create a program that:
// ➢ Takes a date input and adds 7 days, 1 month, and 2 years to it.
// ➢ Then subtracts 3 weeks from the result.
// Hint: Use LocalDate.plusDays(), plusMonths(), plusYears(), and
// minusWeeks() methods.

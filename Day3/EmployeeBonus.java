import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your years of service: ");
        int yearsOfService = sc.nextInt();

        // Check eligibility for bonus
        if (yearsOfService > 5) {
            double bonus = 0.05 * salary;
            System.out.println("You are eligible for a bonus of: ₹" + bonus);
        } else {
            System.out.println("You are not eligible for a bonus.");
            sc.close();
        }
    }
}

// CP - Create a program to find the bonus of employees based on their years of
// service.
// Hint =>
// 1. Zara decided to give a bonus of 5% to employees whose year of service is
// more than 5 years.
// 2. Take salary and year of service in the year as input.
// 3. Print the bonus amount.

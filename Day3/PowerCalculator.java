import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();

        System.out.print("Enter the power: ");
        int power = sc.nextInt();

        // Initialize result
        int result = 1;

        // Multiply in loop
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        System.out.println(number + " raised to the power " + power + " is: " + result);
        sc.close();
    }
}

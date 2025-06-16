import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt(), exp = sc.nextInt(), result = 1;
        for (int i = 1; i <= exp; i++) {
            result *= base;
        }
        System.out.println("Result: " + result);
        sc.close();
    }
}

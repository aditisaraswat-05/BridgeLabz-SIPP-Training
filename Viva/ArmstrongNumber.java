public class ArmstrongNumber {
    public static void main(String[] args) {
        for (int n = 1; n <= 100; n++) {
            int num = n;
            int sum = 0;

            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit * digit;
                num = num / 10;
            }

            if (sum == n) {
                System.out.print(n + " ");
            }
        }
    }
}

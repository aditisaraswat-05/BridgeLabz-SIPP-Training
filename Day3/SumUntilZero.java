import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            int num = sc.nextInt();
            if (num <= 0)
                break;
            sum += num;
        }
        System.out.println("Sum: " + sum);
        sc.close();
    }
}

// CP - Rewrite the program 10 to find the sum until the user enters 0 or a
// negative number using while loop
// and break statement
// Hint =>
// 1. Use infinite while loop as in while (true)
// 2. Take the user entry and check if the user entered 0 or a negative number
// to break the loop using
// break;

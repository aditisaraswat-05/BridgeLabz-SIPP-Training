import java.util.Scanner;

public class CountDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count >= 1) {
            System.out.println(count);
            count--;
        }
        System.out.println("Launch!");
        sc.close();
    }
}

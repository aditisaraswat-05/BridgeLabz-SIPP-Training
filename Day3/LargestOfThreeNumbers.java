import java.util.Scanner;

public class LargestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if (a > b && a > c)
            System.out.println("First is largest");
        else if (b > a && b > c)
            System.out.println("Second is largest");
        else
            System.out.println("Third is largest");
        sc.close();
    }
}

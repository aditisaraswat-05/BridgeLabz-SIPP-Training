import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt(), day = sc.nextInt();
        if ((month == 3 && day >= 20) || (month > 3 && month < 6) || (month == 6 && day <= 20))
            System.out.println("Spring");
        else
            System.out.println("Not Spring");
    }
}

// CP - Write a program SpringSeason that takes two int values month and day
// from the command line and
// prints “Its a Spring Season” otherwise prints “Not a Spring Season”.
// Hint =>
// 1. Spring Season is from March 20 to June 20
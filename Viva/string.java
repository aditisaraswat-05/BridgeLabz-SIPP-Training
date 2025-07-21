
import java.util.Scanner;

public class string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String n = sc.nextLine();

        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);

            if ("AEIOUaeiou".indexOf(ch) != -1) {
                int ascii = (int) ch;
                System.out.println(ch + " -> " + ascii);
            }
        }

        sc.close();
    }
}

// Take string as a input from user , seprate the vowels from it and find ASCII
// Value
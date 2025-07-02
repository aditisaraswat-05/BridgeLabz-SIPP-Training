import java.util.Scanner;

public class Paragraph {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the paragraph");
        String para = sc.nextLine();
        String[] words = para.trim().split("\\s+");

        // If the paragraph is empty or contains only spaces
        if (para.trim().isEmpty()) {
            System.out.println("Word count: 0");
        } else {
            System.out.println("Word count: " + words.length);
        }
        sc.close();
    }
}

// Take paragraph from user as input and count the number of words in it
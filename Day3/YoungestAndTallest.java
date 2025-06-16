import java.util.Scanner;

public class YoungestAndTallest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = { "Amar", "Akbar", "Anthony" };
        int[] ages = new int[3];
        float[] heights = new float[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Age of " + names[i] + ": ");
            ages[i] = sc.nextInt();
            System.out.print("Height of " + names[i] + ": ");
            heights[i] = sc.nextFloat();
        }

        int youngestIndex = (ages[0] < ages[1] ? (ages[0] < ages[2] ? 0 : 2) : (ages[1] < ages[2] ? 1 : 2));
        int tallestIndex = (heights[0] > heights[1] ? (heights[0] > heights[2] ? 0 : 2)
                : (heights[1] > heights[2] ? 1 : 2));

        System.out.println("Youngest: " + names[youngestIndex]);
        System.out.println("Tallest: " + names[tallestIndex]);
        sc.close();
    }
}

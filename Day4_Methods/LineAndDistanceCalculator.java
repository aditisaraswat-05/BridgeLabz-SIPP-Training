package Day4_Methods;

import java.util.Scanner;

public class LineAndDistanceCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input points
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Calculate and display distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance = %.2f\n", distance);

        // Calculate and display line equation
        double[] lineEquation = findLineEquation(x1, y1, x2, y2);
        System.out.printf("Slope (m) = %.2f\n", lineEquation[0]);
        System.out.printf("Y-intercept (b) = %.2f\n", lineEquation[1]);
        System.out.printf("Equation of line: y = %.2fx + %.2f\n", lineEquation[0], lineEquation[1]);

        sc.close();
    }

    // Method to calculate Euclidean distance
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // Method to compute slope and y-intercept of the line
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double m = (y2 - y1) / (x2 - x1); // slope
        double b = y1 - m * x1; // y-intercept
        return new double[] { m, b }; // return as array
    }
}

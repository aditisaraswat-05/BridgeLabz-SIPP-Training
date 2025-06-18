package Day4_Methods;

import java.util.Scanner;

public class QuadraticRoots {

    // Method to find roots of a quadratic equation
    public static double[] findRoots(double a, double b, double c) {
        double delta = Math.pow(b, 2) - 4 * a * c;

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[] { root1, root2 };
        } else if (delta == 0) {
            double root = -b / (2 * a);
            return new double[] { root };
        } else {
            // No real roots
            return new double[] {}; // empty array
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input values
        System.out.print("Enter value of a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter value of b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter value of c: ");
        double c = scanner.nextDouble();

        // Get roots
        double[] roots = findRoots(a, b, c);

        // Display results
        if (roots.length == 2) {
            System.out.println("Two real roots: " + roots[0] + " and " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("One real root: " + roots[0]);
        } else {
            System.out.println("No real roots.");
        }

        scanner.close();
    }
}

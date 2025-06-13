package Day2;

import java.util.Scanner;

public class q19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input sides of the triangular park in meters
        System.out.print("Enter the length of side 1 (in meters): ");
        double side1 = input.nextDouble();

        System.out.print("Enter the length of side 2 (in meters): ");
        double side2 = input.nextDouble();

        System.out.print("Enter the length of side 3 (in meters): ");
        double side3 = input.nextDouble();

        // Calculate perimeter
        double perimeter = side1 + side2 + side3;

        // Total distance to be covered = 5 km = 5000 meters
        double rounds = 5000 / perimeter;

        // Output result
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km.");

        input.close();
    }
}

// CP - An athlete runs in a triangular park with sides provided as input by the
// user in meters. If the athlete
// wants to complete a 5 km run, then how many rounds must the athlete complete
// Hint => The perimeter of a triangle is the addition of all sides and the
// number of rounds is the
// distance/perimeter
// I/P => side1, side2, side3
// O/P => The total number of rounds the athlete will run is ___ to complete 5
// km

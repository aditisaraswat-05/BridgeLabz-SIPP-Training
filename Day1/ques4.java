package Day1;

import java.util.Scanner;

public class ques4 {
    public static void main(String args[]) {
        double radius;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the radius");
        radius = sc.nextDouble();

        double volumeKm3 = (4.0 / 3) * 3.14 * Math.pow(radius, 3);// Calculate volume in km³

        // Convert radius to miles and calculate volume in mi³
        double radiusMiles = radius * 0.621371;
        double volumeMiles3 = (4.0 / 3) * 3.14 * Math.pow(radiusMiles, 3);
        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
        sc.close();
    }
}

// CP - Write a Program to compute the volume of Earth in km^3 and miles^3
// Hint => Volume of a Sphere is (4/3) * pi * r^3 and radius of earth is 6378 km
// O/P => The volume of earth in cubic kilometers is ____ and cubic miles is
// ____
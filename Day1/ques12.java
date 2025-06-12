package Day1;

import java.util.Scanner;

public class ques12 {

    public static void main(String[] args) {
        double base, height, areaCm, areaInches;
        final double cmPerInch = 2.54;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter base of triangle in cm: ");
        base = input.nextDouble();

        System.out.print("Enter height of triangle in cm: ");
        height = input.nextDouble();

        // Compute area in square cm
        areaCm = 0.5 * base * height;

        // Convert area to square inches
        // (1 in = 2.54 cm => 1 sq in = 2.54 * 2.54 = 6.4516 sq cm)
        areaInches = areaCm / (cmPerInch * cmPerInch);

        System.out.println("The Area of the triangle in square cm is " + areaCm +
                " and in square inches is " + areaInches);

        input.close();
    }
}

// CP - Write a program that takes the base and height in cm to find the area of
// a triangle in square inches
// and square centimeters
// Hint => Area of a Triangle is ½ * base * height and 1 in = 2.54 cm
// I/P => base, height
// O/P => The Area of the triangle in sq in is ___ and sq cm is ___
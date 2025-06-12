package Day1;

import java.util.Scanner;

public class ques9 {

    public static void main(String[] args) {

        double distanceInFeet, distanceInYards, distanceInMiles;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in feet: ");
        distanceInFeet = input.nextDouble();

        // Convert feet to yards and miles
        distanceInYards = distanceInFeet / 3.0;
        distanceInMiles = distanceInYards / 1760.0;

        System.out.println("The distance in yards is " + distanceInYards +
                " while the distance in miles is " + distanceInMiles);

        input.close();
    }
}

// CP - Write a program to find the distance in yards and miles for the distance
// provided by the user in feet
// Hint => 1 mile = 1760 yards and 1 yard is 3 feet
// I/P => distanceInFeet
// O/P => The distance in yards is ___ while the distance in miles is ___

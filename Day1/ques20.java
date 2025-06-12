package Day1;

import java.util.Scanner;

public class ques20 {
    public static void main(String[] args) {

        String name, fromCity, viaCity, toCity;
        double fromToVia, viaToFinalCity;
        int timeFromToVia, timeViaToFinalCity;
        double totalDistance;
        int totalTime;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        name = input.nextLine();

        System.out.print("Enter From City: ");
        fromCity = input.nextLine();

        System.out.print("Enter Via City: ");
        viaCity = input.nextLine();

        System.out.print("Enter To City: ");
        toCity = input.nextLine();

        System.out.print("Enter distance from " + fromCity + " to " + viaCity + " (in miles): ");
        fromToVia = input.nextDouble();

        System.out.print("Enter distance from " + viaCity + " to " + toCity + " (in miles): ");
        viaToFinalCity = input.nextDouble();

        System.out.print("Enter time from " + fromCity + " to " + viaCity + " (in minutes): ");
        timeFromToVia = input.nextInt();

        System.out.print("Enter time from " + viaCity + " to " + toCity + " (in minutes): ");
        timeViaToFinalCity = input.nextInt();

        // Compute total distance (converted to kilometers) and total time
        totalDistance = (fromToVia + viaToFinalCity) * 1.60934; // 1 mile = 1.60934 km
        totalTime = timeFromToVia + timeViaToFinalCity;

        System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " +
                toCity + " via " + viaCity + " is " + totalDistance + " km and the Total Time taken is " +
                totalTime + " minutes.");

        input.close();
    }
}

// CP - Rewrite the Sample Program 2 with user inputs
// Hint =>
// 1. Create variables and take user inputs for name, fromCity, viaCity, toCity
// 2. Create variables and take user inputs for distances fromToVia and
// viaToFinalCity in Miles
// 3. Create Variables and take user input for the time taken: From City to Via
// City and Via City to Final
// Destination
// 4. Finally, print the result and try to understand operator precedence.
// I/P => name, fromCity, viaCity, toCity, fromToVia, viaToFinalCity,
// timeFromToVia, timeViaToFinalCity
// O/P => The Total Distance travelled by ___ from ___ to ___ via ___ is ___ km
// and the Total Time taken
// is ___ minutes
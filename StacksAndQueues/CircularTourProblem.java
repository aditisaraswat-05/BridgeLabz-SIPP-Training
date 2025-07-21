package StacksAndQueues;

import java.util.Scanner;

class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTourProblem {

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int currSurplus = 0;
        int totalSurplus = 0;

        for (int i = 0; i < n; i++) {
            int diff = pumps[i].petrol - pumps[i].distance;
            currSurplus += diff;
            totalSurplus += diff;

            // If current surplus becomes negative, move start to next pump
            if (currSurplus < 0) {
                start = i + 1;
                currSurplus = 0;
            }
        }

        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of petrol pumps
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        PetrolPump[] pumps = new PetrolPump[n];

        // Input petrol and distance for each pump
        System.out.println("Enter petrol and distance to next pump for each pump:");
        for (int i = 0; i < n; i++) {
            System.out.print("Pump " + (i + 1) + " (petrol distance): ");
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }

        // Find starting point
        int start = findStartingPoint(pumps);

        // Output result
        if (start == -1) {
            System.out.println("\nNo solution exists. Truck can't complete the circular tour.");
        } else {
            System.out.println("\nTruck can start at pump index: " + start);
        }
    }
}

// Circular Tour Problem
// Problem: Given a set of petrol pumps with petrol and distance to the next
// pump, determine the starting point for completing a circular tour.
// Hint: Use a queue to simulate the tour, keeping track of surplus petrol at
// each pump.

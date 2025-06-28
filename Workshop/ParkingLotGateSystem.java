package Workshop;

import java.util.Scanner;

public class ParkingLotGateSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX_SPOTS = 5; // total parking slots
        boolean[] parking = new boolean[MAX_SPOTS]; // false = empty, true = occupied
        int parkedCount = 0;

        while (true) {
            System.out.println("\n==== Parking Menu ====");
            System.out.println("1. Park a Vehicle");
            System.out.println("2. Exit a Vehicle");
            System.out.println("3. Show Occupancy");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Park
                    if (parkedCount == MAX_SPOTS) {
                        System.out.println("Parking Full! No more vehicles can be parked.");
                    } else {
                        // Find first empty spot
                        for (int i = 0; i < MAX_SPOTS; i++) {
                            if (!parking[i]) {
                                parking[i] = true;
                                parkedCount++;
                                System.out.println("Vehicle parked at spot #" + (i + 1));
                                break;
                            }
                        }
                    }
                    break;

                case 2: // Exit
                    System.out.print("Enter spot number to exit (1 to " + MAX_SPOTS + "): ");
                    int spot = sc.nextInt();
                    if (spot < 1 || spot > MAX_SPOTS) {
                        System.out.println("Invalid spot number!");
                    } else if (!parking[spot - 1]) {
                        System.out.println("Spot #" + spot + " is already empty.");
                    } else {
                        parking[spot - 1] = false;
                        parkedCount--;
                        System.out.println("Vehicle removed from spot #" + spot);
                    }
                    break;

                case 3: // Show occupancy
                    System.out.println("=== Parking Spot Status ===");
                    for (int i = 0; i < MAX_SPOTS; i++) {
                        System.out.println("Spot #" + (i + 1) + ": " + (parking[i] ? "Occupied" : "Empty"));
                    }
                    break;

                case 4: // Quit
                    System.out.println("Exiting Parking System. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            // Auto-stop if full
            if (parkedCount == MAX_SPOTS) {
                System.out.println("\nAll spots are full. Parking system stopping automatically.");
                break;
            }
        }
    }
}

// Develop a smart Parking system
// - Options: PArk, exit, Show Occupancy
// - Use switch-case for the menu.
// - while loop to countinue until the parking lot is full or the user exits.
package Assigment_OOPS;

public class VehicleRegistrationSystem {

    // Vehicle class definition
    static class Vehicle {
        // Static variable common to all vehicles
        static double registrationFee = 5000.0;

        // Static method to update registration fee
        static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: ₹" + registrationFee);
        }

        // Instance variables
        private String ownerName;
        private String vehicleType;
        private final String registrationNumber; // Final variable: cannot be changed

        // Constructor using 'this' keyword
        public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
            this.registrationNumber = registrationNumber;
        }

        // Method to display registration details using instanceof
        public void displayDetails() {
            if (this instanceof Vehicle) {
                System.out.println("Owner Name         : " + ownerName);
                System.out.println("Vehicle Type       : " + vehicleType);
                System.out.println("Registration Number: " + registrationNumber);
                System.out.println("Registration Fee   : ₹" + registrationFee);
            } else {
                System.out.println("Object is not a valid Vehicle.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Creating Vehicle objects
        Vehicle v1 = new Vehicle("Amit Kumar", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Priya Mehta", "Bike", "MH14CD5678");

        // Display details of each vehicle
        System.out.println("\nVehicle 1 Details:");
        v1.displayDetails();

        System.out.println("\nVehicle 2 Details:");
        v2.displayDetails();

        // Update registration fee
        System.out.println();
        Vehicle.updateRegistrationFee(5500.0);

        // Display details again after fee update
        System.out.println("\nVehicle 1 Details (After Fee Update):");
        v1.displayDetails();

        // Test instanceof with non-Vehicle object
        Object fakeVehicle = new String("Fake Data");
        if (fakeVehicle instanceof Vehicle) {
            ((Vehicle) fakeVehicle).displayDetails();
        } else {
            System.out.println("\nObject is not an instance of Vehicle.");
        }
    }
}

// Sample Program 6: Vehicle Registration System
// Create a Vehicle class with the following features:
// Static:
// ○ A static variable registrationFee common for all vehicles.
// ○ A static method updateRegistrationFee() to modify the fee.
// This:
// ○ Use this to initialize ownerName, vehicleType, and registrationNumber in
// the constructor.
// Final:
// ○ Use a final variable registrationNumber to uniquely identify each vehicle.
// Instanceof:
// ○ Check if an object belongs to the Vehicle class before displaying its
// registration
// ○ details.

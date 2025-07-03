package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// Interface for insurance details
interface Insurable {
    double calculateInsurance();

    String getInsuranceDetails();
}

// Abstract base class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation: Getters and Setters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Common display method
    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: ₹" + rentalRate);
    }
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 2000.0; // Fixed insurance for car
    }

    public String getInsuranceDetails() {
        return "Car Insurance Policy: #" + insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String policy) {
        this.insurancePolicyNumber = policy;
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    public double calculateInsurance() {
        return 500.0; // Fixed insurance for bike
    }

    public String getInsuranceDetails() {
        return "Bike Insurance Policy: #" + insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String policy) {
        this.insurancePolicyNumber = policy;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    public double calculateRentalCost(int days) {
        // Assume truck has extra surcharge per day
        return (getRentalRate() + 500) * days;
    }

    public double calculateInsurance() {
        return 3000.0; // Fixed insurance for truck
    }

    public String getInsuranceDetails() {
        return "Truck Insurance Policy: #" + insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String policy) {
        this.insurancePolicyNumber = policy;
    }
}

// Main class
public class VechileRentalSystem {
    // Polymorphic method
    public static void processRentals(List<Vehicle> vehicles, int days) {
        for (Vehicle v : vehicles) {
            System.out.println("\n--- Vehicle Details ---");
            v.displayDetails();

            double rentalCost = v.calculateRentalCost(days);
            System.out.println("Rental Cost for " + days + " day(s): ₹" + rentalCost);

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost: ₹" + ins.calculateInsurance());
            } else {
                System.out.println("No insurance applicable.");
            }
        }
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("MH12AB1234", 1500, "CAR789XYZ"));
        vehicles.add(new Bike("MH12BC5678", 500, "BIKE456ABC"));
        vehicles.add(new Truck("MH12CD9012", 3000, "TRUCK123PQR"));

        int rentalDays = 3;
        processRentals(vehicles, rentalDays);
    }
}

// Vehicle Rental System
// Description: Design a system to manage vehicle rentals:
// Define an abstract class Vehicle with fields like vehicleNumber, type, and
// rentalRate.
// Add an abstract method calculateRentalCost(int days).
// Create subclasses Car, Bike, and Truck with specific implementations of
// calculateRentalCost().
// Use an interface Insurable with methods calculateInsurance() and
// getInsuranceDetails().
// Apply encapsulation to restrict access to sensitive details like insurance
// policy numbers.
// Demonstrate polymorphism by iterating over a list of vehicles and calculating
// rental and insurance costs for each.

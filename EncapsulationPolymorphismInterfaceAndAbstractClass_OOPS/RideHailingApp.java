package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// GPS Interface
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm, String location) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = location;
    }

    // Encapsulation - Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    protected void setCurrentLocation(String location) {
        this.currentLocation = location;
    }

    protected String getCurrentLocationValue() {
        return currentLocation;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }
}

// Car subclass
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50; // ₹50 base charge for cars
    }

    public String getCurrentLocation() {
        return getCurrentLocationValue();
    }

    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Car location updated to: " + newLocation);
    }
}

// Bike subclass
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm(); // no base charge
    }

    public String getCurrentLocation() {
        return getCurrentLocationValue();
    }

    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Bike location updated to: " + newLocation);
    }
}

// Auto subclass
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20; // ₹20 base charge for autos
    }

    public String getCurrentLocation() {
        return getCurrentLocationValue();
    }

    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Auto location updated to: " + newLocation);
    }
}

// Main class
public class RideHailingApp {
    // Polymorphic fare processing
    public static void processRide(Vehicle vehicle, double distance) {
        System.out.println("\n--- Ride Details ---");
        vehicle.getVehicleDetails();
        double fare = vehicle.calculateFare(distance);
        System.out.printf("Distance: %.2f km\n", distance);
        System.out.printf("Total Fare: ₹%.2f\n", fare);
    }

    public static void main(String[] args) {
        // Create vehicles
        Vehicle car = new Car("C101", "Aditi", 15.0, "MG Road");
        Vehicle bike = new Bike("B202", "Ravi", 8.0, "Indira Nagar");
        Vehicle auto = new Auto("A303", "Priya", 10.0, "Brigade Road");

        // Update location
        ((GPS) car).updateLocation("Airport");
        ((GPS) bike).updateLocation("Railway Station");
        ((GPS) auto).updateLocation("City Center");

        // Process rides
        processRide(car, 10.0);
        processRide(bike, 5.5);
        processRide(auto, 7.0);
    }
}

// Ride-Hailing Application
// Description: Develop a ride-hailing application:
// Define an abstract class Vehicle with fields like vehicleId, driverName, and
// ratePerKm.
// Add abstract methods calculateFare(double distance) and a concrete method
// getVehicleDetails().
// Create subclasses Car, Bike, and Auto, overriding calculateFare() based on
// type-specific rates.
// Use an interface GPS with methods getCurrentLocation() and updateLocation().
// Secure driver and vehicle details using encapsulation.
// Demonstrate polymorphism by creating a method to calculate fares for
// different vehicle types dynamically.

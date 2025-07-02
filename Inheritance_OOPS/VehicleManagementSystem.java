package Inheritance_OOPS;

// Superclass
class Vehicle {
    String model;
    int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// Subclass - ElectricVehicle
class ElectricVehicle extends Vehicle {
    int batteryLevel;

    public ElectricVehicle(String model, int maxSpeed, int batteryLevel) {
        super(model, maxSpeed);
        this.batteryLevel = batteryLevel;
    }

    public void charge() {
        System.out.println("Charging electric vehicle...");
        batteryLevel = 100;
        System.out.println("Battery is fully charged.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Level: " + batteryLevel + "%");
    }
}

// Subclass - PetrolVehicle implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    double fuelLevel;

    public PetrolVehicle(String model, int maxSpeed, double fuelLevel) {
        super(model, maxSpeed);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling petrol vehicle...");
        fuelLevel = 100.0;
        System.out.println("Fuel tank is full.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Level: " + fuelLevel + "%");
    }
}

// Main class
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200, 50);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 30.0);

        System.out.println("=== Electric Vehicle Details ===");
        ev.displayInfo();
        ev.charge();
        ev.displayInfo();

        System.out.println("\n=== Petrol Vehicle Details ===");
        pv.displayInfo();
        pv.refuel();
        pv.displayInfo();
    }
}

// Sample Problem 2: Vehicle Management System with Hybrid Inheritance
// Description: Model a vehicle system where Vehicle is the superclass and
// ElectricVehicle and PetrolVehicle are subclasses. Additionally, create a
// Refuelable interface implemented by PetrolVehicle.
// Tasks:
// Define a superclass Vehicle with attributes like maxSpeed and model.
// Create an interface Refuelable with a method refuel().
// Define subclasses ElectricVehicle and PetrolVehicle. PetrolVehicle should
// implement Refuelable, while ElectricVehicle include a charge() method.
// Goal: Use hybrid inheritance by having PetrolVehicle implement both Vehicle
// and Refuelable, demonstrating how Java interfaces allow adding multiple
// behaviors.

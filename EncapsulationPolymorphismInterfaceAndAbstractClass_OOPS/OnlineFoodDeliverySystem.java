package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// Discountable interface
interface Discountable {
    void applyDiscount(double discountPercent); // e.g., 10% discount

    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulation: Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Prevent direct modification
    protected void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discount = 0.0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - (total * discount / 100);
    }

    public void applyDiscount(double discountPercent) {
        this.discount = discountPercent;
    }

    public String getDiscountDetails() {
        return "Veg Item Discount: " + discount + "%";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0.0;
    private double nonVegCharge = 20.0; // fixed charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double base = (getPrice() + nonVegCharge) * getQuantity();
        return base - (base * discount / 100);
    }

    public void applyDiscount(double discountPercent) {
        this.discount = discountPercent;
    }

    public String getDiscountDetails() {
        return "Non-Veg Item Discount: " + discount + "% + ₹" + nonVegCharge + " non-veg charge per item";
    }
}

// Main class
public class OnlineFoodDeliverySystem {

    // Polymorphic method
    public static void processOrder(List<FoodItem> orderList) {
        for (FoodItem item : orderList) {
            System.out.println("\n--- Order Item ---");
            item.getItemDetails();

            if (item instanceof Discountable) {
                Discountable disc = (Discountable) item;
                System.out.println(disc.getDiscountDetails());
            }

            double total = item.calculateTotalPrice();
            System.out.printf("Total Price: ₹%.2f\n", total);
        }
    }

    public static void main(String[] args) {
        List<FoodItem> orderList = new ArrayList<>();

        VegItem vegBurger = new VegItem("Veg Burger", 80, 2);
        vegBurger.applyDiscount(10);

        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 200, 1);
        chickenPizza.applyDiscount(5);

        orderList.add(vegBurger);
        orderList.add(chickenPizza);

        processOrder(orderList);
    }
}

// Online Food Delivery System
// Description: Create an online food delivery system:
// Define an abstract class FoodItem with fields like itemName, price, and
// quantity.
// Add abstract methods calculateTotalPrice() and concrete methods like
// getItemDetails().
// Extend it into classes VegItem and NonVegItem, overriding
// calculateTotalPrice() to include additional charges (e.g., for non-veg
// items).
// Use an interface Discountable with methods applyDiscount() and
// getDiscountDetails().
// Demonstrate encapsulation to restrict modifications to order details and use
// polymorphism to handle different types of food items in a single
// order-processing method.

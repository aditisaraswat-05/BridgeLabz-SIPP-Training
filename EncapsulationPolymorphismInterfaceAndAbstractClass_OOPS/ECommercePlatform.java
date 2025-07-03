package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// Taxable interface
interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Common display method
    public void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    private double warrantyCharge;

    public Electronics(int id, String name, double price, double warrantyCharge) {
        super(id, name, price);
        this.warrantyCharge = warrantyCharge;
    }

    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    public String getTaxDetails() {
        return "Electronics Tax: 18% GST";
    }

    public double getWarrantyCharge() {
        return warrantyCharge;
    }

    public void setWarrantyCharge(double warrantyCharge) {
        this.warrantyCharge = warrantyCharge;
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }

    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    public String getTaxDetails() {
        return "Clothing Tax: 5% GST";
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

// Groceries class (non-taxable for simplicity)
class Groceries extends Product {

    private double weight;

    public Groceries(int id, String name, double price, double weight) {
        super(id, name, price);
        this.weight = weight;
    }

    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

// Main class
public class ECommercePlatform {

    // Polymorphic method
    public static void calculateFinalPrice(List<Product> productList) {
        for (Product p : productList) {
            System.out.println("\n--- Product Details ---");
            p.displayInfo();

            double discount = p.calculateDiscount();
            double tax = 0;

            // Only if product is taxable
            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                System.out.println(((Taxable) p).getTaxDetails());
            } else {
                System.out.println("No Tax applicable.");
            }

            double finalPrice = p.getPrice() + tax - discount;
            System.out.printf("Discount: ₹%.2f\n", discount);
            System.out.printf("Tax: ₹%.2f\n", tax);
            System.out.printf("Final Price: ₹%.2f\n", finalPrice);
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();

        Electronics laptop = new Electronics(101, "Laptop", 60000, 2000);
        Clothing tshirt = new Clothing(102, "T-Shirt", 1200, "M");
        Groceries rice = new Groceries(103, "Basmati Rice", 800, 5);

        productList.add(laptop);
        productList.add(tshirt);
        productList.add(rice);

        calculateFinalPrice(productList);
    }
}

// E-Commerce Platform
// Description: Develop a simplified e-commerce platform:
// Create an abstract class Product with fields like productId, name, and price,
// and an abstract method calculateDiscount().
// Extend it into concrete classes: Electronics, Clothing, and Groceries.
// Implement an interface Taxable with methods calculateTax() and
// getTaxDetails() for applicable product categories.
// Use encapsulation to protect product details, allowing updates only through
// setter methods.
// Showcase polymorphism by creating a method that calculates and prints the
// final price (price + tax - discount) for a list of Product.

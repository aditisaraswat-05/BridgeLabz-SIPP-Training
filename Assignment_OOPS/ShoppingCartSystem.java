package Assignment_OOPS;

public class ShoppingCartSystem {

    // Product class (inner class)
    static class Product {
        // Static variable (shared by all products)
        static double discount = 10.0; // in percentage

        // Static method to update discount
        static void updateDiscount(double newDiscount) {
            discount = newDiscount;
            System.out.println("Discount updated to: " + discount + "%");
        }

        // Instance variables
        private String productName;
        private double price;
        private int quantity;
        private final String productID; // Final variable (unchangeable)

        // Constructor using 'this' keyword
        public Product(String productName, double price, int quantity, String productID) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.productID = productID;
        }

        // Display product details (using instanceof)
        public void displayDetails() {
            if (this instanceof Product) {
                System.out.println("Product Name         : " + productName);
                System.out.println("Product ID           : " + productID);
                System.out.println("Unit Price           : ₹" + price);
                System.out.println("Quantity             : " + quantity);
                System.out.println("Discount             : " + discount + "%");
                double finalPrice = price - (price * discount / 100);
                System.out.println("Price After Discount : ₹" + finalPrice);
                System.out.println("Total Cost           : ₹" + (finalPrice * quantity));
            } else {
                System.out.println("Object is not a Product.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        // Creating Product objects
        Product product1 = new Product("Smartphone", 20000.0, 1, "PRD101");
        Product product2 = new Product("Bluetooth Speaker", 3000.0, 2, "PRD102");

        // Display product details
        System.out.println("\nProduct 1 Details:");
        product1.displayDetails();

        System.out.println("\nProduct 2 Details:");
        product2.displayDetails();

        // Updating discount
        System.out.println();
        Product.updateDiscount(15.0); // Update discount for all products

        // Display again after discount change
        System.out.println("\nProduct 1 Details (After Discount Update):");
        product1.displayDetails();

        // Test instanceof with invalid object
        Object fakeProduct = new String("This is not a product");
        if (fakeProduct instanceof Product) {
            ((Product) fakeProduct).displayDetails();
        } else {
            System.out.println("\nObject is not an instance of Product.");
        }
    }
}

// Sample Program 4: Shopping Cart System
// Create a Product class to manage shopping cart items with the following
// features:
// Static:
// ○ A static variable discount shared by all products.
// ○ A static method updateDiscount() to modify the discount percentage.
// This:
// ○ Use this to initialize productName, price, and quantity in the constructor.
// Final:
// ○ Use a final variable productID to ensure each product has a unique
// identifier that cannot be changed.
// Instanceof:
// ○ Validate whether an object is an instance of the Product class before
// processing its details.

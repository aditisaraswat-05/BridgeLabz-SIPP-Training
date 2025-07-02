package ObjectOrientedDesignPrincipals;

import java.util.*;

// Product class
class Product {
    String productName;
    double price;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    void display() {
        System.out.println("- " + productName + " (₹" + price + ")");
    }
}

// Order class (aggregates Products)
class Order {
    String orderId;
    List<Product> products;

    Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    void addProduct(Product product) {
        products.add(product);
    }

    double getTotalOrderValue() {
        double total = 0;
        for (Product p : products) {
            total += p.price;
        }
        return total;
    }

    void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Ordered Products:");
        for (Product p : products) {
            p.display();
        }
        System.out.println("Total Order Value: ₹" + getTotalOrderValue());
    }
}

// Customer class (places orders)
class Customer {
    String name;
    List<Order> orders;

    Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    void placeOrder(Order order) {
        orders.add(order);
    }

    void showOrders() {
        System.out.println("Customer: " + name);
        for (Order o : orders) {
            o.displayOrder();
            System.out.println();
        }
    }
}

// Main class
public class EcommercePlatform {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1000);

        // Create order and add products
        Order order1 = new Order("ORD001");
        order1.addProduct(p1);
        order1.addProduct(p2);

        // Create another order
        Order order2 = new Order("ORD002");
        order2.addProduct(p3);

        // Create customer and place orders
        Customer customer = new Customer("Riya");
        customer.placeOrder(order1);
        customer.placeOrder(order2);

        // Display customer's orders
        customer.showOrders();
    }
}

// Problem 4: E-commerce Platform with Orders, Customers, and Products
// Description: Design an e-commerce platform with Order, Customer, and Product
// classes. Model relationships where a Customer places an Order, and each Order
// contains multiple Product objects.
// Goal: Show communication and object relationships by designing a system where
// customers communicate through orders, and orders aggregate products.

package Inheritance_OOPS;

// Base class
class Order {
    String orderId;
    String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }

    public void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
    }
}

// Subclass of Order
class ShippedOrder extends Order {
    String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass of ShippedOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }

    @Override
    public void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        DeliveredOrder order = new DeliveredOrder(
                "ORD1234", "2025-06-28", "TRK5678", "2025-07-01");

        System.out.println("=== Order Details ===");
        order.displayOrderInfo();
        System.out.println("Status: " + order.getOrderStatus());
    }
}

// Sample Problem 1: Online Retail Order Management
// Description: Create a multilevel hierarchy to manage orders, where Order is
// the base class, ShippedOrder is a subclass, and DeliveredOrder extends
// ShippedOrder.
// Tasks:
// Define a base class Order with common attributes like orderId and orderDate.
// Create a subclass ShippedOrder with additional attributes like
// trackingNumber.
// Create another subclass DeliveredOrder extending ShippedOrder, adding a
// deliveryDate attribute.
// Implement a method getOrderStatus() to return the current order status based
// on the class level.
// Goal: Explore multilevel inheritance, showing how attributes and methods can
// be added across a chain of classes.
package Java_Generics;

import java.util.*;

// Abstract base class
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getItemName() {
        return name;
    }

    public abstract String getCategory();
}

// Electronics class
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

// Groceries class
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}

// Furniture class
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}

// Generic storage class
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getAllItems() {
        return items;
    }
}

// Utility class with wildcard method
class DisplayUtil {
    public static void showItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getItemName() + " (" + item.getCategory() + ")");
        }
    }
}

// Main class
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Television"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Oil"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics Items:");
        DisplayUtil.showItems(electronicsStorage.getAllItems());

        System.out.println("\nGrocery Items:");
        DisplayUtil.showItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture Items:");
        DisplayUtil.showItems(furnitureStorage.getAllItems());
    }
}

// 1. Smart Warehouse Management System
// Concepts: Generic Classes, Bounded Type Parameters, Wildcards
// Problem Statement:
// You are developing a Smart Warehouse System that manages different types of
// items like Electronics, Groceries, and Furniture. The system should be able
// to store and retrieve items dynamically while maintaining type safety.
// Hints:
// Create an abstract class WarehouseItem that all items extend (Electronics,
// Groceries, Furniture).
// Implement a generic class Storage<T extends WarehouseItem> to store items
// safely.
// Implement a wildcard method to display all items in storage regardless of
// their type (List<? extends WarehouseItem>).
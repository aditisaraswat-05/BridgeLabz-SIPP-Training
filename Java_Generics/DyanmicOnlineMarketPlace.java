package Java_Generics;

// Category:common interface
interface Category {
    String getName();
}

// Book categories
enum BookType implements Category {
    STORY, EDUCATIONAL;

    public String getName() {
        return name();
    }
}

// Clothing categories
enum ClothesType implements Category {
    MEN, WOMEN;

    public String getName() {
        return name();
    }
}

enum GadgetType implements Category {
    PHONE, LAPTOP;

    public String getName() {
        return name();
    }
}

class Item<C extends Category> {
    String itemName;
    double itemPrice;
    C itemType;

    public Item(String name, double price, C type) {
        this.itemName = name;
        this.itemPrice = price;
        this.itemType = type;
    }

    void printDetails() {
        System.out.println("Name: " + itemName);
        System.out.println("Type: " + itemType.getName());
        System.out.println("Price: ₹" + itemPrice);
    }

    double getPrice() {
        return itemPrice;
    }

    void setPrice(double p) {
        itemPrice = p;
    }
}

// Discount lagane wala method (generic)
class DiscountHandler {
    public static <C extends Category> void giveDiscount(Item<C> item, double percent) {
        double cut = item.getPrice() * (percent / 100);
        double finalPrice = item.getPrice() - cut;
        item.setPrice(finalPrice);
        System.out.println("Applied " + percent + "% discount.");
    }
}

public class DyanmicOnlineMarketPlace {
    public static void main(String[] args) {
        Item<BookType> book1 = new Item<>("Learn Java", 450.0, BookType.EDUCATIONAL);
        Item<ClothesType> tshirt = new Item<>("T-Shirt", 600.0, ClothesType.MEN);
        Item<GadgetType> mobile = new Item<>("Android Phone", 12000.0, GadgetType.PHONE);

        System.out.println("Before Discount:");
        book1.printDetails();

        DiscountHandler.giveDiscount(book1, 15);

        System.out.println("After Discount:");
        book1.printDetails();

        System.out.println("\nOther Items:");
        tshirt.printDetails();
        System.out.println();
        mobile.printDetails();
    }
}

// 2. Dynamic Online Marketplace
// Concepts: Type Parameters, Generic Methods, Bounded Type Parameters
// Problem Statement:
// Build a generic product catalog for an online marketplace that supports
// various product types like Books, Clothing, and Gadgets. Each product type
// has a specific price range and category.
// Hints:
// Define a generic class Product<T> where T is restricted to a category
// (BookCategory, ClothingCategory, etc.).
// Implement a generic method to apply discounts dynamically (<T extends
// Product> void applyDiscount(T product, double percentage)).
// Ensure type safety while allowing multiple product categories to exist in the
// same catalog.

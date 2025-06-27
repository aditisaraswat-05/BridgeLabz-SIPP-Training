package Assigment_OOPS;

class BankAccount {
    // Static variable shared across all BankAccount instances
    static String bankName = "National Trust Bank";

    // Static counter to track total number of accounts
    static int totalAccounts = 0;

    // Static method to display total number of accounts
    static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    // Instance variables
    private String accountHolderName;
    private final String accountNumber; // Final variable to ensure immutability

    // Constructor using 'this' keyword
    public BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++; // Increment count on each new account
    }

    // Method to display account details with instanceof check
    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number     : " + accountNumber);
            System.out.println("Bank Name          : " + bankName);
        } else {
            System.out.println("Not a valid BankAccount object.");
        }
    }
}

// Main class to test the BankAccount system
public class BankAccountSystem {
    public static void main(String[] args) {
        // Create bank accounts
        BankAccount acc1 = new BankAccount("Alice", "AC12345");
        BankAccount acc2 = new BankAccount("Bob", "AC67890");

        // Display details
        System.out.println("\nAccount 1 Details:");
        acc1.displayDetails();

        System.out.println("\nAccount 2 Details:");
        acc2.displayDetails();

        // Show total number of accounts
        System.out.println();
        BankAccount.getTotalAccounts();

        // Test instanceof on unrelated object
        Object obj = new String("Random String");
        if (obj instanceof BankAccount) {
            ((BankAccount) obj).displayDetails();
        } else {
            System.out.println("\nObject is not an instance of BankAccount.");
        }
    }
}

// Sample Program 1: Bank Account System
// Create a BankAccount class with the following features:
// Static:
// ○ A static variable bankName is shared across all accounts.
// ○ A static method getTotalAccounts() to display the total number of accounts.
// This:
// ○ Use this to resolve ambiguity in the constructor when initializing
// accountHolderName and accountNumber.
// Final:
// ○ Use a final variable accountNumber to ensure it cannot be changed once
// assigned.
// Instanceof:
// ○ Check if an account object is an instance of the BankAccount class before
// displaying its details.
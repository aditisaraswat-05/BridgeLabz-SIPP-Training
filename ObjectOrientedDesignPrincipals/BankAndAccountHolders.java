package ObjectOrientedDesignPrincipals;

import java.util.*;

// Account class (linked to both bank and customer)
class Account {
    String accountNumber;
    double balance;
    Bank bank;

    Account(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber + ", Balance: ₹" + balance + ", Bank: " + bank.bankName);
    }
}

// Customer class
class Customer {
    String name;
    List<Account> accounts;

    Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    // Associate account with customer
    void addAccount(Account acc) {
        accounts.add(acc);
    }

    void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            acc.displayAccountDetails();
        }
        System.out.println();
    }
}

// Bank class
class Bank {
    String bankName;
    List<Customer> customers;

    Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // Associate customer and account with bank
    void openAccount(Customer customer, String accountNumber, double initialBalance) {
        Account newAcc = new Account(accountNumber, initialBalance, this);
        customer.addAccount(newAcc);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account opened at " + bankName + " for " + customer.name);
    }

    void listCustomers() {
        System.out.println("Customers of " + bankName + ":");
        for (Customer c : customers) {
            System.out.println("- " + c.name);
        }
        System.out.println();
    }
}

// Main class
public class BankAndAccountHolders {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("City Bank");

        Customer cust1 = new Customer("Ravi");
        Customer cust2 = new Customer("Neha");

        // Customers open accounts in different banks
        bank1.openAccount(cust1, "SB123", 5000);
        bank1.openAccount(cust2, "SB456", 10000);

        bank2.openAccount(cust1, "CB999", 7000); // Ravi has accounts in two banks

        System.out.println();
        bank1.listCustomers();
        bank2.listCustomers();

        cust1.viewBalance();
        cust2.viewBalance();
    }
}

// Problem 2: Bank and Account Holders (Association)
// Description: Model a relationship where a Bank has Customer objects
// associated with it. A Customer can have multiple bank accounts, and each
// account is linked to a Bank.
// Tasks:
// Define a Bank class and a Customer class.
// Use an association relationship to show that each customer has an account in
// a bank.
// Implement methods that enable communication, such as openAccount() in the
// Bank class and viewBalance() in the Customer class.
// Goal: Illustrate association by setting up a relationship between customers
// and the bank.

package EncapsulationPolymorphismInterfaceAndAbstractClass_OOPS;

import java.util.*;

// Loanable interface
interface Loanable {
    void applyForLoan(double amount);

    boolean calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance;

    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Encapsulation: Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Abstract method for interest
    public abstract double calculateInterest();

    // Common display method
    public void displayAccountInfo() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: ₹" + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4%

    public SavingsAccount(String accNum, String name, double balance) {
        super(accNum, name, balance);
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a personal loan of ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return balance >= 10000; // eligible if balance ≥ ₹10,000
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2%

    public CurrentAccount(String accNum, String name, double balance) {
        super(accNum, name, balance);
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a business loan of ₹" + amount);
    }

    public boolean calculateLoanEligibility() {
        return balance >= 50000; // eligible if balance ≥ ₹50,000
    }
}

// Main class
public class BankingSystem {
    public static void processAccounts(List<BankAccount> accounts) {
        for (BankAccount acc : accounts) {
            System.out.println("\n--- Account Details ---");
            acc.displayAccountInfo();

            double interest = acc.calculateInterest();
            System.out.printf("Interest Earned: ₹%.2f\n", interest);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                loan.applyForLoan(50000);
                if (loan.calculateLoanEligibility()) {
                    System.out.println("Loan Eligibility: ✅ Eligible");
                } else {
                    System.out.println("Loan Eligibility: ❌ Not Eligible");
                }
            }
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount sa1 = new SavingsAccount("SA1001", "Aditi", 12000);
        CurrentAccount ca1 = new CurrentAccount("CA2001", "Rohan", 40000);
        SavingsAccount sa2 = new SavingsAccount("SA1002", "Meena", 9000);
        CurrentAccount ca2 = new CurrentAccount("CA2002", "Ankit", 70000);

        accounts.add(sa1);
        accounts.add(ca1);
        accounts.add(sa2);
        accounts.add(ca2);

        // Transactions
        sa1.deposit(2000);
        ca1.withdraw(5000);
        sa2.withdraw(1000);

        // Process all accounts (polymorphism)
        processAccounts(accounts);
    }
}

// Banking System
// Description: Create a banking system with different account types:
// Define an abstract class BankAccount with fields like accountNumber,
// holderName, and balance.
// Add methods like deposit(double amount) and withdraw(double amount)
// (concrete) and calculateInterest() (abstract).
// Implement subclasses SavingsAccount and CurrentAccount with unique interest
// calculations.
// Create an interface Loanable with methods applyForLoan() and
// calculateLoanEligibility().
// Use encapsulation to secure account details and restrict unauthorized access.
// Demonstrate polymorphism by processing different account types and
// calculating interest dynamically.

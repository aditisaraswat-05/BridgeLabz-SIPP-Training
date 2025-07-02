package Inheritance_OOPS;

// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    // Constructor
    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass 1: SavingsAccount
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
        displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2: CheckingAccount
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayDetails();
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass 3: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        displayDetails();
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

// Main class to test
public class BankAccountTypes {
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("SA123", 15000, 4.5);
        CheckingAccount ca = new CheckingAccount("CA456", 10000, 5000);
        FixedDepositAccount fda = new FixedDepositAccount("FD789", 50000, 12);

        System.out.println("----- Savings Account -----");
        sa.displayAccountType();
        System.out.println("\n----- Checking Account -----");
        ca.displayAccountType();
        System.out.println("\n----- Fixed Deposit Account -----");
        fda.displayAccountType();
    }
}

// Sample Problem 1: Bank Account Types
// Description: Model a banking system with different account types using
// hierarchical inheritance. BankAccount is the superclass, with SavingsAccount,
// CheckingAccount, and FixedDepositAccount as subclasses.
// Tasks:
// Define a base class BankAccount with attributes like accountNumber and
// balance.
// Define subclasses SavingsAccount, CheckingAccount, and FixedDepositAccount,
// each with unique attributes like interestRate for SavingsAccount and
// withdrawalLimit for CheckingAccount.
// Implement a method displayAccountType() in each subclass to specify the
// account type.
// Goal: Explore hierarchical inheritance, demonstrating how each subclass can
// have unique attributes while inheriting from a shared superclass.

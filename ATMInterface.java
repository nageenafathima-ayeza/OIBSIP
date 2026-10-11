import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) { balance = initialBalance; }
    public double getBalance() { return balance; }
    public void deposit(double amount) { balance += amount; }
    public boolean withdraw(double amount) {
        if (amount <= balance) { balance -= amount; return true; }
        else { return false; }
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) { this.account = account; }
    public void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
    public void start() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Choose option: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1: System.out.println("Balance: Rs." + account.getBalance()); break;
                case 2: System.out.print("Enter deposit amount: "); double dep = sc.nextDouble(); account.deposit(dep); System.out.println("Deposited successfully!"); break;
                case 3: System.out.print("Enter withdraw amount: "); double wit = sc.nextDouble(); if (account.withdraw(wit)) System.out.println("Withdraw successful!"); else System.out.println("Insufficient balance!"); break;
                case 4: System.out.println("Thank you for using ATM!"); break;
                default: System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
}
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(5000);
        ATM atm = new ATM(myAccount);
        atm.start();
    }
}

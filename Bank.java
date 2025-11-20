package Lab2;

import java.util.Scanner;

public class Bank {
    private double amount;

    // Constructor to initialize amount
    public Bank(double amount) {
        this.amount = amount;
    }

    // Withdraw method
    public void withdraw(double withdrawalAmount) {
        if (withdrawalAmount <= amount) {
            amount -= withdrawalAmount;
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
        displayBalance(); // Show balance after withdrawal
    }

    // Deposit method
    public void deposit(double depositAmount) {
        amount += depositAmount;
        System.out.println("Deposit successful");
        displayBalance(); // Show balance after deposit
    }

    // Display balance
    public void displayBalance() {
        System.out.println("Total balance: " + amount);
    }

    // Main method with menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank account = new Bank(10000); // Initial amount

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the bank system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
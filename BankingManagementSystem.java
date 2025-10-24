import java.util.Scanner;

public class BankingManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Create Customer
        System.out.println("Create Customer");
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Customer Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Aadharcard Number: ");
        String aadhar = sc.nextLine();

        System.out.print("Enter Pancard Number: ");
        String pancard = sc.nextLine();

        // Initial Balance
        double balance = 2000.0;
        System.out.println("Account Created Successfully with Minimum Balance ₹2000!");

        // Display Details
        System.out.println("\n Customer Details");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phone);
        System.out.println("Aadhar: " + aadhar);
        System.out.println("Pancard: " + pancard);
        System.out.println("Initial Balance: ₹" + balance);

        // Menu Display
        System.out.println("\n Banking Operations");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Apply for Loan");
        System.out.println("5. Fixed Deposit");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Operations using Conditional Statements
        if (choice == 1) {
            System.out.print("Enter Deposit Amount: ");
            double deposit = sc.nextDouble();
            if (deposit > 0) {
                balance = balance + deposit;
                System.out.println("₹" + deposit + " deposited successfully.");
                System.out.println("Updated Balance: ₹" + balance);
            } else {
                System.out.println("Invalid deposit amount!");
            }
        }

        else if (choice == 2) {
            System.out.print("Enter Withdrawal Amount: ");
            double withdraw = sc.nextDouble();
            if (withdraw <= 0) {
                System.out.println("Invalid withdrawal amount!");
            } else if (balance - withdraw < 2000) {
                System.out.println("Cannot withdraw! Maintain ₹2000 minimum balance.");
            } else {
                balance = balance - withdraw;
                System.out.println("₹" + withdraw + " withdrawn successfully.");
                System.out.println("Updated Balance: ₹" + balance);
            }
        }

        else if (choice == 3) {
            System.out.println("Current Balance: ₹" + balance);
        }

        else if (choice == 4) {
            System.out.println("Loan Process");
            System.out.print("Enter Loan Amount: ");
            double loan = sc.nextDouble();
            System.out.print("Enter Loan Duration (in years): ");
            int years = sc.nextInt();
            double rate = 8.5;
            double total = loan + (loan * rate * years / 100);
            System.out.println("Loan Approved for ₹" + loan);
            System.out.println("Total Payable after " + years + " years = ₹" + total);
        }

        else if (choice == 5) {
            System.out.println("Fixed Deposit");
            System.out.print("Enter FD Amount: ");
            double fd = sc.nextDouble();
            if (fd > balance - 2000) {
                System.out.println("Not enough balance! Maintain ₹2000 minimum in your account.");
            } else {
                System.out.print("Enter FD Duration (in years): ");
                int fdYears = sc.nextInt();
                double fdRate = 6.5;
                double maturity = fd + (fd * fdRate * fdYears / 100);
                balance = balance - fd;
                System.out.println("FD Created Successfully!");
                System.out.println("Maturity Amount after " + fdYears + " years: ₹" + maturity);
            }
        }

        else if (choice == 6) {
            System.out.println("Thank you for using the Banking Management System!");
        }

        else {
            System.out.println("Invalid choice! Please run the program again.");
        }

        sc.close();
    }
}

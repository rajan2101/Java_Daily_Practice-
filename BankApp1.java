public class BankApp1 extends BankApp {

    public void atmMenu() {
        System.out.print("Enter PIN to access ATM: ");
        int enteredPin = sc.nextInt();

        if (enteredPin != getPin_no()) {
            System.out.println("Invalid PIN. Access Denied.");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Balance Check");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    amt = sc.nextInt();
                    setBalance(getBalance() + amt);
                    System.out.println("Deposited ₹" + amt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    amt = sc.nextInt();
                    if (amt <= getBalance()) {
                        setBalance(getBalance() - amt);
                        System.out.println("Withdrawn ₹" + amt);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    System.out.println("Current Balance: ₹" + getBalance());
                    break;
                case 4:
                    System.out.print("Enter new PIN: ");
                    int newPin = sc.nextInt();
                    setPin_no(newPin);
                    System.out.println("PIN changed successfully.");
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM.");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void main(String[] args) {
        BankApp1 b1 = new BankApp1();
        b1.accept();   
        b1.atmMenu();
    }
}

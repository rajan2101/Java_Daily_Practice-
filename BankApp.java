import java.util.Scanner;

public class BankApp{
	int act_no,amt;
	private int Pin_no, balance = 2000;
	String name;
	Scanner sc=new Scanner(System.in);

	public int getPin_no() {
		return Pin_no;
	}

	public void setPin_no(int pin_no) {
		Pin_no = pin_no;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void display() {
        System.out.println("Hello " + name + "\nBalance = ₹" + balance);
    }

    public void accept() {
        System.out.println("Enter your name:");
        name = sc.next();
        System.out.println("Enter your account number:");
        act_no = sc.nextInt();
        System.out.println("Set your PIN:");
        Pin_no = sc.nextInt();
        System.out.println("Enter initial deposit amount:");
        amt = sc.nextInt();
        balance += amt;
    }
}



	

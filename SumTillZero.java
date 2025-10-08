import java.util.Scanner;

public class SumTillZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        int sum = 0;

        if (num > 0) {
            for (int i = 0; i <= num; i++) {
                sum = sum + i;
            }
            System.out.println("The addition from 0 to " + num + " is: " + sum);
        } else {
            System.out.println("Please enter a positive number.");
        }

        sc.close();
    }
}

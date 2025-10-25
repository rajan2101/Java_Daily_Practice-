import java.util.Scanner;

public class Primecheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int i = 2;
        int count = 0; // counts divisors

        while (i < num) {
            if (num % i == 0) {
                count++;
            }
            i++;
        }

        // Using loop logic to decide prime or not
        String result = (num > 1 && count == 0) ? "is a prime number." : "is not a prime number.";
        System.out.println(num + " " + result);

        sc.close();
    }
}

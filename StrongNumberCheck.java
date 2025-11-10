import java.util.Scanner;

public class StrongNumberCheck {

    //Calculate factorial of a digit
    static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }

    // Parameterized method to check the number is strong
    static void checkStrongNumber(int num) {
        int original = num;
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += factorial(digit);
            num /= 10;
        }

        // Conditional operator to print result
        String result = (sum == original) ? "Strong Number" : "Not a Strong Number";
        System.out.println(original + " is " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = sc.nextInt();
        checkStrongNumber(input);
        sc.close();    
        }
}
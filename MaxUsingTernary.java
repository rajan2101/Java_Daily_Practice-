package Lab2;

import java.util.Scanner;

public class MaxUsingTernary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter first number (num1): ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number (num2): ");
        int num2 = scanner.nextInt();

        // Find maximum using ternary operator
        int max = (num1 > num2) ? num1 : num2;

        // Output the result
        System.out.println("Maximum number is: " + max);
    
        scanner.close();
        }
}
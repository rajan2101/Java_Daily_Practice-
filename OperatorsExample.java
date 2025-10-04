import java.util.Scanner;

public class OperatorsExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking integer input
        System.out.print("Enter first number (a): ");
        int a = sc.nextInt();

        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();

        // Taking boolean input
        System.out.print("Enter first boolean value (true/false): ");
        boolean x = sc.nextBoolean();

        System.out.print("Enter second boolean value (true/false): ");
        boolean y = sc.nextBoolean();

        int result;

        // 1) Arithmetic Operators
        System.out.println("\n=== Arithmetic Operators ===");
        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));

        // 2) Comparison Operators
        System.out.println("\n=== Comparison Operators ===");
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));

        // 3) Bitwise Operators
        System.out.println("\n=== Bitwise Operators ===");
        System.out.println("a & b : " + (a & b));   // Bitwise AND
        System.out.println("a | b : " + (a | b));   // Bitwise OR
        System.out.println("a ^ b : " + (a ^ b));   // Bitwise XOR
        System.out.println("~a    : " + (~a));      // Bitwise NOT
        System.out.println("a << 1 : " + (a << 1)); // Left shift
        System.out.println("a >> 1 : " + (a >> 1)); // Right shift

        // 4) Logical Operators
        System.out.println("\n=== Logical Operators ===");
        System.out.println("x && y : " + (x && y)); // Logical AND
        System.out.println("x || y : " + (x || y)); // Logical OR
        System.out.println("!x     : " + (!x));     // Logical NOT

        // 5) Assignment Operators
        System.out.println("\n=== Assignment Operators ===");
        result = a;
        result += b;
        System.out.println("result += b : " + result);
        result -= b;
        System.out.println("result -= b : " + result);
        result *= b;
        System.out.println("result *= b : " + result);
        result /= b;
        System.out.println("result /= b : " + result);
        result %= b;
        System.out.println("result %= b : " + result);

        // 6) Ternary Operator
        System.out.println("\n=== Ternary Operator ===");
        int max = (a > b) ? a : b;
        System.out.println("Maximum value is: " + max);

        sc.close();
    }
}
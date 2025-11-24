package Lab2;
import java.util.Scanner;
public class NthBitChecker 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input the number
        System.out.print("Enter a number (num): ");
        int num = scanner.nextInt();

        // Step 2: Input the bit position
        System.out.print("Enter the bit position (n): ");
        int n = scanner.nextInt();

        // Step 3: Get the nth bit using right shift and bitwise AND
        int bitStatus = (num >> n) & 1;

        // Step 4: Output the result
        System.out.println("The " + n + "th bit of number " + num + " is: " + bitStatus);
        scanner.close();
    }
}

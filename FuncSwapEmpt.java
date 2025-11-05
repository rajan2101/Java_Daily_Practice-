import java.util.Scanner;

public class FuncSwapEmpt {

    public static void main(String[] args) {
        swap();
    }

    public static void swap() {
        int num1, num2, temp;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the 2 numbers:");
        num1 = sc.nextInt();
        num2 = sc.nextInt();

        // Swapping using a temporary variable
        temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("The swapped numbers are: " + num1 + " and " + num2);
        sc.close();
    }
}
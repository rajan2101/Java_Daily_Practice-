import java.util.Scanner;

public class TableGenerator{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Table Number :");
        int num = sc.nextInt();

        int total = 0;

        System.out.println("\n--- Multiplication Table in Descending Order ---");
        for (int i = 10; i >= 1; i--) {
            total = num * i;
            System.out.println(num + " x " + i + " = " + total);
        }

        sc.close();
    }
}

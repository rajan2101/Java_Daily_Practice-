import java.util.Scanner;

public class Radius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept radius
        System.out.print("Enter radius of the circle: ");
        int r = sc.nextInt();

        // Calculate area and perimeter using 3.14
        double area = 3.14 * r * r;
        double perimeter = 2 * 3.14 * r;

        // Display results
        System.out.println(r);
        System.out.println(area);
        System.out.println(perimeter);

        sc.close();
    }
}

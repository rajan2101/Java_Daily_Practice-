import java.util.Scanner;
public class Area_user {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius of circle: ");
        double radius = sc.nextDouble();
        Abs1 c = new Circle(radius);
        c.area();

        System.out.print("Enter side of square: ");
        double side = sc.nextDouble();
        Abs1 s = new Square(side);
        s.area();

        System.out.print("Enter base of triangle: ");
        double base = sc.nextDouble();
        System.out.print("Enter height of triangle: ");
        double height = sc.nextDouble();
        Abs1 t = new Triangle(base, height);
        t.area();

       sc.close();
    }
}
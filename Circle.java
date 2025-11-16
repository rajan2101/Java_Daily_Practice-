
public class Circle implements Abs1 {
	double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public void area() {
        System.out.println("Area of Circle: " + (Math.PI * radius * radius));
    }
}

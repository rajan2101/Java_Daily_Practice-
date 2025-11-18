
public class Triangle implements Abs1{
	double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void area() {
        System.out.println("Area of Triangle: " + (0.5 * base * height));
    }
}

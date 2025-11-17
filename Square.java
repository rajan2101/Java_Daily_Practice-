
public class Square implements Abs1{
	double side;

    Square(double side) {
        this.side = side;
    }

    public void area() {
        System.out.println("Area of Square: " + (side * side));
    }
}

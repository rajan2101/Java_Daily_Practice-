package Lab5;

public class RestaurantDemo {

	public static void main(String[] args) 
	{
		 Restaurant restaurant = new Restaurant();

	        Thread customer = new Thread(() -> restaurant.receivedOrder(), "Customer");
	        Thread waiter = new Thread(() -> restaurant.foodOrder("Chicken biryani"), "Waiter");
	        Thread cook = new Thread(() -> restaurant.cookedOrder(), "Cook");

	        customer.start();
	        cook.start();
	        waiter.start();
	    }
}

package Lab5;

public class ThreadSequenceDemo {

	public static void main(String[] args) 
	{
	
		int[] arr = {1, 20, 50, 15, 30};

        Runnable squaresTask = () -> {
            System.out.println("Squares of numbers in the array:");
            for (int n : arr) {
                int sq = n * n;
                System.out.println("Square of " + n + ": " + sq);
            }
        };

        Runnable averageTask = () -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            double avg = sum / 10.0;
            System.out.println("The average of the first 10 numbers is: " + avg);
        };

        Thread t1 = new Thread(squaresTask, "SquaresThread");
        Thread t2 = new Thread(averageTask, "AverageThread");

        t1.start();
        try {
            t1.join(); // Wait for squares to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        t2.start();
        try {
            t2.join(); // Wait for average to finish
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

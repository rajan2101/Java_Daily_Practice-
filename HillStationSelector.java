package Lab3;
import java.util.Scanner;
public class HillStationSelector 
{
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Hill Station Info ---");
        System.out.println("Choose a hill station:");
        System.out.println("1. Manali");
        System.out.println("2. Mussoorie");
        System.out.println("3. Gulmarg");
        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        HillStations hill;

        switch (choice) {
            case 1:
                hill = new Manali();
                break;    
            case 2:
                hill = new Mussoorie();
                break;
            case 3:
                hill = new Gulmarg();
                break;
            default:
                System.out.println("Invalid choice. Showing generic hill station info.");
                hill = new HillStations();
        }

        // Call overridden methods
        hill.location();
        hill.famousFor();

        scanner.close();
    }



}

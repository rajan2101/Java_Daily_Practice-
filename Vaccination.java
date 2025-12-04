package Lab3;
import java.util.Scanner;
public class Vaccination {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter your age: ");
	        int age = scanner.nextInt();
	        scanner.nextLine(); // consume newline

	        System.out.print("Enter your nationality: ");
	        String nationality = scanner.nextLine();

	        VaccinationSuccessful user = new VaccinationSuccessful(age, nationality);

	        user.firstDose();
	        user.secondDose();
	        user.boosterDose();

	        scanner.close();
	    }


	}

package Lab4;
import java.util.Scanner;
public class CalculatorSimulator 
{
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaxCalculator calculator = new TaxCalculator();

        try {
            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Is the employee Indian? (true/false): ");
            boolean isIndian = sc.nextBoolean();

            System.out.print("Enter employee salary: ");
            double salary = sc.nextDouble();

            double tax = calculator.calculateTax(name, isIndian, salary);
            System.out.println("Tax amount is: " + tax);

        } catch (CountryNotValidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (EmployeeNameInvalidException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (TaxNotEligibleException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }


}

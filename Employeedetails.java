import java.util.Scanner;

public class Employeedetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept employee details
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume leftover newline

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        // Display details
        System.out.println("\nEmployee Details");
        System.out.println(name);
        System.out.println(id);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(address);
        System.out.println(phone);
        System.out.println(department);
        System.out.println(salary);

        sc.close();
    }
}


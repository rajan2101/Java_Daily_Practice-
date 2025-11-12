import java.util.Scanner;

// Base class (Parent)
class User {
    int id;
    String name;

    // Parameterized constructor
    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// Derived class (Child)
class Employee extends User {
    double salary; // Monthly salary

    // Parameterized constructor 
    Employee(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
    }

    // Method to calculate annual salary
    double calculateAnnualSalary() {
        return salary * 12;
    }
}

// Main class
public class calculateAnnualSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Monthly Salary: ");
        double salary = sc.nextDouble();

        // Create Employee object
        Employee emp = new Employee(id, name, salary);

        // Calculate annual salary
        double annualSalary = emp.calculateAnnualSalary();

        // Display results
        System.out.println("\n--- Employee Details ---");
        System.out.println("ID: " + emp.id);
        System.out.println("Name: " + emp.name);
        System.out.println("Monthly Salary: " + emp.salary);
        System.out.println("Annual Salary: " + annualSalary);

        sc.close();
    }
}

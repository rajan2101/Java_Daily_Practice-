import java.util.Scanner;

public class LeapYearCheck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        // Leap year logic using if-else
        if ((year % 4 == 0 )) {
            System.out.println(year + " is a Leap Year");
        } else {
            System.out.println(year + " is Not a Leap Year");
        }
        sc.close();
    }
}
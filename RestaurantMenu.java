import java.util.Scanner;

public class RestaurantMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String addItem;
        int totalBill = 0;

        do {
            System.out.println("Welcome to our Foody Zone");
            System.out.println("Enter Your Choice");
            System.out.println("1. Starter");
            System.out.println("2. Main Course");
            System.out.println("3. Dessert");
            System.out.println("4. Drinks");

            int choice = sc.nextInt();
            int price = 0;
            int dishChoice;

            switch (choice) {
                case 1: 
                    System.out.println("Starter");
                    System.out.println("1. Soup ₹ 49");
                    System.out.println("2. Momos ₹ 99");
                    System.out.println("3. Paneer Momos ₹ 149");
                    System.out.print("Select dish number: ");
                    dishChoice = sc.nextInt();

                    if (dishChoice == 1) price = 49;
                    else if (dishChoice == 2) price = 99;
                    else if (dishChoice == 3) price = 149;
                    else System.out.println("Invalid dish choice!");
                    break;
                    
                case 2:
                    System.out.println("Main Course");
                    System.out.println("1. Fried Rice ₹ 149");
                    System.out.println("2. Noodles ₹ 199");
                    System.out.println("3. Triple Combo ₹ 249");
                    System.out.print("Select dish number: ");
                    dishChoice = sc.nextInt();

                    if (dishChoice == 1) price = 149;
                    else if (dishChoice == 2) price = 199;
                    else if (dishChoice == 3) price = 249;
                    else System.out.println("Invalid dish choice!");
                    break;

                case 3:
                    System.out.println("Dessert");
                    System.out.println("1. Pastry ₹ 99");
                    System.out.println("2. Ice Cream ₹ 49");
                    System.out.println("3. Pudding ₹ 129");
                    System.out.print("Select dish number: ");
                    dishChoice = sc.nextInt();

                    if (dishChoice == 1) price = 99;
                    else if (dishChoice == 2) price = 49;
                    else if (dishChoice == 3) price = 129;
                    else System.out.println("Invalid dish choice!");
                    break;

                case 4:
                    System.out.println("Drinks");
                    System.out.println("1. Mojito ₹ 149");
                    System.out.println("2. Soda ₹ 49");
                    System.out.println("3. Nimbu Soda ₹ 99");
                    System.out.print("Select dish number: ");
                    dishChoice = sc.nextInt();

                    if (dishChoice == 1) price = 149;
                    else if (dishChoice == 2) price = 49;
                    else if (dishChoice == 3) price = 99;
                    else System.out.println("Invalid dish choice!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

            // Add the selected dish price to the total bill if a valid choice was made
            if (price > 0) {
                totalBill += price;
                System.out.println("Item added to the bill. Total so far: ₹" + totalBill);
            }

            // Ask if the user wants to add another item
            System.out.print("Do you want to add another item? (y/n): ");
            addItem = sc.next();

        } while (addItem.equalsIgnoreCase("y"));

        System.out.println("Thank you for your order! Total bill: ₹" + totalBill);
        System.out.println("Visit Again");
        sc.close();
    }
}

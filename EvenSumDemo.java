package Lab6;

//Import necessary classes
import java.util.ArrayList;

public class EvenSumDemo {
 public static void main(String[] args) {
     
     // Step 1: Create an ArrayList to store integers
     ArrayList<Integer> numbers = new ArrayList<>();
     
     // Step 2: Add sample integers to the list
     numbers.add(2);
     numbers.add(5);
     numbers.add(8);
     numbers.add(10);
     numbers.add(15);
     
     // Step 3: Initialize a variable to hold the sum of even numbers
     int sum = 0;
     
     // Step 4: Loop through each number in the list
     for (int num : numbers) {
         // Step 5: Check if the number is even
         if (num % 2 == 0) {
             // Step 6: Add even number to the sum
             sum += num;
         }
     }
     
     // Step 7: Display the result
     System.out.println("Sum of even numbers: " + sum);
 }
}
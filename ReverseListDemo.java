package Lab6;
//Import necessary classes
import java.util.ArrayList;
import java.util.Collections;

public class ReverseListDemo {
 public static void main(String[] args) {
     
     // Step 1: Create an ArrayList to store strings
     ArrayList<String> fruits = new ArrayList<>();
     
     // Step 2: Add elements to the list
     fruits.add("apple");
     fruits.add("banana");
     fruits.add("cherry");
     fruits.add("date");
     
     // Step 3: Display the original list
     System.out.println("Original list: " + fruits);
     
     // Step 4: Reverse the list using Collections utility
     Collections.reverse(fruits);
     
     // Step 5: Display the reversed list
     System.out.println("Reversed list: " + fruits);
 }
}
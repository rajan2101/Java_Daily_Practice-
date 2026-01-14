package Lab7;

//Import the HashSet class from java.util package
import java.util.HashSet;

public class HashSetAppendDemo {
 public static void main(String[] args) {
     
     // Step 1: Create a HashSet to store strings
     HashSet<String> fruits = new HashSet<>();
     
     // Step 2: Add initial elements to the HashSet
     fruits.add("apple");
     fruits.add("banana");
     fruits.add("cherry");
     
     // Step 3: Append a new element to the HashSet
     fruits.add("date"); // This adds "date" to the set
     
     // Step 4: Display the updated HashSet
     System.out.println("Updated HashSet: " + fruits);
 }
}

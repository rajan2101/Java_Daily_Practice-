package Lab7;

//Import necessary classes
import java.util.HashSet;
import java.util.Set;

public class SetUnionSubsetDemo {
 public static void main(String[] args) {
     
     // Step 1: Create first set and add elements
     Set<String> set1 = new HashSet<>();
     set1.add("apple");
     set1.add("banana");
     set1.add("cherry");
     
     // Step 2: Create second set and add elements
     Set<String> set2 = new HashSet<>();
     set2.add("cherry");
     set2.add("date");
     set2.add("fig");
     
     // Step 3: Create unionSet and add all elements from both sets
     Set<String> unionSet = new HashSet<>();
     unionSet.addAll(set1); // add elements from set1
     unionSet.addAll(set2); // add elements from set2
     
     // Step 4: Display the union of sets
     System.out.println("Union of sets: " + unionSet);
     
     // Step 5: Check if unionSet is a subset of set1
     if (set1.containsAll(unionSet)) {
         System.out.println("unionSet is a subset of set1.");
     } else {
         System.out.println("unionSet is not a subset of set1.");
     }
 }
}

package Lab7;

//Import the Stack class from java.util package
import java.util.Stack;

public class StackDemo {
 public static void main(String[] args) {
     
     // Step 1: Declare a Stack of Integer type
     Stack<Integer> stack = new Stack<>();
     
     // Step 2: Push 10 elements into the stack
     stack.push(23);
     stack.push(33);
     stack.push(43);
     stack.push(53);
     stack.push(33);
     stack.push(63);
     stack.push(73);
     stack.push(83);
     stack.push(93);
     stack.push(13);
     
     // Step 3: Display the stack before removal
     System.out.println("--elements--");
     System.out.println(stack);
     
     // Step 4: Remove (pop) 4 elements from the top of the stack
     stack.pop(); // removes 13
     stack.pop(); // removes 93
     stack.pop(); // removes 83
     stack.pop(); // removes 73
     
     // Step 5: Display the stack after removal
     System.out.println("After remove");
     System.out.println(stack);
 }
}

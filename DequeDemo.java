import java.util.Deque;
import java.util.ArrayDeque;

public class DequeDemo {
    public static void main(String[] args) {
        // Create a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();

        // Adding elements at both ends
        deque.addFirst("Front1");   // Inserts element at the front (throws exception if full)
        deque.addLast("Rear1");     // Inserts element at the rear (throws exception if full)
        deque.offerFirst("Front2"); // Inserts element at the front (returns false if full, no exception)
        deque.offerLast("Rear2");   // Inserts element at the rear (returns false if full, no exception)

        System.out.println("Deque after additions: " + deque);

        // Accessing elements without removal
        System.out.println("First element (getFirst): " + deque.getFirst());   // Gets first element (throws exception if empty)
        System.out.println("Last element (getLast): " + deque.getLast());      // Gets last element (throws exception if empty)
        System.out.println("Peek First: " + deque.peekFirst());                // Gets first element (returns null if empty)
        System.out.println("Peek Last: " + deque.peekLast());                  // Gets last element (returns null if empty)

        // Removing elements
        System.out.println("Removed First (removeFirst): " + deque.removeFirst()); // Removes first element (throws exception if empty)
        System.out.println("Removed Last (removeLast): " + deque.removeLast());    // Removes last element (throws exception if empty)
        System.out.println("Poll First: " + deque.pollFirst());                    // Removes first element (returns null if empty)
        System.out.println("Poll Last: " + deque.pollLast());                      // Removes last element (returns null if empty)

        // Final state
        System.out.println("Deque after removals: " + deque); // Shows remaining elements
    }
}

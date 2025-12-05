import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Queue behavior (FIFO)
        deque.offer(10);
        deque.offer(20);
        deque.offer(30);
        System.out.println("Queue: " + deque); 
        System.out.println("Removed: " + deque.poll());

        // Stack behavior (LIFO)
        deque.push(40);
        deque.push(50);
        System.out.println("Stack: " + deque); 
        System.out.println("Popped: " + deque.pop()); 
    }
}
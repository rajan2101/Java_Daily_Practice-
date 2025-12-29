package Lab5;

class Restaurant {
    private String order;
    private boolean ordered = false;
    private boolean cooked = false;

    public synchronized void foodOrder(String orderName) {
        System.out.println("Thread waiter: customer has ordered " + orderName);
        order = orderName;
        ordered = true;
        notifyAll(); // Wake up cook
        try {
            while (!cooked) {
                wait(); // Wait until cooking is done
            }
            System.out.println("Thread waiter: food is delivered to customer!!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void cookedOrder() {
        try {
            while (!ordered) {
                wait(); // Wait for waiter to place order
            }
            System.out.println("Thread cook: chef has received the order " + order);
            System.out.println("Thread cook: cooking under progress.....");
            Thread.sleep(2000); // Simulate cooking
            System.out.println("Thread cook: Order is ready!!");
            cooked = true;
            notifyAll(); // Wake up customer
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public synchronized void receivedOrder() {
        System.out.println("Thread customer: customer is choosing an order ....");
        try {
            while (!cooked) {
                wait(); // Wait for food to be cooked
            }
            System.out.println("Thread customer: customer has received the order: " + order);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

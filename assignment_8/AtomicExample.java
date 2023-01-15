package assignment_8;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) {
        // Increment the counter and get the new value
        int newValue = counter.incrementAndGet();
        System.out.println("Counter value incremented to: " + newValue);

        // Decrement the counter and get the new value
        newValue = counter.decrementAndGet();
        System.out.println("Counter value decremented to: " + newValue);

        // Get the current value of the counter
        int currentValue = counter.get();
        System.out.println("Current counter value: " + currentValue);

        // Compare the current value to a reference value, and set the value to a new
        // value if they are equal
        boolean success = counter.compareAndSet(0, 5);
        if (success) {
            System.out.println("Counter value updated from 0 to 5");
        } else {
            System.out.println("Counter value not updated");
        }
    }
}
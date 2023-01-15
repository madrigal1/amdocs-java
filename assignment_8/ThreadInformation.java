package assignment_8;

public class ThreadInformation {
    public static void main(String[] args) {
        // Create a thread using the Thread class
        Thread thread1 = new Thread() {
            public void run() {
                System.out.println("Thread 1: Running");
            }
        };
        thread1.setName("Thread 1");
        thread1.start();

        // Create a thread using the Runnable interface
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Thread 2: Running");
            }
        };
        Thread thread2 = new Thread(runnable);
        thread2.setName("Thread 2");
        thread2.start();

        // Display the details of the threads
        System.out.println("Thread 1: Name = " + thread1.getName() + ", ID = " + thread1.threadId() + ", Priority = "
                + thread1.getPriority() + ", Phase = " + thread1.getState());
        System.out.println("Thread 2: Name = " + thread2.getName() + ", ID = " + thread2.threadId() + ", Priority = "
                + thread2.getPriority() + ", Phase = " + thread2.getState());
    }
}

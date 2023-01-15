package assignment_8;

public class ThreeThreads {
    public static void main(String[] args) {
        // Create a new thread for displaying numbers from 101 to 200
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 101; i <= 200; i++) {
                    System.out.println(i);
                }
            }
        });

        // Create a new thread for displaying numbers from 201 to 300
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 201; i <= 300; i++) {
                    System.out.println(i);
                }
            }
        });

        // Create a new thread for displaying numbers from 301 to 400
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 301; i <= 400; i++) {
                    System.out.println(i);
                }
            }
        });

        // Start all the threads
        t1.start();
        t2.start();
        t3.start();
    }
}

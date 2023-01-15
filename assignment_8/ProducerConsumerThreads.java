package assignment_8;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerThreads {
    private static class Producer implements Runnable {
        private Queue<Integer> queue;
        private int maxSize;

        public Producer(Queue<Integer> queue, int maxSize) {
            this.queue = queue;
            this.maxSize = maxSize;
        }

        @Override
        public void run() {
            int value = 0;
            while (true) {
                synchronized (queue) {
                    while (queue.size() == maxSize) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Produced: " + value);
                    queue.add(value++);
                    queue.notifyAll();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        private Queue<Integer> queue;

        public Consumer(Queue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int value = queue.poll();
                    System.out.println("Consumed " + value);
                    queue.notifyAll();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 5;

        Thread producer = new Thread(new Producer(queue, maxSize));
        Thread consumer = new Thread(new Consumer(queue));

        producer.start();
        consumer.start();
    }
}
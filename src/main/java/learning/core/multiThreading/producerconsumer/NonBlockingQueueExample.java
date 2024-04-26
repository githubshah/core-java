package learning.core.multiThreading.producerconsumer;

import java.util.concurrent.ConcurrentLinkedQueue;

class Producer implements Runnable {
    private final ConcurrentLinkedQueue<Integer> queue;

    public Producer(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000); // Simulate some work
                queue.add(i); // Add element to the queue
                System.out.println("Produced: " + i);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final ConcurrentLinkedQueue<Integer> queue;

    public Consumer(ConcurrentLinkedQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(2000); // Simulate some work
                Integer value = queue.poll(); // Remove and retrieve element from the queue
                if (value != null) {
                    System.out.println("Consumed: " + value);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class NonBlockingQueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}

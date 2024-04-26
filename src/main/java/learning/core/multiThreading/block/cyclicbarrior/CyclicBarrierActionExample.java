package learning.core.multiThreading.block.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierActionExample {
    private static final int NUM_THREADS = 3;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, () -> {
            System.out.println("Barrier reached! All threads have arrived.");
            // Perform some action once all threads reach the barrier
            System.out.println("Performing action...");
        });

        // Start threads
        for (int i = 0; i < NUM_THREADS; i++) {
            new Thread(new Worker(barrier)).start();
        }
    }

    static class Worker implements Runnable {
        private final CyclicBarrier barrier;

        Worker(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                // Simulate some work
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " has arrived at the barrier.");

                // Wait for other threads to arrive at the barrier
                barrier.await();

                // All threads have reached the barrier, continue with next steps
                System.out.println(Thread.currentThread().getName() + " continues execution after the barrier.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
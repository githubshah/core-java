package learning.core.multiThreading.block.countdownLatch;

import java.util.concurrent.CountDownLatch;

class Worker extends Thread {
    private final CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println("Worker is working...");
            Thread.sleep(2000); // Simulating some work
            System.out.println("Worker has finished working.");
            latch.countDown(); // Decrements the latch count
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numWorkers);

        for (int i = 0; i < numWorkers; i++) {
            Worker worker = new Worker(latch);
            worker.start();
        }

        // Main thread waits until all workers have finished their work
        latch.await();
        System.out.println("All workers have finished their work. Main thread continues.");
    }
}

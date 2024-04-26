package learning.core.multiThreading.block.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Worker extends Thread {
    private final CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting at the barrier.");
            barrier.await(); // Wait at the barrier
            System.out.println(Thread.currentThread().getName() + " has passed the barrier and resumed execution.");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

public class CyclicBarrierReuseExample {
    public static void main(String[] args) {
        int numWorkers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numWorkers);

        for (int i = 0; i < 5; i++) {
            System.out.println("Cycle " + (i + 1));
            for (int j = 0; j < numWorkers; j++) {
                Worker worker = new Worker(barrier);
                worker.start();
            }
        }
    }
}

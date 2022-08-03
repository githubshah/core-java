package learning.core.multiThreading.block.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import static java.lang.Thread.sleep;

public class CyclicBarrierDemo {
    private static final int PARTIES = 3;
    private static final int ITERATIONS = 3;

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier entryBarrier = new CyclicBarrier(PARTIES + 1, () -> System.out.println("2-iteration started"));
        CyclicBarrier exitBarrier = new CyclicBarrier(PARTIES + 1, () -> System.out.println("4-iteration finished"));
        for (int i = 0; i < ITERATIONS; i++) {
            for (int p = 0; p < PARTIES; p++) {
                int delay = p + 1;
                Runnable task = new Worker(delay, entryBarrier, exitBarrier);
                new Thread(task).start();
            }
            System.out.println(String.format("1-all threads waiting to start: iteration {}", i));
            sleep(1);
            entryBarrier.await();
            System.out.println(String.format("3-all threads started: iteration {}", i));
            exitBarrier.await();
            System.out.println(String.format("5-all threads finished: iteration {}", i));
        }
    }

    private static class Worker implements Runnable {
        private final int delay;
        private final CyclicBarrier entryBarrier;
        private final CyclicBarrier exitBarrier;

        Worker(int delay, CyclicBarrier entryBarrier, CyclicBarrier exitBarrier) {
            this.delay = delay;
            this.entryBarrier = entryBarrier;
            this.exitBarrier = exitBarrier;
        }

        @Override
        public void run() {
            try {
                entryBarrier.await();
                work();
                exitBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        }

        private void work() throws InterruptedException {
            System.out.println("work " + delay + " started");
            sleep(delay);
            System.out.println("work " + delay + " finished");
        }
    }
}

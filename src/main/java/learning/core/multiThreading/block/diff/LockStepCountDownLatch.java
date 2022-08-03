package learning.core.multiThreading.block.diff;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class LockStepCountDownLatch {

    protected static final int TASKS_PER_BATCH = 3;
    protected static final int BATCHES = 5;

    public static void main(String... args) {
        LockStepCountDownLatch lse = new LockStepCountDownLatch();
        ExecutorService pool = newFixedThreadPool(TASKS_PER_BATCH);
        for (int batch = 0; batch < BATCHES; batch++) {
            // We need a new CountDownLatch per batch, since they
            // cannot be reset to their initial value
            CountDownLatch latch = new CountDownLatch(TASKS_PER_BATCH);
            for (int i = 0; i < TASKS_PER_BATCH; i++) {
                int phase = batch + 1;
                pool.submit(() -> lse.task(latch, phase));
            }
        }
        pool.shutdown();
    }

    public void task(CountDownLatch latch, int phase) {
        latch.countDown();
        boolean interrupted = Thread.interrupted();
        while (true) {
            try {
                latch.await();
                break;
            } catch (InterruptedException e) {
                interrupted = true;
            }
        }
        if (interrupted) Thread.currentThread().interrupt();
        doTask(phase);
    }

    protected final void doTask(int phase) {
        System.out.printf("Task: %s start phase %d%n", Thread.currentThread().getName(), phase);
        int ms = ThreadLocalRandom.current().nextInt(500, 3000);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Task: %s in phase %d took %dms%n", Thread.currentThread().getName(), phase, ms);
    }
}
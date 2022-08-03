package learning.core.multiThreading.block.diff;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class LockStepPhaser {

    protected static final int TASKS_PER_BATCH = 3;
    protected static final int BATCHES = 5;

    public static void main(String... args) {
        LockStepPhaser lse = new LockStepPhaser();
        ExecutorService pool = newFixedThreadPool(TASKS_PER_BATCH);
        Phaser latch = new Phaser(TASKS_PER_BATCH);
        for (int batch = 0; batch < BATCHES; batch++) {
            // We need a new CountDownLatch per batch, since they
            // cannot be reset to their initial value
            for (int i = 0; i < TASKS_PER_BATCH; i++) {
                pool.submit(() -> lse.task(latch));
            }
        }
        pool.shutdown();
    }

    public void task(Phaser latch) {
        boolean interrupted = Thread.interrupted();
        while (true) {
            latch.arriveAndAwaitAdvance();
            break;
        }
        if (interrupted) Thread.currentThread().interrupt();
        doTask(latch);
    }

    protected final void doTask(Phaser phase) {
        System.out.printf("Task: %s start phase %d%n", Thread.currentThread().getName(), phase.getPhase());
        int ms = ThreadLocalRandom.current().nextInt(500, 3000);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.printf("Task: %s in phase %d took %dms%n", Thread.currentThread().getName(), phase.getPhase(), ms);
    }
}
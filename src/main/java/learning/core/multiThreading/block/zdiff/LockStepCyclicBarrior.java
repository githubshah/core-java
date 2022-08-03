package learning.core.multiThreading.block.zdiff;

import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class LockStepCyclicBarrior {

    protected static final int TASKS_PER_BATCH = 3;
    protected static final int BATCHES = 5;

    public static void main(String... args) {
        LockStepCyclicBarrior lse = new LockStepCyclicBarrior();
        ExecutorService pool = newFixedThreadPool(TASKS_PER_BATCH);

        CyclicBarrier latch = new CyclicBarrier(TASKS_PER_BATCH); // auto reset once cyclic barrier set to 0

        for (int batch = 0; batch < BATCHES; batch++) {
            for (int i = 0; i < TASKS_PER_BATCH; i++) {
                int phase = batch + 1;
                pool.submit(() -> lse.task(latch, phase));
            }
        }
        pool.shutdown();
    }

    public void task(CyclicBarrier latch, int phase) {
        //latch.countDown();
        boolean interrupted = Thread.interrupted();
        while (true) {
            try {
                latch.await();
                break;
            } catch (InterruptedException | BrokenBarrierException e) {
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
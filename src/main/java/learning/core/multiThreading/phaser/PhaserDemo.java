package learning.core.multiThreading.phaser;

import java.util.concurrent.Phaser;

import static java.lang.Thread.sleep;

public class PhaserDemo {
    private static final int PARTIES = 3;
    private static final int ITERATIONS = 3;

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1) {
            final private int maxPhase = ITERATIONS;

            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return (phase >= maxPhase - 1) || (registeredParties == 0);
            }
        };
        System.out.printf("after constructor ", phaser);
        for (int p = 0; p < PARTIES; p++) {
            int delay = p + 1;
            Runnable task = new Worker(delay, phaser);
            new Thread(task).start();
        }
        System.out.printf("all threads waiting to start ", phaser);
        sleep(1);
        System.out.printf("before all threads started ", phaser);
        phaser.arriveAndDeregister();
        System.out.printf("after all threads started ", phaser);
        phaser.register();
        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }
        System.out.printf("all threads finished ", phaser);
    }

    private static class Worker implements Runnable {
        private final int delay;
        private final Phaser phaser;

        Worker(int delay, Phaser phaser) {
            phaser.register();
            this.delay = delay;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            do {
                work();
                phaser.arriveAndAwaitAdvance();
            } while (!phaser.isTerminated());
        }

        void work() {
            System.out.printf("work %d started%n", delay);
            try {
                sleep(delay);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("work %d finished%n", delay);
        }
    }
}

package learning.core.multiThreading.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1);

        System.out.printf("after constructor \n", phaser);
        for (int p = 0; p < 5; p++) {
            int delay = p + 1;
            Runnable task = new Worker(delay, phaser);
            new Thread(task).start();
        }

        System.out.printf("%s thread going to wait for other threads...%s\n", Thread.currentThread().getName(), phaser);
        phaser.arriveAndAwaitAdvance();
        System.out.printf("....................phaser arrived...... %s \n", phaser);
        System.out.printf("all threads finished %s \n", phaser);
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
            work();
            System.out.printf("..and %s going to wait for other threads...%s\n", Thread.currentThread().getName(), phaser);
            phaser.arriveAndAwaitAdvance();
            System.out.printf("%s release lock...%s\n", Thread.currentThread().getName(), phaser);


        }

        void work() {
            System.out.printf("%s doing some work", Thread.currentThread().getName(), delay);
        }
    }
}

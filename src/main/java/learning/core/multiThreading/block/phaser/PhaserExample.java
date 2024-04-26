package learning.core.multiThreading.block.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // We start with 3 parties (threads)

        // Start threads
        new Thread(new Worker(phaser, "Thread 1")).start();
        new Thread(new Worker(phaser, "Thread 2")).start();
        new Thread(new Worker(phaser, "Thread 3")).start();
    }

    static class Worker implements Runnable {
        private final Phaser phaser;
        private final String name;

        Worker(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
        }

        @Override
        public void run() {
            // Phase 1: Initialization
            System.out.println(name + " is performing initialization...");
            phaser.arriveAndAwaitAdvance(); // Wait for all parties to reach this point

            // Phase 2: Execution of task
            System.out.println(name + " is executing task...");
            // Simulate some work
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " has completed task.");
            phaser.arriveAndAwaitAdvance(); // Wait for all parties to reach this point

            // Phase 3: Cleanup
            System.out.println(name + " is performing cleanup...");
            // Simulate some cleanup work
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " has completed cleanup.");
            phaser.arriveAndDeregister(); // Deregister from the phaser
        }
    }
}

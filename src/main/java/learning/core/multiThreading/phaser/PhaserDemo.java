package learning.core.multiThreading.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        new Thread(new Task("thread-9", phaser)).start();
        new Thread(new Task("thread-10", phaser)).start();

        phaser.arriveAndAwaitAdvance();
        System.out.println("phase " + phaser.getPhase() + " completed");
        phaser.arriveAndAwaitAdvance();
        System.out.println("phase " + phaser.getPhase() + " completed");
        phaser.arriveAndAwaitAdvance();
        System.out.println("phase " + phaser.getPhase() + " completed");
    }
}

class Task implements Runnable {

    Phaser phaser;
    String name;

    public Task(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println(name + " hello");
        this.phaser.arriveAndAwaitAdvance();

        System.out.println(name + " hello again");
        this.phaser.arriveAndAwaitAdvance();

        System.out.println(name + " hello yupp");
        this.phaser.arriveAndAwaitAdvance();
    }
}

package core.multiThreading.increment.solution.byLock;

import java.util.concurrent.locks.ReentrantLock;

class Resource {
    int count = 0;

    public int getValue() {
        return count;
    }

    public void increment() {  // must be sync
        this.count++;
    }

    public void decrement() {  // must be sync
        this.count--;
    }
}

class ThreadTest implements Runnable {
    private final Resource count;
    private ReentrantLock locker;

    public ThreadTest(Resource count, ReentrantLock locker) {
        this.count = count;
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock();
        delay(200);
        count.increment();
        delay(300);
        count.decrement();
        locker.unlock();
    }

    private void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class IncrementCount {
    public static void main(String[] args) {
        Resource resource = new Resource();
        ReentrantLock rel = new ReentrantLock();
        for (int i = 1; i <= 1000; i++) {
            new Thread(new ThreadTest(resource, rel)).start();
        }

        // need to wait till to complete all threads
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("resource count: " + resource.getValue());
    }
}

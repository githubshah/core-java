package learning.core.multiThreading.control.solution.byLock;

import java.util.concurrent.locks.ReentrantLock;

class Resource {
    int count = 0;

    ReentrantLock reentrantLock = new ReentrantLock();

    public int getValue() {
        return count;
    }

    public void increment() {  // must be sync
        reentrantLock.lock();
        this.count++;
        reentrantLock.unlock();
    }

    public void decrement() {  // must be sync
        reentrantLock.lock();
        this.count--;
        reentrantLock.unlock();
    }
}

class ThreadTest implements Runnable {
    private final Resource count;

    public ThreadTest(Resource count) {
        this.count = count;
    }

    @Override
    public void run() {
        delay(100);
        count.increment();
        delay(200);
        count.decrement();
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
        for (int i = 1; i <= 1000; i++) {
            new Thread(new ThreadTest(resource)).start();
        }

        // need to wait till to complete all threads
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("resource count: " + resource.getValue());
    }
}

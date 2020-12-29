package learning.core.multiThreading.control.solution.byAtomic;

import java.util.concurrent.atomic.AtomicInteger;

class Resource {
    AtomicInteger count = new AtomicInteger(0);

    public int getValue() {
        return count.intValue();
    }

    public void increment() {  // must be sync
        this.count.incrementAndGet();
    }

    public void decrement() {  // must be sync
        this.count.decrementAndGet();
    }
}

class ThreadTest implements Runnable {
    private final Resource count;

    public ThreadTest(Resource count) {
        this.count = count;
    }

    @Override
    public void run() {
        delay(200);
        count.increment();
        delay(300);
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
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("resource count: " + resource.getValue());
    }
}
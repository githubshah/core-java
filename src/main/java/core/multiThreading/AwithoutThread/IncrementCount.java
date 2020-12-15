package core.multiThreading.AwithoutThread;

class Resource {
    int count = 0;

    public int getValue() {
        return count;
    }

    synchronized public void increment() {  // must be sync
        this.count++;
    }

    synchronized public void decrement() {  // must be sync
        this.count--;
    }
}

class ThreadTest implements Runnable {
    private final Resource count;

    public ThreadTest(Resource count) {
        this.count = count;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.increment();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.decrement();
    }
}

public class IncrementCount {
    public static void main(String[] args) {
        Resource resource = new Resource();
        for (int i = 1; i <= 10000; i++) {
            new Thread(new ThreadTest(resource)).start();
        }

        // need to wait to complete all threads
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("resource count: " + resource.getValue());
    }
}

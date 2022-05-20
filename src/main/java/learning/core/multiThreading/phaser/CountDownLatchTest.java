package learning.core.multiThreading.phaser;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        CountDownLatch countDownLatch = new CountDownLatch(9);

        IntStream.range(0, 9).boxed().forEach(integer -> {
            executorService.submit(new MyRunnable(countDownLatch));
        });

        System.out.println("waiting to complete all 9 tasks");
        countDownLatch.await();
        System.out.println("completed all 9 tasks");
    }
}

class MyRunnable implements Runnable {
    private CountDownLatch countDownLatch;

    public MyRunnable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("consuming");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("consumed");
        countDownLatch.countDown();
    }
}

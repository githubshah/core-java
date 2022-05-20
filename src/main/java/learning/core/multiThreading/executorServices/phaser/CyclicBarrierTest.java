package learning.core.multiThreading.executorServices.phaser;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CyclicBarrierTest {

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("Phase completed...");
        });

        IntStream.range(0, 9).boxed().forEach(integer -> {
            executorService.submit(new MyRunnable1(cyclicBarrier));
        });

        System.out.println("waiting to complete all 9 tasks");
        System.out.println("completed all 9 tasks");
    }
}

class MyRunnable1 implements Runnable {
    private CyclicBarrier cyclicBarrier;

    public MyRunnable1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("consuming");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("consumed and wait");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("consumed");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

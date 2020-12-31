package learning.core.multiThreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class SolutionStatement {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Semaphore semaphore = new Semaphore(2);

        IntStream.range(0, 100).boxed()
            .forEach(x -> {
                executorService.submit(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println("start slow service");
                        new SlowService().run(); // slow service
                    } catch (InterruptedException e) {
                    } finally {
                        semaphore.release();
                        System.out.println("    end slow service inside final");
                    }
                });
            });
    }
}

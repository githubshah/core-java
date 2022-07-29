package learning.core.multiThreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;


/*
        semaphore is a gateway/capacity which enable to run only permit threads.
        once lock release the other thread will pass from this gateway.
        note: Not working as cyclic barrier where cyclic barrier completed first batch and then go on.
        but here once any thread will complete then other waited therad will getting lock/execution
 */
public class SolutionStatement {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Semaphore semaphore = new Semaphore(2);

        IntStream.range(0, 100).boxed()
                .forEach(x -> executorService.submit(() -> {
                    try {
                        semaphore.acquire();
                        System.out.println("start slow service");
                        new SlowService().run(); // slow service
                    } catch (InterruptedException ignored) {
                    } finally {
                        semaphore.release();
                        System.out.println("    end slow service inside final");
                    }
                }));
    }
}

package learning.core.multiThreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

// Might be 50 thread get a chance to execute slow service simultaneously.
// but I want that 3 thread can only call slow service at a time.

// possible solution
// - via Lock [not achieve exactly what we want]
// A lock allows only one thread to enter the part that's locked
// and the lock is not shared with any other processes.

public class ProblemStatement {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);

        IntStream.range(0, 100).boxed()
                .forEach(x -> {
                    executorService.submit(() -> {
                        System.out.println("start slow service");
                        // Might be 50 thread get a chance to execute slow service simultaneously.
                        new SlowService().run();
                        System.out.println("    end slow service");
                    });
                });
    }
}

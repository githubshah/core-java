package learning.core.multiThreading.mutex;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class SequenceGeneratorSolutionByReentrantLock extends SequenceGeneratorSolutionByReentrantLockDemo {

    ReentrantLock mutex = new ReentrantLock();

    @Override
    public int getNextSequence() {
        try {
            mutex.lock();
            return super.getNextSequence();
        } finally {
            mutex.unlock();
        }
    }
}

public class SequenceGeneratorSolutionByReentrantLockDemo {

    private int currentValue = 0;

    public int getNextSequence() {
        currentValue = currentValue + 1;
        return currentValue;
    }

    public static void main(String as[]) throws InterruptedException, ExecutionException {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorSolutionByReentrantLock(), count);
        Assert.assertEquals(count, uniqueSequences.size()); // pass
    }

    private static Set<Integer> getUniqueSequences(SequenceGeneratorSolutionByReentrantLock generator, int count) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Set<Integer> uniqueSequences = new LinkedHashSet<>();
        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            futures.add(executor.submit(generator::getNextSequence));
        }

        for (Future<Integer> future : futures) {
            uniqueSequences.add(future.get());
        }

        executor.awaitTermination(1, TimeUnit.SECONDS);
        executor.shutdown();
        return uniqueSequences;
    }

}
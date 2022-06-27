package learning.core.multiThreading.mutex;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

class SequenceGeneratorUsingSynchronizedMethod extends SequenceGeneratorUsingSynchronizedMethodDemo {
    @Override
    public synchronized int getNextSequence() {
        return super.getNextSequence();
    }

}
public class SequenceGeneratorUsingSynchronizedMethodDemo {

    private int currentValue = 0;

    public int getNextSequence() {
        currentValue = currentValue + 1;
        return currentValue;
    }

    public static void main(String as[]) throws InterruptedException, ExecutionException {
        int count = 1000;
        Set<Integer> uniqueSequences = getUniqueSequences(new SequenceGeneratorUsingSynchronizedMethod(), count);
        Assert.assertEquals(count, uniqueSequences.size()); // pass
    }

    private static Set<Integer> getUniqueSequences(SequenceGeneratorUsingSynchronizedMethod generator, int count) throws InterruptedException, ExecutionException {
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
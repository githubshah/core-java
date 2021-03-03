package learning.core.aaJava8.stream8.more;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelStreamDemo {
    public static void main(String[] args) {
        forkJoinPool();
    }

    private static void forkJoinPool() {
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
        System.out.println("getParallelism=" + ForkJoinPool.commonPool().getParallelism());

        int range = 1000;

        IntStream rangeStream = IntStream.range(1, range); // create a 1 to N list

        sequence(rangeStream.asLongStream()); // sequence stream

        parallel(rangeStream.parallel());  // parallel stream
    }

    private static void sequence(LongStream sequenceStream) {
        long time1 = new Date().getTime();
        sequenceStream.forEach(x -> {
            delay();
        });
        System.out.println("sequence: " + (new Date().getTime() - time1));
    }

    private static void parallel(IntStream parallelStream) {
        long time = new Date().getTime();
        parallelStream
            .forEach(x -> {
                delay();
            });
        System.out.println("parallel : " + (new Date().getTime() - time));
    }

    private static void delay() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
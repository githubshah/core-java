package learning.core.aaJava8.stream8.more;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.BaseStream;
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

        IntStream rangeStream1 = IntStream.range(1, range); // create a 1 to N list
        IntStream rangeStream2 = IntStream.range(1, range); // create a 1 to N list

        compute(rangeStream1.asLongStream()); // sequence stream

        compute(rangeStream2.parallel());  // parallel stream
    }

    private static void compute(BaseStream sequenceStream) {
        long time1 = new Date().getTime();
        if (sequenceStream instanceof LongStream) {
            ((LongStream) sequenceStream).forEach(x -> {
                delay();
            });
            System.out.println("sequential: " + (new Date().getTime() - time1));
        } else {
            ((IntStream) sequenceStream)
                .forEach(x -> {
                    delay();
                });
            System.out.println("parallel: " + (new Date().getTime() - time1));
        }
    }

    private static void delay() {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
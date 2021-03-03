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
        int delayValue = 2;

        IntStream rangeStream1 = IntStream.range(1, range); // create a 1 to N list
        IntStream rangeStream2 = IntStream.range(1, range); // create a 1 to N list

        long time1 = new Date().getTime();
        rangeStream1.asLongStream().forEach(x -> {
            delay(delayValue);
        });
        System.out.println("sequential: " + (new Date().getTime() - time1));

        long time2 = new Date().getTime();
        rangeStream2.parallel().forEach(x -> {
            delay(delayValue);
        });
        System.out.println("parallel: " + (new Date().getTime() - time2));
    }

    private static void delay(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
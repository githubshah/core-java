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
//        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
        System.out.println("getParallelism=" + ForkJoinPool.commonPool().getParallelism());

        int range = 5000;
        int delayValue = 2;

        IntStream rangeStream1 = IntStream.range(1, range); // create a 1 to N list
        sequential(delayValue, rangeStream1);

        //IntStream rangeStream2 = IntStream.range(1, range); // create a 1 to N list
        //parallelStream(delayValue, rangeStream2);
    }

    private static void sequential(int delayValue, IntStream rangeStream1) {
        long time1 = new Date().getTime();
        rangeStream1.asLongStream().forEach(x -> {
            delay(delayValue);
        });
        System.out.println("sequential: " + (new Date().getTime() - time1));
    }

    private static void parallelStream(int delayValue, IntStream rangeStream2) {
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
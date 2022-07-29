package learning.core.multiThreading.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TxtReader implements Runnable {
    private String threadName;
    private String fileName;
    private CyclicBarrier cb;

    TxtReader(String threadName, String fileName, CyclicBarrier cb) {
        this.threadName = threadName;
        this.fileName = fileName;
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println("Reading file " + fileName + " thread " + threadName);
        try {
            Thread.sleep(200);
            // calling await so the current thread suspends
            cb.await();

        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}
 class AfterAction implements Runnable {
    @Override
    public void run() {
        System.out.println("In after action class, start further processing as all files are read");
    }
}

package learning.core.multiThreading.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemoMainWait {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4, new AfterAction());
        // Initializing three threads to read 3 different files.
        Thread t1 = new Thread(new TxtReader("thread-1", "file-1", cb));
        Thread t2 = new Thread(new TxtReader("thread-2", "file-2", cb));
        Thread t3 = new Thread(new TxtReader("thread-3", "file-3", cb));
        t1.start();
        t2.start();
        t3.start();

        try {
            cb.await(); // set parties from 3 to 4 and main thread is 4th thread to wait on cyclic
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done "); // main thread will wait of other threads execution due to await in above line.
        // if we have multiple phase then await will fail on Main method.
    }
}


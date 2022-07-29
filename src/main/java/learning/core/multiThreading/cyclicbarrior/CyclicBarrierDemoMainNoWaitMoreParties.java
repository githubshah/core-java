package learning.core.multiThreading.cyclicbarrior;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemoMainNoWaitMoreParties {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cb = new CyclicBarrier(3, new AfterAction());
        // Initializing three threads to read 3 different files.
        Thread t1 = new Thread(new TxtReader("thread-1", "file-1", cb));
        Thread t2 = new Thread(new TxtReader("thread-2", "file-2", cb));
        Thread t3 = new Thread(new TxtReader("thread-3", "file-3", cb));
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000); // wait to complete 1 batch, only for user experience

        Thread t11 = new Thread(new TxtReader("thread-11", "file-11", cb));
        Thread t22 = new Thread(new TxtReader("thread-22", "file-22", cb));
        Thread t33 = new Thread(new TxtReader("thread-33", "file-33", cb));
        t11.start();
        t22.start();
        t33.start();

        Thread.sleep(1000); // wait to complete 1 batch, only for user experience

        Thread t111 = new Thread(new TxtReader("thread-111", "file-111", cb));
        Thread t222 = new Thread(new TxtReader("thread-222", "file-222", cb));
        Thread t333 = new Thread(new TxtReader("thread-333", "file-333", cb));
        t111.start();
        t222.start();
        t333.start();

        Thread.sleep(1000); // wait to complete 1 batch, only for user experience

        System.out.println("Done ");
    }
}
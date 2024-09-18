package learning.core.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;


interface A {
    int a = 1;

    default int get(){
        return a;
    }
}

abstract class B {
    public int a = 2;

    int get(){
        return a;
    }
}


public class StampedLockDemo extends B implements A {
    public static void main(String[] args) {
        StampedLockDemo stampedLockDemo = new StampedLockDemo();
        System.out.println(stampedLockDemo.get());

        StampedLock sl = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        // Runnable as lambda - optimistic read
        Runnable r1 = () -> {
            System.out.println("\t\tTry Optimistic lock");
            long stamp = sl.tryOptimisticRead();
            try {
                System.out.println("\t\tOptimistic locked");

                if (!sl.validate(stamp)) {
                    stamp = sl.readLock();
                    try {
                        System.out.println("\t\tread locked");
                    } finally {
                        sl.unlockRead(stamp);
                        System.out.println("\t\tread unlocked");
                    }
                }


                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("\t\tIn optimistic lock going to validate");
                System.out.println("\t\tIn optimistic lock " + sl.validate(stamp));
            } finally {
                System.out.println("\t\tTry Optimistic Unlock");
                sl.unlock(stamp);
                System.out.println("\t\tOptimistic Unlocked");
            }
        };

        // Runnable as lambda - Write lock
        Runnable r2 = () -> {
            System.out.println("Try write lock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long stamp = sl.writeLock();
            System.out.println("write locked");
            try {
                System.out.println("After getting write lock ");

            } finally {
                System.out.println("Try write unlock");
                sl.unlock(stamp);
                System.out.println("write unlocked");
            }
        };

        executor.submit(r2);
        // Optimistic read
        executor.submit(r1);
        executor.submit(r2);

        executor.shutdown();
    }

    @Override
    public int get() {
        return ((B)this).a;
    }
}
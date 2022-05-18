package learning.core.multiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        /*
         * Create CountDownLatch with 3 parties, when all 3 parties
         * will reach common barrier point CyclicBarrrierEvent will be
         * triggered i.e. run() method of CyclicBarrrierEvent will be called
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrrierEvent());
        System.out.println("CountDownLatch has been created with parties=3,"
                + " when all 3 parties will reach common barrier point "
                + "CyclicBarrrierEvent will be triggered");

        MyRunnable myRunnable1 = new MyRunnable(cyclicBarrier);

        //Create and start 3 threads
        new Thread(myRunnable1, "Thread-1").start();
        new Thread(myRunnable1, "Thread-2").start();
        new Thread(myRunnable1, "Thread-3").start();

        //Create and start 3 threads
        new Thread(myRunnable1, "Thread-4").start();
        new Thread(myRunnable1, "Thread-5").start();
        new Thread(myRunnable1, "Thread-6").start();
    }
}


class MyRunnable implements Runnable {

    CyclicBarrier cyclicBarrier;

    MyRunnable(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() +
                " is waiting for all other threads to reach common barrier point");

        try {
            Thread.sleep(1000);
            /*
             * when all 3 parties will call await() method (i.e. common barrier point)
             * CyclicBarrrierEvent will be triggered and all waiting threads will be released.
             */
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("As all threads have reached common barrier point "
                + Thread.currentThread().getName() +
                " has been released");
    }

}

class CyclicBarrrierEvent implements Runnable {
    public void run() {
        System.out.println("As all threads have reached common barrier point "
                + ", CyclicBarrrierEvent has been triggered");
    }

}
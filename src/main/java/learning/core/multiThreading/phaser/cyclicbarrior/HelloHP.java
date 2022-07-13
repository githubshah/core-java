package learning.core.multiThreading.phaser.cyclicbarrior;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Java Program to demonstrate how to use CyclicBarrier, * Its used when number of threads * needs to wait for each other before starting again. * * @author Javin Paul
 */
public class HelloHP {
    public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("****************** done set of work");
            }
        });
        Party first = new Party(1000, barrier, "PARTY-1");
        Party second = new Party(2000, barrier, "PARTY-2");
        Party third = new Party(1000, barrier, "PARTY-3");
        Party fourth = new Party(2000, barrier, "PARTY-4");
        first.start();
        second.start();
        third.start();
        fourth.start();
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}

class Party extends Thread {
    private int duration;
    private CyclicBarrier barrier;

    public Party(int duration, CyclicBarrier barrier, String name) {
        super(name);
        this.duration = duration;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration);
            System.out.println(Thread.currentThread().getName() + " is calling await()");
            barrier.await(5000, TimeUnit.MILLISECONDS);
            System.out.println(Thread.currentThread().getName() + " has started running again");
        } catch (InterruptedException  e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}


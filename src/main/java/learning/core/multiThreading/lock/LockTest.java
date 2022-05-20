package learning.core.multiThreading.lock;// Java code to illustrate Reentrant Locks

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class worker implements Runnable {
    String name;
    ReentrantLock re;

    public worker(ReentrantLock rl, String n) {
        re = rl;
        name = n;
    }

    public void run() {

        System.out.println("try to get lock task name - " + name);
        re.lock();
        System.out.println(">>>>>>>got to get lock task name - " + name);
        try {
            Thread.sleep(1500);
            System.out.println("job done from outer lock- " + name);
            //System.out.println("Lock Hold Count - " + re.getHoldCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("<<<<<<<released lock task name - " + name);
            re.unlock();
        }
    }
}

public class LockTest {
    static final int MAX_T = 2;

    public static void main(String[] args) {
        ReentrantLock rel = new ReentrantLock();
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        int i = 0;
        while (i++ <= 3) {
            Runnable w1 = new worker(rel, "Job_" + i);
            pool.execute(w1);
        }
        pool.shutdown();
    }
} 

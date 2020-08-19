package core.multiThreading.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable {

    // SimpleDateFormat is not thread-safe, so give one to each thread
    private static final ThreadLocal<Integer> formatter = ThreadLocal.withInitial(() -> 1);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get());
        ThreadLocalExample obj = new ThreadLocalExample();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(obj, "" + i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
        formatter.set(100);
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get());
    }

    @Override
    public void run() {
        System.out.println("Thread Name= " + Thread.currentThread().getName() + " default Formatter = " + formatter.get());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //formatter pattern is changed here by thread, but it won't reflect to other threads
        formatter.set(8);

        System.out.println("Thread Name= " + Thread.currentThread().getName() + " formatter = " + formatter.get());
    }

}

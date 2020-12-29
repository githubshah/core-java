package learning.core.multiThreading.notifyAndnotifyAll.notify;

class Shared {
    synchronized void waitMethod() {
        Thread t = Thread.currentThread();

        System.out.println(t.getName() + " is releasing the lock and going to wait");

        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.getName() + " has been notified and acquired the lock back");
    }

    synchronized void notifyOneThread() {
        Thread t = Thread.currentThread();

        notify();

        System.out.println(t.getName() + " has notified one thread waiting for this object lock");
    }
}

public class Notify {
    public static void main(String[] args) {
        final Shared s = new Shared();

        //Thread t1 will be waiting for lock of object 's'

        Thread t1 = new Thread(s::waitMethod);

        t1.start();

        //Thread t2 will be waiting for lock of object 's'

        Thread t2 = new Thread(s::waitMethod);

        t2.start();

        //Thread t3 will be waiting for lock of object 's'

        Thread t3 = new Thread(s::waitMethod);

        t3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Thread t4 will notify only one thread which is waiting for lock of object 's'

        Thread t4 = new Thread(s::notifyOneThread);

        t4.start();
    }
}
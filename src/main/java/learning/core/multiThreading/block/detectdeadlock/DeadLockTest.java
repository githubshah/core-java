package learning.core.multiThreading.block.detectdeadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class DeadLockTest {
    public static void main(String[] args) throws InterruptedException {
        final String resource1 = "apple";
        final String resource2 = "mango";
        // t1 tries to lock resource1 then resource2
        Thread t1 = new Thread("apple") {
            public void run() {
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
            }
        };

        // t2 tries to lock resource2 then resource1
        Thread t2 = new Thread("mango") {
            public void run() {
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");

                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
            }
        };


        t1.start();
        t2.start();

        Thread.sleep(2000);

        findDeadlock();
    }

    public static void findDeadlock() {
        System.out.println("searching for dead lock");
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] threadIds = bean.findDeadlockedThreads(); // Returns null if no threads are deadlocked.

        if (threadIds != null) {
            ThreadInfo[] infos = bean.getThreadInfo(threadIds);

            for (ThreadInfo threadInfo1 : infos) {
                System.out.println("Deadlock thread: " + threadInfo1.getThreadName());
            }
        }
    }
}
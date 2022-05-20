package learning.core.multiThreading.producerconsumer.conditionJava8;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition {

    Stack<String> stack = new Stack<>();
    int CAPACITY = 2;

    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public static void main(String[] args) {
        ReentrantLockWithCondition stack = new ReentrantLockWithCondition();
        for (int i = 0; i <= 3; i++) {
            final String v = i + "";
            new Thread(() -> {
                try {
                    stack.pushToStack(v);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i <= 3; i++) {
            new Thread(() -> {
                try {
                    String s = stack.popFromStack();
                    System.out.println("pop " + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void pushToStack(String item) throws InterruptedException {
        try {
            System.out.println(">>try to lock for push");
            lock.lock();
            System.out.println("  >>locked for push");
            while (stack.size() == CAPACITY) {
                stackFullCondition.await(); // wait
            }
            stack.push(item);
            stackEmptyCondition.signalAll(); // notifyAll
        } finally {
            lock.unlock();
            System.out.println("  >>released for push");
        }
    }

    public String popFromStack() throws InterruptedException {
        try {
            System.out.println(">>try to lock for pop");
            lock.lock();
            System.out.println("  >>locked for pop");
            while (stack.size() == 0) {
                stackEmptyCondition.await(); // wait
            }
            return stack.pop();
        } finally {
            stackFullCondition.signalAll(); // notifyAll
            lock.unlock();
            System.out.println("  >>released for pop");
        }
    }
}
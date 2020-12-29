package learning.core.multiThreading.producerconsumer.conditionJava8;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockWithCondition {

    Stack<String> stack = new Stack<>();
    int CAPACITY = 5;

    ReentrantLock lock = new ReentrantLock();
    Condition stackEmptyCondition = lock.newCondition();
    Condition stackFullCondition = lock.newCondition();

    public void pushToStack(String item) throws InterruptedException {
        try {
            lock.lock();
            while (stack.size() == CAPACITY) {
                stackFullCondition.await(); // wait
            }
            stack.push(item);
            stackEmptyCondition.signalAll(); // notifyAll
        } finally {
            lock.unlock();
        }
    }

    public String popFromStack() throws InterruptedException {
        try {
            lock.lock();
            while (stack.size() == 0) {
                stackEmptyCondition.await(); // wait
            }
            return stack.pop();
        } finally {
            stackFullCondition.signalAll(); // notifyAll
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockWithCondition stack = new ReentrantLockWithCondition();
        for (int i = 0; i <= 100; i++) {
            final String v = i + "";
            new Thread(() -> {
                try {
                    stack.pushToStack(v);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        for (int i = 0; i <= 100; i++) {
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
}
package core.multiThreading;

// Java Program to illustrate the
// concept of interrupt() method 
// while a thread does not stops working 
class InterruptedTest extends Thread {
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occur");
        }
    }
}

class Test {
    public static void main(String[] args) throws InterruptedException {
        InterruptedTest thread = new InterruptedTest();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        System.out.println("Main thread execution completes");
    }
} 

package core.multiThreading;

// Java Program to illustrate the
// concept of interrupt() method 
// while a thread does not stops working 
class InterruptedTest extends Thread {
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            // heavy wait / sleep
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(
                    "InterruptedException occur" +
                        Thread.currentThread().isInterrupted()); // set interrupted  = false

                // need to interrupt thread again else loop will continue
                //Thread.currentThread().interrupt(); // with this comment while going infinity
            }
        }
        System.out.println("Child thread completed");
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

package core.multiThreading;

// Java Program to illustrate the
// concept of interrupt() method 
// while a thread does not stops working 
class InterruptedTest extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 500; i++) {
                System.out.println("Child Thread executing and going to wait for 5 sec");

                // Here current threads goes to sleeping state
                // Another thread gets the chance to execute
                Thread.sleep(5000);
                System.out.println("Awake from sleep Child Thread executing");
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException occur");
        }
    }
}

class Test {
    public static void main(String[] args)
        throws InterruptedException {
        InterruptedTest thread = new InterruptedTest();
        thread.start();

        // main thread calls interrupt() method on
        // child thread
        Thread.sleep(15000);
        thread.interrupt();
        System.out.println("Main thread, stopped child thread");
        System.out.println("Main thread execution completes");
    }
} 

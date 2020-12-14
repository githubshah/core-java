package core.multiThreading.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerNotifyPattern {

    public static void main(String args[]) {

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer2(sharedQueue));
        Thread consThread = new Thread(new Consumer2(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }

}

//Producer Class in java
class Producer2 implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer2(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Producer2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}

//Consumer Class in Java
class Consumer2 implements Runnable {

    private final BlockingQueue sharedQueue;

    public Consumer2(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + sharedQueue.take());
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


}
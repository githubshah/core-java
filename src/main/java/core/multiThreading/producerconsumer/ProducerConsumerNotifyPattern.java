package core.multiThreading.producerconsumer;

import java.util.Date;

class SharedResource {
    Long value = 0L;
    boolean hasValue = false;

    synchronized public Long getLong() {
        Long temp = this.value;
        value = 0L; // reset
        this.hasValue = false;
        return temp;
    }

    synchronized public void setLong(Long value) {
        this.value = value;
        this.hasValue = true;
    }

    synchronized public boolean isHasValue() {
        return hasValue;
    }
}

public class ProducerConsumerNotifyPattern {

    public static void main(String args[]) {

        //Creating shared object
        SharedResource sharedResource = new SharedResource();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer2(sharedResource), "prod1");
        Thread consThread = new Thread(new Consumer2(sharedResource), "con");
        Thread consThread1 = new Thread(new Consumer2(sharedResource), "con1");
        Thread consThread2 = new Thread(new Consumer2(sharedResource), "con2");

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
        consThread1.start();
        consThread2.start();
    }

}

//Producer Class in java
class Producer2 implements Runnable {

    SharedResource sharedResource;

    public Producer2(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedResource) {
                if (!sharedResource.isHasValue()) {
                    sharedResource.setLong(new Date().getTime());
                    try {
                        Thread.sleep(1000);
                        System.out.println("Produced element and notifying to all");
                        notifyAll();
                    } catch (Exception e) {
                    }
                } else {
                    try {
                        wait();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}

//Consumer Class in Java
class Consumer2 implements Runnable {

    SharedResource sharedResource;

    public Consumer2(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (sharedResource) {
                if (!sharedResource.isHasValue()) {
                    try {
                        wait();
                    } catch (Exception e) {
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() +
                        " Consumed: " + sharedResource.getLong());
                    try {
                        notifyAll();
                    } catch (Exception e) {
                    }
                }
            }
        }
    }
}
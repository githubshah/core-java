package core.multiThreading.visiblity.solution;

public class VolatileTest {
    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new Consumer().start();
        new Producer().start();
    }

    static class Consumer extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT; // see 12:00, thread A on it
            while (local_value < 5) {
                if (local_value != MY_INT) {  // see 12:02 but thread B updated MY_INT value on 12:01
                    System.out.println("Got Change for MY_INT : " + MY_INT);
                    local_value = MY_INT;
                }
            }
        }
    }

    static class Producer extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while (MY_INT < 5) {
                System.out.println("Incrementing MY_INT to " + (local_value + 1));
                MY_INT = ++local_value; // 12:01 thread B updated MY_INT value
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
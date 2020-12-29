package learning.core.multiThreading.visiblity.problem;

public class Acknowledge {
    // Initializing volatile variables
    static boolean flag = true;

    public static void main(String[] args) {

        // Creating an instance t1 of
        // Thread class
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("Start t1 thread with " + flag);
                for (int i = 0; i <= 10; i++) {
                    delay(1000);
                }
                flag = false;
                System.out.println("End t1 thread");
            }
        };

        // Creating an instance t2 of
        // Thread class
        Thread t2 = new Thread() {
            public void run() {
                boolean temp = flag;
                System.out.println("Start t2 thread with " + temp);
                while (temp) {
                    temp = flag;
                }
                System.out.println("End t2 thread " + temp);
            }
        };

        // Starting instance t1 and t2
        t1.start();
        t2.start();

        delay(15000);
        System.out.println("completed thread..");
    }

    private static void delay(int i2) {
        try {
            Thread.sleep(i2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

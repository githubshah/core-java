package core.multiThreading.control.problem;

class Resources {
    boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class AcknowledgeTest {
    // Initializing volatile variables
    static volatile Resources flag = new Resources();

    public static void main(String[] args) {

        // Creating an instance t1 of
        // Thread class
        Thread t1 = new Thread() {
            public void run() {
                System.out.println("Start t1 thread with " + flag.isFlag());
                for (int i = 0; i <= 10; i++) {
                    delay(100);
                }
                flag.setFlag(false);
                System.out.println("End t1 thread");
            }
        };

        // Creating an instance t2 of
        // Thread class
        Thread t2 = new Thread() {
            public void run() {
                boolean temp = flag.isFlag();
                System.out.println("Start t2 thread with " + temp);
                while (temp) {
                    temp = flag.isFlag();
                }
                System.out.println("End t2 thread " + temp);
            }
        };

        // Starting instance t1 and t2
        t1.start();
        t2.start();

        delay(5000);
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

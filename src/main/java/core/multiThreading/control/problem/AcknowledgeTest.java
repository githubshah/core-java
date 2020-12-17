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

class ThreadA implements Runnable {
    Resources flag;

    public ThreadA(Resources flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println("Start t1 thread with " + flag.isFlag());
        for (int i = 0; i <= 10; i++) {
            delay(100);
        }
        flag.setFlag(false);
        System.out.println("End t1 thread");
    }

    private static void delay(int i2) {
        try {
            Thread.sleep(i2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AcknowledgeTest {
    // Initializing volatile variables
    static volatile Resources flag = new Resources();

    public static void main(String[] args) throws InterruptedException {

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
        Thread thread = new Thread(new ThreadA(flag));
        thread.start();

        t2.start();

        t2.join();
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

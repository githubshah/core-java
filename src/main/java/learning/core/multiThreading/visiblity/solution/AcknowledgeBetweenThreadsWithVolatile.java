package learning.core.multiThreading.visiblity.solution;

class Resources {
    boolean flag = true;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class ThreadB implements Runnable {
    Resources flag;

    public ThreadB(Resources flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        boolean temp = flag.isFlag();
        System.out.println("Start t2 thread with " + temp);
        while (temp) {
            temp = flag.isFlag();
        }
        System.out.println("End t2 thread " + temp);
    }

    private static void delay(int i2) {
        try {
            Thread.sleep(i2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        System.out.println("End t1 thread " + flag.isFlag());
    }

    private static void delay(int i2) {
        try {
            Thread.sleep(i2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class AcknowledgeBetweenThreadsWithVolatile {
    static Resources flag = new Resources();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadA(flag));
        t1.start();

        Thread t2 = new Thread(new ThreadB(flag));
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

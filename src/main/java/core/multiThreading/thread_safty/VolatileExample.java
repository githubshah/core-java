package core.multiThreading.thread_safty;

public class VolatileExample {

    // Initializing volatile variables
    // a, b
    static volatile int a = 0, b = 0;

    // Defining a static void method
    static void method_one() {
        int x = a;
        int y = b;
        x++;
        y++;
        a = x;
        b = y;
    }

    // Defining static void method
    static void method_two() {
        int x = a;
        int y = b;
        if (x != y)
            System.out.println(
                "a=" + x + " b=" + y);
    }

    public static void main(String[] args) {

        // Creating an instance t1 of
        // Thread class
        Thread t1 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    method_one();
                    yield();
                }
            }
        };

        // Creating an instance t2 of
        // Thread class
        Thread t2 = new Thread() {
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    method_two();
                    yield();
                }
            }
        };

        // Starting instance t1 and t2
        t1.start();
        t2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package learning.core.multiThreading.semaphore;

public class SlowService {
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

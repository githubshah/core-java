package learning.core.multiThreading.executorServices.customThreadpool;


import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing  : " + name + " : " + Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CustomThreadPoolExample {
    public static void main(String[] args) {
        CustomThreadPool customThreadPool = new CustomThreadPool(2); // it creates two thread in the pool and start them on the creation of pool

        for (int i = 1; i <= 2; i++) {
            Task task = new Task("Task " + i);
            System.out.println("submitted task : " + task.getName());
            customThreadPool.execute(task);
        }

        customThreadPool.shutdown();
    }
}
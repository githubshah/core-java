package learning.core.multiThreading.executorServices.customThreadpool;

import java.util.concurrent.LinkedBlockingQueue;

@SuppressWarnings("unused")
public class CustomThreadPool {
    //Thread pool size
    private final int poolSize;

    //Internally pool is an array
    private final WorkerThread[] workers;

    // FIFO ordering
    private final LinkedBlockingQueue<Runnable> queue;
    volatile boolean shutdown = false;

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new WorkerThread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            WorkerThread workerThread = new WorkerThread();
            workerThread.setName("worked_thread_"+i);
            workers[i] = workerThread;
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }

    public void shutdown() {
        System.out.println("Shutting down thread pool");
        for (int i = 0; i < poolSize; i++) {
            WorkerThread worker = workers[i];
            worker.stopped();
            //workers[i] = null;
        }
    }

    private class WorkerThread extends Thread {

        boolean isRunning = true;
        public void stopped(){
            this.isRunning = false;
        }
        public void run() {
            Runnable task;

            while (isRunning) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("Thread: "+ currentThread().getName() +" try to pick task");
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = (Runnable) queue.poll();
                    System.out.println("Thread: "+ currentThread().getName() +" picked task: "+((Task)task).getName());
                }

                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
}

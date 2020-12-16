package core.multiThreading.threadlocal.solution;

class Resource {
    int id;
    ThreadLocal<Resource> threadLocal = ThreadLocal.withInitial(() -> new Resource(id));

    Resource(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Resource getThreadLocal() {
        return threadLocal.get();
    }
}

class ThreadRun implements Runnable {
    Resource number;
    int value;

    ThreadRun(Resource number, int value) {
        this.number = number;
        this.value = value;
    }

    @Override
    public void run() {
        number = number.getThreadLocal();
        System.out.println(Thread.currentThread().getName() + ": initial value: " + number.getId() + " and value to add : " + value);
        number.setId(number.getId() + value);
        System.out.println(Thread.currentThread().getName() + ": after set: " + number.getId());
        System.out.println("\n");
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        Resource resource = new Resource(1);
        Thread thread1 = new Thread(new ThreadRun(resource, 10), "thread1");
        Thread thread2 = new Thread(new ThreadRun(resource, 10), "thread2");
        thread1.start();
        thread2.start();
    }
}

/**
 * output: 2 3 this output is our expected output
 * <p>
 * But when you comment
 * // number = number.getThreadLocal();
 * and run program output will be output: 3 4
 * So the data is corrupted when // number = number.getThreadLocal();
 * is commented.So threadlocal make a local copy of NumberValue .
 * But when threadlocal is not used same object instance is shared between threads ,
 * so data result is corrupted than actaul result
 */

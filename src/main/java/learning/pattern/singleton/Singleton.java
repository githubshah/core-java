package learning.pattern.singleton;

public class Singleton {
    static Singleton singleton;

    private Singleton() throws InterruptedException {
        System.out.println("Private constructor");
    }

    public static Singleton getInstance() throws InterruptedException {
        if (singleton == null) { // if instance has been created then why blocked piece of code.
            synchronized (Singleton.class) {
                // without synchronized many thread can picked singleton = null
                if (singleton == null) singleton = new Singleton(); // constructor empty resource
            }
        }
        return singleton;
    }
}

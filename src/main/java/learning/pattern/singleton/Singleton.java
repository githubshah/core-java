package learning.pattern.singleton;

public class Singleton {
    static Singleton singleton;

    private Singleton() {
        System.out.println("Private constructor");
    }

    public static Singleton getInstance() throws InterruptedException {
        if (singleton == null) { // if instance has been created at line 14 then why other thread going to block here.
            synchronized (Singleton.class) {
                // without synchronized many thread can pick singleton = null
                if (singleton == null) singleton = new Singleton(); // constructor empty resource
            }
        }
        return singleton;
    }
}

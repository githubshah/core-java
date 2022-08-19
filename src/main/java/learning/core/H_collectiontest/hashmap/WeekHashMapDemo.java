package learning.core.H_collectiontest.hashmap;

import java.util.WeakHashMap;

class WeekHashMapDemo {
    public static void main(String args[]) throws Exception {
        WeakHashMap<Demo, String> m = new WeakHashMap();
        Demo d = new Demo();

        // puts an entry into WeakHashMap
        m.put(d, " Hi ");
        System.out.println(m);

        d = null;

        // garbage collector is called
        System.gc();

        // thread sleeps for 1 sec
        Thread.sleep(1000);

        System.out.println(m);
    }
}

class Demo {
    public String toString() {
        return "demo";
    }

    // finalize method
    public void finalize() {
        System.out.println("finalize method is called");
    }
}

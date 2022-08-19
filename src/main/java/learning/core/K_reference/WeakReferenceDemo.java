package learning.core.K_reference;


import java.lang.ref.WeakReference;

class Demo {
    public void fun() {
        System.out.println("demo called");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize called");
    }
}

public class WeakReferenceDemo {

    public static void main(String[] args) {

        Demo d = new Demo();
        d.fun();
        WeakReference<Demo> weakRef = new WeakReference<>(d);

        d = null;

        System.gc(); // flush the d object from garbage collector

        Demo demo = weakRef.get();
        demo.fun(); // null pointer exception

    }
}

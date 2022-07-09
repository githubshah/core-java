package learning.core.reference;


import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

class Demo1 {
    public void fun() {
        System.out.println("demo called");
    }
}

public class SoftReferenceDemo {

    public static void main(String[] args) {

        Demo1 d = new Demo1();
        d.fun();
        SoftReference<Demo1> softReference = new SoftReference<>(d);

        d = null;

        System.gc(); // do not flush the d object from garbage collector, it will do once jvm needs memory.

        Demo1 demo = softReference.get();
        demo.fun();  // non null

    }
}

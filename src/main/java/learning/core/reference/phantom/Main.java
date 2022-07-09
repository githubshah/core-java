package learning.core.reference.phantom;

import java.lang.ref.*;

public class Main {

   public static void main(String[] args) throws InterruptedException {
       Thread.sleep(10000);

       ReferenceQueue<TestClass> queue = new ReferenceQueue<>();
       Reference ref = new MyPhantomReference<>(new TestClass(), queue);

       System.out.println("ref = " + ref);

       Thread.sleep(5000);

       System.out.println("Collecting garbage!");

       System.gc();
       Thread.sleep(300);

       System.out.println("ref = " + ref);

       Thread.sleep(5000);

       System.out.println("Collecting garbage!");

       System.gc();
   }
}

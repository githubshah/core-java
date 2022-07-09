package learning.core.reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class MyPhantomReference<TestClass> extends PhantomReference<TestClass> {

   public MyPhantomReference(TestClass obj, ReferenceQueue<TestClass> queue) {

       super(obj, queue);

       Thread thread = new QueueReadingThread<TestClass>(queue);

       thread.start();
   }

   public void cleanup() {
       System.out.println("Cleaning up a phantom reference! Removing an object from memory!");
       clear();
   }
}
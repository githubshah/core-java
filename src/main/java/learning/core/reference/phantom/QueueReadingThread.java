package learning.core.reference.phantom;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class QueueReadingThread<TestClass> extends Thread {

   private ReferenceQueue<TestClass> referenceQueue;

   public QueueReadingThread(ReferenceQueue<TestClass> referenceQueue) {
       this.referenceQueue = referenceQueue;
   }

   @Override
   public void run() {

       System.out.println("The thread monitoring the queue has started!");
       Reference ref = null;

       // Wait until the references appear in the queue
       while ((ref = referenceQueue.poll()) == null) {

           try {
               Thread.sleep(50);
           }

           catch (InterruptedException e) {
               throw new RuntimeException("Thread " + getName() + " was interrupted!");
           }
       }

       // As soon as a phantom reference appears in the queue, clean it up
       ((MyPhantomReference) ref).cleanup();
   }
}
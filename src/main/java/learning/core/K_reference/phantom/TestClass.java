package learning.core.K_reference.phantom;

public class TestClass {
   private StringBuffer data;
   public TestClass() {
       this.data = new StringBuffer();
       for (long i = 0; i < 50000000; i++) {
           this.data.append('x');
       }
   }
   @Override
   protected void finalize() {
       System.out.println("The finalize method has been called on the TestClass object");
   }

}


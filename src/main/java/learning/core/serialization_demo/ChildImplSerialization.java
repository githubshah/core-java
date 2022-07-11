package learning.core.serialization_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;;
 
class superclass {
      int i;
      public superclass(int i) {
           this.i = i;
      }
      public superclass() {
           System.out.println("Superclass constructor called");
     }
}
class subclass extends superclass implements Serializable {
      int j;
      public subclass(int i, int j) {
            super(i);
            this.j = j;
      }
}
public class ChildImplSerialization {
      public static void main(String[] args) throws Exception {
            subclass b1 = new subclass(10, 20);
            System.out.println("i = " + b1.i);
            System.out.println("j = " + b1.j);
            FileOutputStream fos = new FileOutputStream("output.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(b1);
            oos.close();
            fos.close();
            System.out.println("The object has been serialized");
            FileInputStream fis = new FileInputStream("output.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            subclass b2 = (subclass) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("The object has been deserialized");
            System.out.println("i = " + b2.i);
            System.out.println("j = " + b2.j);
      }
}
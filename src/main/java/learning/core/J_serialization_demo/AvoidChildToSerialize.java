package learning.core.J_serialization_demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
 
class Parent implements Serializable {
       int i;
       public Parent(int i) {
             this.i = i;
       }
}
 
class child extends Parent {
        int j;
        public child(int i, int j) {
               super(i);
               this.j = j;
        }
        private void writeObject(ObjectOutputStream out) throws IOException {
               throw new NotSerializableException();
        }
        private void readObject(ObjectInputStream in) throws IOException {
               throw new NotSerializableException();
        }
}
 
public class AvoidChildToSerialize {
        public static void main(String[] args) throws Exception {
               child b1 = new child(100, 200);
               System.out.println("i = " + b1.i);
               System.out.println("j = " + b1.j);
               FileOutputStream fos = new FileOutputStream("abc.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
               oos.writeObject(b1);
               oos.close();
               fos.close();
               System.out.println("Object has been serialized");
               FileInputStream fis = new FileInputStream("abc.ser");
               ObjectInputStream ois = new ObjectInputStream(fis);
               child b2 = (child) ois.readObject();
               ois.close();
               fis.close();
               System.out.println("Object has been deserialized");
               System.out.println("i = " + b2.i);
               System.out.println("j = " + b2.j);
       }
}
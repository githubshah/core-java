package learning.core.stringdemo;

public class StringIntern {

    public static void main(String[] args) {
        String a = "howtodoinjava";
        String b = "howtodoinjava";

        String c = new String("howtodoinjava");
        String d = c.intern();  // make a  copy in constant pool and return its reference.

        System.out.println(a==d);

        //In the above example,
        // strings a, b and d will refer to the same string literal in the SCP.
        // The string c will continue to point to the object in the heap.

    }
}

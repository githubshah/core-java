public class Main {

    public static void main(String[] args) {

        int i = 0;
        int j = 0;

        i = i++; // Noncompliant; i is still zero

        System.out.println(i);

        //===================================================
        StringBuffer foo = new StringBuffer('x');
        System.out.println(foo);

        StringBuffer fool = new StringBuffer("x");
        System.out.println(fool); // FIXME denominator value might be  0

        /*
        //
        Abstract classes should not have public constructors.
        Constructors of abstract classes can only be called in constructors of their subclasses.
        So there is no point in making them public.
        The protected modifier should be enough.

          public abstract class AbstractClass1 {
            public AbstractClass1 () { // Noncompliant, has public modifier
                // do something here
            }
        }*/

        abstract class AbstractClass12 {
            protected AbstractClass12() { // Noncompliant, has public modifier
                // do something here
            }
        }
    }
}

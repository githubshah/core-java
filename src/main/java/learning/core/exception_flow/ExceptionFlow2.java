package learning.core.exception_flow;

import java.io.IOException;

// if throw keyword throw :
//  checked exception then the same exception should be throws by method signature.
//  unchecked exception then the no need to throws by method signature.
class Parent {

    void fun1() {
        System.out.println("fun1 call");
        try {
            fun2();
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.out.println("handeled");
        }
    }

    void fun2() {
        System.out.println("fun2 call");
        try {
            fun3();
        } catch (IOException e) {
            System.out.println("error catch by fun2 " + e);
            throw new RuntimeException(e);
        }
    }

    void fun3() throws IOException {  // should be throws by method signature.
        System.out.println("fun3 call");
        try {
            fun4();
        } catch (RuntimeException e) {
            System.out.println("error catch by fun3 " + e);
            throw new IOException(e);
        }
    }

    void fun4() { // no need to throws by method signature.
        System.out.println("fun4 call");
        throw new RuntimeException("ddddd");
    }
}


public class ExceptionFlow2 {

    public static void main(String[] args) {
        new Parent().fun1();
    }
}

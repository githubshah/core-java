package learning.core.F_exception_and_error_flow;

public class HandelError {
    public static void main(String[] args) {
        // insert code here
        try {
            new HandelError().go();
            throw new OutOfMemoryError();
            //throw new java.lang.StackOverflowError();
        } catch (Error e) {
            System.out.println("\nerror caught: " + e);
        }
    }

    void go() {
        System.out.print(".");
        go();
    }
}
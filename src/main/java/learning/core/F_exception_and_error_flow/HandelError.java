package learning.core.F_exception_and_error_flow;

public class HandelError {
    public static void main(String[] args) {
        // insert code here
        try {
            //new Example().go();
            throw new OutOfMemoryError();
        } catch (Error e) {
            System.out.println("\n" + e);
        }
    }

    void go() {
        System.out.print(".");
        go();
    }
}
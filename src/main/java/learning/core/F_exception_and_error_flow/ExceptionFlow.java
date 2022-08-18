package learning.core.F_exception_and_error_flow;

//return always from the top of the stack
public class ExceptionFlow {

    public static void main(String[] args) {
        System.out.println("main " + call());
        System.out.println("main " + caldefault());
    }

    private static int call() {
        int i = 100;
        try {
            //return 10;
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("catch 1");
            return ++i;
        } finally {
            System.out.println("final 2 " + i);
            return 7000;
        }
    }


    private static String caldefault() {
        String i = "default";
        try {
            //return 10;
            throw new RuntimeException();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch 1");
            return i + " catch";
        } finally {
            System.out.println("final 2");
            return i + " finally";
        }
    }
}

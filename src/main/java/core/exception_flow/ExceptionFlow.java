package core.exception_flow;

//return always from the top of the stack
public class ExceptionFlow {

    public static void main(String[] args) {
        System.out.println("main "+call());
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
            System.out.println("final 2");
            return i+700;
        }
    }
}

package exception_flow;

//return always from the top of the stack
public class ExceptionFlow {

    public static void main(String[] args) {
        System.out.println(call());
    }

    private static int call() {
        int i = 100;
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("1");
            return i + 100;
        } finally {
            System.out.println("2");
        }
    }
}

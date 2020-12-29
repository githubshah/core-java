package learning.core.aaJava8.stream8.lambdas;

public class OrdinaryPractice {

    public static void main(String as[]) {

        int sum = sumOf(15, 3);
        int sub = subOf(15, 3);
        int mul = mulOf(15, 3);
        int div = divOf(15, 3);

    }

    private static int divOf(int a, int b) {
        return a / b;
    }

    private static int mulOf(int a, int b) {
        return a * b;

    }

    private static int subOf(int a, int b) {
        return a - b;
    }

    private static int sumOf(int a, int b) {
        return a + b;
    }

}

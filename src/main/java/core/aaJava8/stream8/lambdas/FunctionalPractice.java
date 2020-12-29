package core.aaJava8.stream8.lambdas;

import java.util.function.BiFunction;

public class FunctionalPractice {

    public static void main(String as[]) {

        int sum = cal(15, 3, (a, b) -> a + b);
        int sub = cal(15, 3, (a, b) -> a - b);
        int mul = cal(15, 3, (a, b) -> a * b);
        int div = cal(15, 3, (a, b) -> a / b);

    }

    private static int cal(int a, int b,
                           BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }
}
